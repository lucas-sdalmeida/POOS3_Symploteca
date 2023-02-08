package br.edu.ifsp.aluno.poos3.domain.usecases.book;

import br.edu.ifsp.aluno.poos3.domain.entities.book.Book;
import br.edu.ifsp.aluno.poos3.domain.utilities.utils.DAO;

import java.util.Map;
import java.util.Optional;

public interface BookDAO extends DAO<Book, Integer> {
    Optional<Book> findOneByISBN(String isbn);
}
