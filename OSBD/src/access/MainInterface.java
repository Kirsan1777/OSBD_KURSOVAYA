package access;

import entity.User;
import exception.NumberException;
import exception.ProgramException;
import input.ConsoleReader;
import validator.LoginPassword;

public class MainInterface {
    public void realiseInterface() throws ProgramException, NumberException {
        RegistrationInterface registrator = new RegistrationInterface();
        ConsoleReader in = new ConsoleReader();
        int kod = -1;
        while (kod != 0) {
            System.out.println("1 - for registration  \n2 - to login  \n0 - Exit");
            kod = in.inputInt();
            switch (kod) {
                case 1:
                    registrator.registrationNewUser();
                    break;
                case 2:
                    entranceToTheMainProject();
                    break;
                case 0:
                default:
            }
        }

    }



    private void entranceToTheMainProject() throws NumberException, ProgramException {

        ConsoleReader reader = new ConsoleReader();
        LoginPassword checker = new LoginPassword();
        User user = new User();
        AdminInterface admin = new AdminInterface();
        RegistrationInterface registrator = new RegistrationInterface();
        UserInterface userInterface = new UserInterface();

        System.out.println("Input login: ");
        String login = reader.inputString();
        System.out.println("Input password: ");
        String password = reader.inputString();
        user = checker.CheckLoginPassword(login, password);
        System.out.println(user);
        int type = user.getPrior();
        switch (type){
            case 1:
                userInterface.useUserOperation(user);
                break;
            case 2:
                admin.useAdminOperation();
                break;

            default:;
        }
    }


}
