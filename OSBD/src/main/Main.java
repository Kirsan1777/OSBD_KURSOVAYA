package main;

import access.AdminInterface;
import access.RegistrationInterface;
import access.UserInterface;
import dao.DaoImplement;
import entity.User;
import exception.ProgramException;
import input.ConsoleReader;
import validator.LoginPassword;

public class Main {
    public static void main(String[] args) throws ProgramException {

        ConsoleReader reader = new ConsoleReader();
        LoginPassword checker = new LoginPassword();
        User user = new User();
        AdminInterface admin = new AdminInterface();
        RegistrationInterface registrator = new RegistrationInterface();
        UserInterface userInterface = new UserInterface();

        //registrator.registrationNewUser();


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
