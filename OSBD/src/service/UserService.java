package service;

import creator.UserCreator;
import dao.DaoImplement;
import entity.User;
import input.ConsoleReader;

import java.util.List;

public class UserService {

    public void addUser(){
        UserCreator newUser = new UserCreator();
        DaoImplement userDao = new DaoImplement();
        userDao.addUser(newUser.createUser());
    }

    public void addUser(String login, String password){
        UserCreator newUser = new UserCreator();
        DaoImplement userDao = new DaoImplement();
        userDao.addUser(newUser.createUser(login, password));
    }

    public void deleteUser(){
        ConsoleReader reader = new ConsoleReader();
        DaoImplement userDao = new DaoImplement();
        int id;
        System.out.println("Input id for delete: ");
        id = reader.inputInt();
        userDao.deleteUser(id);
    }

    public void showUserInformation(List<User> users){
        int number = 1;
        for( User user : users ){
            System.out.print(number + ")");
            System.out.println(user.toString());
            number++;
        }
    }

}
