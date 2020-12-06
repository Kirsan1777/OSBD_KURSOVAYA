package access;

import dao.DaoImplement;
import entity.User;
import exception.ProgramException;
import input.ConsoleReader;
import service.UserService;

public class RegistrationInterface {

    public void registrationNewUser() throws ProgramException {
        ConsoleReader in = new ConsoleReader();
        DaoImplement dao = new DaoImplement();
        User user = new User();
        System.out.println("Input your login for registration account: ");
        String login = in.inputString();
        System.out.println("Input password for your account: ");
        String password = in.inputString();
        user = dao.findTargetUser(login, password);
        int result =user.getPrior();
        if(result == 0){
            addUser(login, password);
        }else {
            System.out.println("This login was used!");
        }

    }

    public void addUser(String login, String password) throws ProgramException {
        UserService user = new UserService();
        user.addUser(login, password);
        System.out.println("You was add to BD");
    }
}
