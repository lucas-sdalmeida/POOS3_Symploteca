package br.edu.ifsp.aluno.poos3.domain.usecases.transaction;

public class IllegalTransactionException extends RuntimeException {
    public IllegalTransactionException(String message) {
        super(message);
    }
}
