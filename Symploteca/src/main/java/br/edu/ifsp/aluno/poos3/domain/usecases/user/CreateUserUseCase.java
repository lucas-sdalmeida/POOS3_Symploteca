package br.edu.ifsp.aluno.poos3.domain.usecases.user;

import br.edu.ifsp.aluno.poos3.domain.entities.user.User;
import br.edu.ifsp.aluno.poos3.domain.utilities.utils.EntityAlreadyExistsException;
import br.edu.ifsp.aluno.poos3.domain.utilities.utils.Notification;

public class CreateUserUseCase {
    private final UserDAO userDAO;

    public CreateUserUseCase(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public String create(User user) {
        UserRequestValidator validator = new UserRequestValidator();
        Notification notification = validator.validate(user);

        if (notification.hasErrors())
            throw new IllegalArgumentException(notification.getErrorMessage());

        userDAO.findOneByKey(user.getEmail()).ifPresent(u -> {
            throw new EntityAlreadyExistsException("This user has already been registered!");
        });
        userDAO.findOneByEmail(user.getEmail()).ifPresent(u -> {
            throw new EntityAlreadyExistsException("An user with such email has already been registered!");
        });

        return userDAO.insert(user);
    }
}
