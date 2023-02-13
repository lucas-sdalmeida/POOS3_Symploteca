package br.edu.ifsp.aluno.poos3.domain.usecases.transaction;

import br.edu.ifsp.aluno.poos3.domain.entities.book.Book;
import br.edu.ifsp.aluno.poos3.domain.entities.book.BookStatus;
import br.edu.ifsp.aluno.poos3.domain.entities.transaction.Transaction;
import br.edu.ifsp.aluno.poos3.domain.entities.user.User;
import br.edu.ifsp.aluno.poos3.domain.usecases.book.FindBookUseCase;
import br.edu.ifsp.aluno.poos3.domain.usecases.book.UpdateBookUseCase;
import br.edu.ifsp.aluno.poos3.domain.usecases.user.FindUserUseCase;
import br.edu.ifsp.aluno.poos3.domain.usecases.user.UpdateUserUseCase;
import br.edu.ifsp.aluno.poos3.domain.utilities.utils.EntityNotFoundException;

import java.time.LocalDate;

public class ReturnTransactionUseCase {
    private final TransactionDAO transactionDAO;
    private final FindUserUseCase findUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final FindBookUseCase findBookUseCase;
    private final UpdateBookUseCase updateBookUseCase;

    public ReturnTransactionUseCase(TransactionDAO transactionDAO,
                                    FindUserUseCase findUserUseCase,
                                    UpdateUserUseCase updateUserUseCase,
                                    FindBookUseCase findBookUseCase,
                                    UpdateBookUseCase updateBookUseCase) {
        this.transactionDAO = transactionDAO;
        this.findUserUseCase = findUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.findBookUseCase = findBookUseCase;
        this.updateBookUseCase = updateBookUseCase;
    }

    public boolean returnBook(Integer bookId) {
        if (bookId == null)
            throw new IllegalArgumentException("The book id must be given!");

        Transaction transaction = transactionDAO.findOpenTransactionByBookId(bookId)
                    .orElseThrow(() ->
                        new EntityNotFoundException("There is not an open transaction with this book!")
                    );
        Book book = findBookUseCase.findOneByKey(bookId)
                    .orElseThrow(() ->
                        new EntityNotFoundException("This book has not been registered yet!")
                    );
        User user = findUserUseCase.findOneByKey(transaction.getUser().getInstitutionalId())
                    .orElseThrow(() ->
                        new EntityNotFoundException("The user of this transaction has not been registered!")
                    );
        transaction.setReturnDate(LocalDate.now());
        book.setStatus(BookStatus.AVAILABLE);
        user.decreaseNumberOfCheckedOutBooks();
        updateBookUseCase.update(book, bookId);
        updateUserUseCase.update(user);

        return transactionDAO.update(transaction);
    }
}
