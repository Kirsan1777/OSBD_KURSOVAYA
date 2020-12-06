package service;

import dao.DaoImplement;
import entity.Product;
import entity.User;
import input.ConsoleReader;

public class BankService {

    public void addMoney(User user){
        DaoImplement dao = new DaoImplement();
        ConsoleReader in = new ConsoleReader();
        System.out.println("Input count of money: ");
        double money = in.inputDouble();
        dao.addMoneyToBank(user, money);
    }

    public void transactionMoney(User user, Product product, double count){
        DaoImplement dao = new DaoImplement();
        double money = count * product.getPrice();
        System.out.println("Money = " + money);
        dao.transactionMoneyGive(user, money);
        System.out.println("Id seller = " + product.getIdSeller());
        dao.transactionMoneyGet(product, money);
    }

}
