package br.edu.ifsp.aluno.poos3.domain.usecases.book;

import br.edu.ifsp.aluno.poos3.domain.utilities.utils.EntityNotFoundException;

public class RemoveBookUseCase {
    private final BookDAO bookDAO;

    public RemoveBookUseCase(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public boolean remove(Integer key) {
        if (key == null)
            throw new IllegalArgumentException("Key cannot be null");

        bookDAO.findOneByKey(key)
                .orElseThrow(() -> new EntityNotFoundException("This book has not been registered yet!"));
        return bookDAO.deleteByKey(key);
    }
}
