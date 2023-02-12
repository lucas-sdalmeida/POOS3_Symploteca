package br.edu.ifsp.aluno.poos3.domain.usecases.book;

import br.edu.ifsp.aluno.poos3.domain.entities.book.Book;
import br.edu.ifsp.aluno.poos3.domain.utilities.utils.EntityNotFoundException;
import br.edu.ifsp.aluno.poos3.domain.utilities.utils.Notification;

public class UpdateBookUseCase {
    private final BookDAO bookDAO;

    public UpdateBookUseCase(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public boolean update(Book book, Integer key) {
        if (key == null)
            throw new IllegalArgumentException("Key cannot be 'null'!");

        BookRequestValidator validator = new BookRequestValidator();
        Notification notification = validator.validate(book);

        if (notification.hasErrors())
            throw new IllegalArgumentException(notification.getErrorMessage());

        bookDAO.findOneByKey(key)
                .orElseThrow(() -> new EntityNotFoundException("This book has not been registered yet!"));

        return bookDAO.update(book);
    }
}
