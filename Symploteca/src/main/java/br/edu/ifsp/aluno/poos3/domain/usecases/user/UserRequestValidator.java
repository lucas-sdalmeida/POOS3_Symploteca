package br.edu.ifsp.aluno.poos3.domain.usecases.user;

import br.edu.ifsp.aluno.poos3.domain.entities.user.Faculty;
import br.edu.ifsp.aluno.poos3.domain.entities.user.Student;
import br.edu.ifsp.aluno.poos3.domain.entities.user.User;
import br.edu.ifsp.aluno.poos3.domain.utilities.utils.Notification;
import br.edu.ifsp.aluno.poos3.domain.utilities.utils.Validator;

public class UserRequestValidator extends Validator<User> {
    @Override
    public Notification validate(User user) {
        Notification notification = new Notification();

        if (user == null) {
            notification.addError("User is null!");
            return notification;
        }

        if (Validator.isNullOrEmpty(user.getInstitutionalId()))
            notification.addError("User has an invalid institutional id!");
        if (Validator.isNullOrEmpty(user.getName()))
            notification.addError("User's name is null or empty!");
        if (Validator.isNullOrEmpty(user.getEmail()))
            notification.addError("User's e-mail is null or empty!");
        if (Validator.isNullOrEmpty(user.getPhone()))
            notification.addError("User's phone is null or empty!");
        if (user.getNumberOfCheckedOutBooks() == null ||
                user.getNumberOfCheckedOutBooks() < 0 ||
                user.getNumberOfCheckedOutBooks() > user.getLimitOfBooksToCheckOut())
            notification.addError("User has an invalid number of checked out books!");
        if (user instanceof Student student && Validator.isNullOrEmpty(student.getCourse()))
            notification.addError("Student's course is unknown!");
        if (user instanceof Faculty faculty && Validator.isNullOrEmpty(faculty.getDepartment()))
            notification.addError("Faculty's department is unknown!");

        return notification;
    }
}
