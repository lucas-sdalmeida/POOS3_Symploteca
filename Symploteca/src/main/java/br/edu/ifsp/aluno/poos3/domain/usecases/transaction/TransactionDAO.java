package br.edu.ifsp.aluno.poos3.domain.usecases.transaction;

import br.edu.ifsp.aluno.poos3.domain.entities.transaction.Transaction;
import br.edu.ifsp.aluno.poos3.domain.utilities.utils.DAO;

import java.util.Optional;

public interface TransactionDAO extends DAO<Transaction, Integer> {
    Optional<Transaction> findOpenTransactionByBookId(Integer bookId);
}
