package creator;

import entity.User;
import input.ConsoleReader;


public class UserCreator {
    public User createUser(){
        ConsoleReader in = new ConsoleReader();
        User newUser = new User();
        System.out.println("Input your Login: ");
        newUser.setLogin(in.inputString());
        System.out.println("Input your Password: ");
        newUser.setPassword(in.inputString());
        System.out.println("Input first name: ");
        newUser.setFirstName(in.inputString());
        System.out.println("Input second name: ");
        newUser.setSecondName(in.inputString());
        System.out.println("Input your city: ");
        newUser.setCity(in.inputString());
        return newUser;
    }

    public User createUser(String login, String password){
        ConsoleReader in = new ConsoleReader();
        User newUser = new User();
        newUser.setLogin(login);
        newUser.setPassword(password);
        System.out.println("Input first name: ");
        newUser.setFirstName(in.inputString());
        System.out.println("Input second name: ");
        newUser.setSecondName(in.inputString());
        System.out.println("Input your city: ");
        newUser.setCity(in.inputString());
        return newUser;
    }

    public User createUser(String firstName, String secondName, String city,String login,
                           String password, int prior,int id){
        User newUser = new User();
        newUser.setSecondName(secondName);
        newUser.setFirstName(firstName);
        newUser.setCity(city);
        newUser.setLogin(login);
        newUser.setPassword(password);
        newUser.setPrior(prior);
        newUser.setId(id);
        return newUser;
    }
}
