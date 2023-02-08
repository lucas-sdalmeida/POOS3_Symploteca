package br.edu.ifsp.aluno.poos3.domain.usecases.book;

import br.edu.ifsp.aluno.poos3.domain.entities.book.Book;

import java.util.Map;
import java.util.Optional;

public class FindBookUseCase {
    private final BookDAO bookDAO;

    public FindBookUseCase(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public Optional<Book> findOneByKey(Integer key) {
        if (key == null)
            throw new IllegalArgumentException("Key cannot be 'null'!");

        return bookDAO.findOneByKey(key);
    }

    public Optional<Book> findOneByISBN(String isbn) {
        if (isbn == null)
            throw new IllegalArgumentException("ISBN must be given!");

        return bookDAO.findOneByISBN(isbn);
    }

    public Map<Integer, Book> findAll() {
        return bookDAO.findAll();
    }
}
