package access;

import dao.DaoImplement;
import exception.ProgramException;
import input.ConsoleReader;
import service.ProductService;
import service.UserService;

public class AdminInterface {

    public int useAdminOperation() throws ProgramException {
        ConsoleReader in = new ConsoleReader();
        int kod = 11;

        while (kod!=0){
            System.out.println("1 - Add User \n2 - Delete User \n3 - Show all users \n4 - Show all products \n0 - Exit ");
            System.out.println("Input kod: ");
            kod = in.inputInt();
            switch (kod){
             case 1:
                 addUser();
                 break;
             case 2:
                 deleteUser();
                  break;
              case 3:
                  showUsers();
                  break;
                case 4:
                    showAllProducts();
                break;
              default:
            }
        }
        return 15;
    }

    public void addUser(){
        UserService user = new UserService();
        user.addUser();
    }

    public void  deleteUser(){
        UserService user = new UserService();
        user.deleteUser();
    }

    public void showUsers() throws ProgramException {
        UserService user = new UserService();
        DaoImplement dao = new DaoImplement();
        user.showUserInformation(dao.findAllUsers());
    }

    public void showAllProducts() throws ProgramException {
        DaoImplement dao = new DaoImplement();
        ProductService product = new ProductService();
        product.showAllProduct(dao.findAllProducts());
    }
}
