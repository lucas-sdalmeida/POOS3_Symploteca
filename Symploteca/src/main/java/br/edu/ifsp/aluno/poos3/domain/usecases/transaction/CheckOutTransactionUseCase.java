package br.edu.ifsp.aluno.poos3.domain.usecases.transaction;

import br.edu.ifsp.aluno.poos3.domain.entities.book.Book;
import br.edu.ifsp.aluno.poos3.domain.entities.book.BookStatus;
import br.edu.ifsp.aluno.poos3.domain.entities.transaction.Transaction;
import br.edu.ifsp.aluno.poos3.domain.entities.user.User;
import br.edu.ifsp.aluno.poos3.domain.usecases.book.FindBookUseCase;
import br.edu.ifsp.aluno.poos3.domain.usecases.book.UpdateBookUseCase;
import br.edu.ifsp.aluno.poos3.domain.usecases.user.FindUserUseCase;
import br.edu.ifsp.aluno.poos3.domain.usecases.user.UpdateUserUseCase;
import br.edu.ifsp.aluno.poos3.domain.usecases.user.UserDAO;
import br.edu.ifsp.aluno.poos3.domain.utilities.utils.EntityNotFoundException;

public class CheckOutTransactionUseCase {
    private final TransactionDAO transactionDAO;
    private final FindUserUseCase findUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final FindBookUseCase findBookUseCase;
    private final UpdateBookUseCase updateBookUseCase;

    public CheckOutTransactionUseCase(TransactionDAO transactionDAO,
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

    public Transaction checkOutBook(String userId, Integer bookId) {
        if (userId == null)
            throw new IllegalArgumentException("User's id must be given");
        if (bookId == null)
            throw new IllegalArgumentException("Book's id must be given");

        User user = findUserUseCase.findOneByKey(userId)
                    .orElseThrow(() -> new EntityNotFoundException("This user has not been registered yet!"));
        Book book = findBookUseCase.findOneByKey(bookId)
                    .orElseThrow(() -> new EntityNotFoundException("This book has not been registered yet!"));

        if (book.getStatus() == BookStatus.CHECKED_OUT)
            throw new IllegalTransactionException("The requested book is not available to check out!");
        if (user.isAbleToCheckOut())
            throw new IllegalTransactionException("This user exceeded their limit of books to check out!");

        Transaction transaction = new Transaction(book, user);
        book.setStatus(BookStatus.CHECKED_OUT);
        updateBookUseCase.update(book, bookId);
        user.increaseNumberOfCheckedOutBooks();
        updateUserUseCase.update(user);
        Integer transactionId = transactionDAO.insert(transaction);

        return transactionDAO.findOneByKey(transactionId).orElse(null);
    }
}
