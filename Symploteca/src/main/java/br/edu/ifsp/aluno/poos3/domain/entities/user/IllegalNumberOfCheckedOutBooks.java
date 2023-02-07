package br.edu.ifsp.aluno.poos3.domain.entities.user;

public class IllegalNumberOfCheckedOutBooks extends RuntimeException{
    public IllegalNumberOfCheckedOutBooks(String message) {
        super(message);
    }
}
