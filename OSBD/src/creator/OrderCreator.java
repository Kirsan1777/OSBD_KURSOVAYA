package creator;

import entity.Order;


public class OrderCreator {
   /* public Order createOrder(){
        ConsoleReader in = new ConsoleReader();
        Order newOrder = new Order();
        newOrder.setIdCustomer(in.inputInt());
        newOrder.setIdSeller(in.inputInt());
        newOrder.setPrise(in.inputDouble());
        return newOrder;
    }*/

    public Order createOrder(double price, int seller, int customer,  int id, String product){
        Order newOrder = new Order();
        newOrder.setPrise(price);
        newOrder.setIdSeller(seller);
        newOrder.setIdCustomer(customer);
        newOrder.setId(id);
        newOrder.setProduct(product);
        return newOrder;
    }

    public Order createOrder(double price, int seller, int customer, String product){
        Order newOrder = new Order();
        newOrder.setPrise(price);
        newOrder.setIdSeller(seller);
        newOrder.setIdCustomer(customer);
        newOrder.setProduct(product);
        return newOrder;
    }
}
