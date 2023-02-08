package br.edu.ifsp.aluno.poos3.domain.usecases.book;

import br.edu.ifsp.aluno.poos3.domain.entities.book.Book;
import br.edu.ifsp.aluno.poos3.domain.utilities.utils.Notification;
import br.edu.ifsp.aluno.poos3.domain.utilities.utils.Validator;

public class BookRequestValidator extends Validator<Book> {
    @Override
    public Notification validate(Book book) {
        Notification notification = new Notification();

        if (book == null) {
            notification.addError("Book is null!");
            return notification;
        }
        if (Validator.isNullOrEmpty(book.getName()))
            notification.addError("Book name is null or empty!");
        if (Validator.isNullOrEmpty(book.getIsbn()))
            notification.addError("Book ISBN is null or empty!");
        if (Validator.isNullOrEmpty(book.getAuthors()))
            notification.addError("Book authors is null or empty!");
        if (Validator.isNullOrEmpty(book.getPublisher()))
            notification.addError("Book publisher is null or empty!");
        if (book.getEdition() <= 0)
            notification.addError("Book edition is 0 or lesser!");
        if (book.getNumberOfPages() <= 0)
            notification.addError("Book has 0 or less pages!");
        if (book.getGenre() == null)
            notification.addError("Book has no genre");
        if (book.getStatus() == null)
            notification.addError("Book has no known status");

        return notification;
    }
}
