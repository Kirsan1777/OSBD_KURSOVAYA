package dao;

public class SqlRequest {
    public static final String ADD_USER = "INSERT user(FirstName, SecondName, City, Login, Password) VALUES (?, ?, ?, ?, ?)";
    public static final String REMOVE_USER_BY_ID = "DELETE FROM user WHERE id = ?";
    public static final String SELECT_ALL_USERS = "SELECT Login, Password, FirstName, SecondName, City, prior, id FROM user";
    public static final String ADD_BANK = "INSERT bank(nameBank, mobileNumber, bank_id) VALUES (?, ?, ?)";
    public static final String ADD_MONEY = "UPDATE bank SET balance = balance + ? WHERE bank_id = ?";
    public static final String ADD_PRODUCT = "INSERT product(price, manufacture, nameProduct, count, idSeller) VALUES (?, ?, ?, ?, ?)";
    public static final String DELETE_PRODUCT_BY_NAME_PRODUCT = "DELETE FROM product WHERE nameProduct = ? AND idSeller = ?";
    public static final String SELECT_ALL_PRODUCT = "SELECT price, idProduct, manufacture, nameProduct, count, idSeller FROM product";
    public static final String SELECT_ALL_PRODUCT_TARGET = "SELECT price, idProduct, manufacture, nameProduct, count, idSeller FROM product WHERE idSeller = ?";
    public static final String SELECT_PRODUCT_BY_ID = "SELECT price, idProduct, manufacture, nameProduct, count, idSeller FROM product WHERE idProduct = ?";
    public static final String ADD_ORDER = "INSERT order(price, idSeller, idCustomer, product) VALUES (?, ?, ?, ?)";
    public static final String DELETE_ORDER_BY_ID = "DELETE FROM order WHERE id = ? AND idSeller = ?";
    public static final String SELECT_ALL_MY_ORDER = "SELECT price, idSeller, id, idCustomer, product FROM order WHERE idSeller = ?";
    public static final String LOOK_FOR_USER = "SELECT Login, Password, FirstName, SecondName, City, prior, id FROM user WHERE Login=? AND Password=?";
    public static final String BUY_PRODUCT = "UPDATE product SET count = count - ? WHERE idProduct = ?";
    public static final String TRANSACTION_MONEY_GIVE = "UPDATE bank SET balance = balance - ? WHERE bank_id = ?";
    public static final String TRANSACTION_MONEY_GET = "UPDATE bank SET balance = balance + ? WHERE bank_id = ?";
}
