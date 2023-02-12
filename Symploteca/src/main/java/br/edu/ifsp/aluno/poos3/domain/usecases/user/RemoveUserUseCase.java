package br.edu.ifsp.aluno.poos3.domain.usecases.user;

import br.edu.ifsp.aluno.poos3.domain.utilities.utils.EntityNotFoundException;

public class RemoveUserUseCase {
    private final UserDAO userDAO;

    public RemoveUserUseCase(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean remove(String id) {
        if (id == null)
            throw new IllegalArgumentException("User's id must be given!");

        userDAO.findOneByKey(id)
                .orElseThrow(() -> new EntityNotFoundException("This user has not been registered yet!"));

        return userDAO.deleteByKey(id);
    }
}
