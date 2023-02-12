package br.edu.ifsp.aluno.poos3.domain.usecases.user;

import br.edu.ifsp.aluno.poos3.domain.entities.user.User;
import br.edu.ifsp.aluno.poos3.domain.utilities.utils.DAO;

import java.util.Optional;

public interface UserDAO extends DAO<User, String> {
    Optional<User> findOneByEmail(String email);
}
