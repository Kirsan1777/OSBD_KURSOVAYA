package service;

import creator.OrderCreator;
import dao.DaoImplement;
import entity.Order;
import entity.Product;
import entity.User;

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
            System.out.println(orders.toString());
            number++;
        }
    }

    public void acceptOrder(){

    }
}
