package br.edu.ifsp.aluno.poos3.domain.usecases.user;

import br.edu.ifsp.aluno.poos3.domain.entities.user.User;
import br.edu.ifsp.aluno.poos3.domain.utilities.utils.EntityNotFoundException;
import br.edu.ifsp.aluno.poos3.domain.utilities.utils.Notification;

public class UpdateUserUseCase {
    private final UserDAO userDAO;

    public UpdateUserUseCase(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean update(User user) {
        UserRequestValidator validator = new UserRequestValidator();
        Notification notification = validator.validate(user);

        if (notification.hasErrors())
            throw new IllegalArgumentException(notification.getErrorMessage());

        userDAO.findOneByKey(user.getInstitutionalId())
                .orElseThrow(() -> new EntityNotFoundException("This user has not been registered yet!"));

        return userDAO.update(user);
    }
}
