package dao;

import creator.OrderCreator;
import creator.ProductCreator;
import creator.UserCreator;
import entity.Bank;
import entity.Order;
import entity.Product;
import entity.User;
import exception.ProgramException;
import validator.LoginPassword;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoImplement {

    public void addUser(User user){//Работает
        try (Connection connection = ConnectionCreator.provideConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(SqlRequest.ADD_USER)) {
                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getSecondName());
                statement.setString(3, user.getCity());
                statement.setString(4, user.getLogin());
                statement.setString(5, user.getPassword());
                statement.executeUpdate();//command from update DB
            }
        } catch (SQLException ex) {
            System.out.println("We have problem with connection");
        }
    }


    public void addProduct(Product product, User user){//Работает
        try (Connection connection = ConnectionCreator.provideConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(SqlRequest.ADD_PRODUCT)) {
                statement.setDouble(1, product.getPrice());
                statement.setString(2, product.getManufacture());
                statement.setString(3, product.getNameProduct());
                statement.setInt(4, product.getCount());
                statement.setInt(5, user.getId());
                statement.executeUpdate();//command from update DB
            }
        } catch (SQLException ex) {
            System.out.println("We have problem with connection");
        }
    }

    public void addBank(Bank bank){
        try (Connection connection = ConnectionCreator.provideConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(SqlRequest.ADD_BANK)) {
                statement.setString(1, bank.getNameBank());
                //statement.setDouble(2, bank.getBalance());
                statement.setInt(2, bank.getMobileNumber());
                statement.setInt(3, bank.getBankId());
                statement.executeUpdate();//command from update DB
            }
        } catch (SQLException ex) {
            System.out.println("We have problem with connection");
        }
    }
    
    public void deleteUser(int id){
        try(Connection connection = ConnectionCreator.provideConnection();
            PreparedStatement statement = connection.prepareStatement(SqlRequest.REMOVE_USER_BY_ID)){
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex){
            System.out.println("We have problem with connection!");
        }
    }


    public List<User> findAllUsers() throws ProgramException { //todo Работает
        List<User> users = null;
        try (Connection connection = ConnectionCreator.provideConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SqlRequest.SELECT_ALL_USERS);
            users = readUsersInfo(resultSet);
        } catch (SQLException ex) {
            throw new ProgramException(ex);
        }
        return users;
    }

    private List<User> readUsersInfo(ResultSet resultSet) throws SQLException{
        UserCreator creator = new UserCreator();
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            String login = resultSet.getString(1);
            String password = resultSet.getString(2);
            String firstName = resultSet.getString(3);
            String secondName = resultSet.getString(4);
            String city = resultSet.getString(5);
            int prior = resultSet.getInt(6);
            int id = resultSet.getInt(7);
            users.add(creator.createUser(login, password, firstName, secondName, city, prior, id));
        }
        return users;
    }


    public User findTargetUser(String login, String password) throws ProgramException { //todo Работает
        User users = null;
        try (Connection connection = ConnectionCreator.provideConnection();
            PreparedStatement statement = connection.prepareStatement(SqlRequest.LOOK_FOR_USER)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            users = readUsersInfo2(resultSet);
        } catch (SQLException ex) {
            throw new ProgramException(ex);
        }
        return users;
    }



    private User readUsersInfo2(ResultSet resultSet) throws SQLException{
        UserCreator creator = new UserCreator();
        User users = new User();
            while(resultSet.next()) {
                String login = resultSet.getString(1);
                String password = resultSet.getString(2);
                String firstName = resultSet.getString(3);
                String secondName = resultSet.getString(4);
                String city = resultSet.getString(5);
                int prior = resultSet.getInt(6);
                int id = resultSet.getInt(7);
                users = (creator.createUser(login, password, firstName, secondName, city, prior, id));
            }
        return users;
    }

    public void deleteProduct(String nameProduct, int id){
        try(Connection connection = ConnectionCreator.provideConnection();
            PreparedStatement statement = connection.prepareStatement(SqlRequest.DELETE_PRODUCT_BY_NAME_PRODUCT)){
            statement.setString(1, nameProduct);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException ex){
            System.out.println("We can not delete this product!");
        }
    }

    public List<Product> findAllProducts() throws ProgramException { //todo Работает
        List<Product> products = null;
        try (Connection connection = ConnectionCreator.provideConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SqlRequest.SELECT_ALL_PRODUCT);
            products = readProductInfo(resultSet);
        } catch (SQLException ex) {
            throw new ProgramException(ex);
        }
        return products;
    }



    public List<Product> findAllYourProducts(User user) throws ProgramException { //todo Работает
        List<Product> products = null;
        try (Connection connection = ConnectionCreator.provideConnection();
             PreparedStatement statement = connection.prepareStatement(SqlRequest.SELECT_ALL_PRODUCT_TARGET)) {
            statement.setInt(1, user.getId());
            ResultSet resultSet = statement.executeQuery();
            products = readProductInfo(resultSet);
        } catch (SQLException ex) {
            throw new ProgramException(ex);
        }
        return products;
    }

    public Product findProductById(int id) throws ProgramException { //todo Работает
        List<Product> products = null;
        Product product = null;
        try (Connection connection = ConnectionCreator.provideConnection();
             PreparedStatement statement = connection.prepareStatement(SqlRequest.SELECT_PRODUCT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            products = readProductInfo(resultSet);
        } catch (SQLException ex) {
            throw new ProgramException(ex);
        }
        return product = products.get(0);
    }

    private List<Product> readProductInfo(ResultSet resultSet) throws SQLException{
        ProductCreator creator = new ProductCreator();
        List<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            double price = resultSet.getDouble(1);
            int idProduct = resultSet.getInt(2);
            String manufacture = resultSet.getString(3);
            String nameProduct = resultSet.getString(4);
            int count = resultSet.getInt(5);
            int idSeller = resultSet.getInt(6);
            products.add(creator.createProduct(nameProduct, manufacture, price, count, idSeller, idProduct  ));
        }
        return products;
    }


    public void addMoneyToBank(User user, double money){
        try (Connection connection = ConnectionCreator.provideConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(SqlRequest.ADD_MONEY)) {
                statement.setDouble(1, money);
                statement.setInt(2, user.getId());
                statement.executeUpdate();//command from update DB
            }
        } catch (SQLException ex) {
            System.out.println("We have problem with connection");
        }
    }

    public void buyProduct(int idProduct, int count){
        try (Connection connection = ConnectionCreator.provideConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(SqlRequest.BUY_PRODUCT)) {
                statement.setDouble(1, count);
                statement.setInt(2, idProduct);
                statement.executeUpdate();//command from update DB
            }
        } catch (SQLException ex) {
            System.out.println("We have problem with connection");
        }
    }

    public void transactionMoneyGive(User user, double money){
        try (Connection connection = ConnectionCreator.provideConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(SqlRequest.TRANSACTION_MONEY_GIVE)) {
                statement.setDouble(1, money);//передать деньги
                statement.setInt(2, user.getId());
                statement.executeUpdate();//command from update DB
            }
        } catch (SQLException ex) {
            System.out.println("We have problem with connection");
        }
    }

    public void transactionMoneyGet(Product product, double money){
        try (Connection connection = ConnectionCreator.provideConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(SqlRequest.TRANSACTION_MONEY_GET)) {
                statement.setDouble(1, money);//передать деньги
                System.out.println("Id seller = " + product.getIdSeller());
                statement.setInt(2, product.getIdSeller());
                statement.executeUpdate();//command from update DB
            }
        } catch (SQLException ex) {
            System.out.println("We have problem with connection");
        }
    }

    public void addOrder(Order order){
        try (Connection connection = ConnectionCreator.provideConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(SqlRequest.ADD_ORDER)) {
                statement.setDouble(1, order.getPrise());
                statement.setInt(2, order.getIdSeller());
                statement.setInt(3, order.getIdCustomer());
                statement.setString(4, order.getProduct());
                statement.executeUpdate();//command from update DB
            }
        } catch (SQLException ex) {
            System.out.println("We have problem with connection");
        }
    }

    public void deleteOrder(int idSeller, int id){
        try(Connection connection = ConnectionCreator.provideConnection();
            PreparedStatement statement = connection.prepareStatement(SqlRequest.DELETE_ORDER_BY_ID)){
            statement.setInt(1, id);
            statement.setInt(2, idSeller);
            statement.executeUpdate();
        } catch (SQLException ex){
            System.out.println("We can not delete this product!");
        }
    }

    public List<Order> findAllOrders(User user) throws ProgramException { //todo Работает
        List<Order> orders = null;
        try (Connection connection = ConnectionCreator.provideConnection();
             PreparedStatement statement = connection.prepareStatement(SqlRequest.SELECT_ALL_MY_ORDER)) {
            statement.setInt(1, user.getId());
            ResultSet resultSet = statement.executeQuery();
            orders = readOrderInfo(resultSet);
        } catch (SQLException ex) {
            throw new ProgramException(ex);
        }
        return orders;
    }

    private List<Order> readOrderInfo(ResultSet resultSet) throws SQLException{
        OrderCreator creator = new OrderCreator();
        List<Order> orders = new ArrayList<>();
        while (resultSet.next()) {
            double price = resultSet.getDouble(1);
            int seller = resultSet.getInt(2);
            int id = resultSet.getInt(3);
            int customer = resultSet.getInt(4);
            String product = resultSet.getString(5);
            orders.add(creator.createOrder(price, seller, customer, id, product));
        }
        return orders;
    }


}
