package br.edu.ifsp.aluno.poos3.domain.usecases.user;

import br.edu.ifsp.aluno.poos3.domain.entities.user.User;

import java.util.Map;
import java.util.Optional;

public class FindUserUseCase {
    private final UserDAO userDAO;

    public FindUserUseCase(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Optional<User> findOneByKey(String institutionalId) {
        if (institutionalId == null)
            throw new IllegalArgumentException("The institutional id must be given!");
        return userDAO.findOneByKey(institutionalId);
    }

    public Optional<User> findOneByEmail(String email) {
        if (email == null)
            throw new IllegalArgumentException("The email must be given!");
        return userDAO.findOneByEmail(email);
    }

    public Map<String, User> findAll() {
        return userDAO.findAll();
    }
}
