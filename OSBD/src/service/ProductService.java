package service;

import creator.ProductCreator;
import dao.DaoImplement;
import entity.Product;
import entity.User;
import exception.ProgramException;
import input.ConsoleReader;

import java.util.List;


public class ProductService {

    public static ProductCreator newProduct = new ProductCreator();
    public static DaoImplement dao = new DaoImplement();

    public void addProduct(User user){//todo Работает, решить проблему с ид пользователя
        dao.addProduct(newProduct.createProduct(), user);
    }

    public void deleteProduct(User user){ //todo Работает, решить проблему с ид пользователя
        ConsoleReader reader = new ConsoleReader();
        System.out.println("Input name product: ");
        String nameProduct = reader.inputString();
        dao.deleteProduct(nameProduct, user.getId());
    }



    public void showAllProduct(List<Product> products){
        int number = 1;
        System.out.println("Name Product  Manufacture\t\tCost\t\tCount\tId\tSeller id ");
        for( Product product : products ){
            System.out.print(number + ")");
            System.out.println(product.toString());
            number++;
        }
    }

    public void buyProduct(int idProduct, int count)  {
                dao.buyProduct(idProduct, count);
    }
}
