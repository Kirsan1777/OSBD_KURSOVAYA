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

    /*public String seeLoginDao(List<User> userInfo, String userLogin){
        for( User user : userInfo ){
            System.out.println(user);
            String str = user.getLogin();
            if(str.equals(userLogin)){
                return "This login was founded!";
            }
        }
        return "This login wasn't founded!";
    }

    public User findInformationAboutUser(List<User> userInfo, String login){
        for( User user : userInfo ){
            if(login == user.getLogin()){
                System.out.println("Логин успешно найден");
                return user;

            }
        }
        User users = new User();//todo это надо как-то исправить, а то полная чушь
        System.out.println("Nothing interesting for you");
        return users;
    }*/
}
