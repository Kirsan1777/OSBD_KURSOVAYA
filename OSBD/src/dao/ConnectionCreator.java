package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {
    public static Connection provideConnection() throws SQLException {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/osbdkursovaya?serverTimezone=Europe/Moscow&useSSL=false&allowPublicKeyRetrieval=true";
            String username = "root";
            String password = "kirsan2001";
            //Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();//AAAAAAAAAAAAAAAAAAA
            connection = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException ex){
            System.out.println("We have problem with connection DAO!");
        }
        return connection;
    }
}
