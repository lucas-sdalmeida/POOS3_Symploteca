package br.edu.ifsp.aluno.poos3.domain.usecases.transaction;

import br.edu.ifsp.aluno.poos3.domain.entities.transaction.Transaction;

import java.util.Map;
import java.util.Optional;

public class FindTransactionUseCase {
    private final TransactionDAO transactionDAO;

    public FindTransactionUseCase(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    public Optional<Transaction> findOneByKey(Integer id) {
        if (id == null)
            throw new IllegalArgumentException("The transaction ID must be given!");
        return transactionDAO.findOneByKey(id);
    }

    public Optional<Transaction> findOpenTransactionByBookId(Integer bookId) {
        if (bookId == null)
            throw new IllegalArgumentException("The book ID must be given!");
        return transactionDAO.findOpenTransactionByBookId(bookId);
    }

    public Map<Integer, Transaction> findAll() {
        return transactionDAO.findAll();
    }
}
