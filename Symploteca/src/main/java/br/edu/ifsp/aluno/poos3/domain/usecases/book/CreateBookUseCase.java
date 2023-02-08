package br.edu.ifsp.aluno.poos3.domain.usecases.book;

import br.edu.ifsp.aluno.poos3.domain.entities.book.Book;
import br.edu.ifsp.aluno.poos3.domain.utilities.utils.EntityAlreadyExistsException;
import br.edu.ifsp.aluno.poos3.domain.utilities.utils.Notification;
import br.edu.ifsp.aluno.poos3.domain.utilities.utils.Validator;

public class CreateBookUseCase {
    private final BookDAO bookDAO;

    public CreateBookUseCase(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public Integer insert(Book book) {
        Validator<Book> validator = new BookRequestValidator();
        Notification notification = validator.validate(book);

        if (notification.hasErrors())
            throw new IllegalArgumentException(notification.getErrorMessage());

        bookDAO.findOneByISBN(book.getIsbn())
                .ifPresent(b -> {
                    throw new EntityAlreadyExistsException("Book has already been registered");
                });

        return bookDAO.insert(book);
    }
}
