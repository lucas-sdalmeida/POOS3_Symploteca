package br.edu.ifsp.aluno.poos3.domain.utilities.utils;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
