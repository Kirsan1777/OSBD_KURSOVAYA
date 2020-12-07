package validator;
import dao.DaoImplement;
import entity.User;
import exception.ProgramException;

import java.util.List;

public class LoginPassword {

    public User CheckLoginPassword(String login, String password) throws ProgramException {
        User user = new User();
        DaoImplement dao = new DaoImplement();
        user = dao.findTargetUser(login, password);
        return user;
    }

}
