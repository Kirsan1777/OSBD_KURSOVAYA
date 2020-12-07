package service;

import creator.OrderCreator;
import dao.DaoImplement;
import entity.Order;
import entity.Product;
import entity.User;
import exception.ProgramException;
import input.ConsoleReader;
import validator.ValidatorInformation;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private static DaoImplement dao = new DaoImplement();

    public void organizeOrder(User user, Product product){
        OrderCreator creator = new OrderCreator();
        dao.addOrder(creator.createOrder(product.getPrice(), product.getIdSeller(), user.getId(), product.getNameProduct()));
    }

    public void seeOrders(List<Order> orders){
        int number = 1;
        for( Order order : orders ){
            System.out.print(number + ")");
            System.out.println(order.toString());
            number++;
        }
    }

    public void acceptOrder(User user) throws ProgramException {
        ConsoleReader in = new ConsoleReader();
        ValidatorInformation validator = new ValidatorInformation();
        List<Order>list = dao.findAllOrders(user);
        int count = list.size();
        if(count > 0){
            System.out.println("Input id for accept order:");
            int id = validator.validateIntMin(in.inputInt(), 0);
            dao.deleteOrder(user.getId(), id);
        }else{
            System.out.println("Orders wasn't founded");
        }
    }
}
