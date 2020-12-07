package service;

import dao.DaoImplement;
import entity.Bank;
import entity.Product;
import entity.User;
import exception.NumberException;
import exception.ProgramException;
import input.ConsoleReader;
import validator.ValidatorInformation;

import java.util.List;

public class BankService {

    public void addMoney(User user) throws NumberException {
        DaoImplement dao = new DaoImplement();
        ConsoleReader in = new ConsoleReader();
        ValidatorInformation validator = new ValidatorInformation();
        System.out.println("Input count of money: ");
        double money = validator.validateDoubleMin(in.inputDouble(), 0) ;
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

    public double checkMoney(User user) throws ProgramException {
        DaoImplement dao = new DaoImplement();
        ValidatorInformation validator = new ValidatorInformation();
        boolean result = validator.isTheBankCard(dao.findTargetBanks(user));
        if(result) {
            List<Bank> list = dao.findTargetBanks(user);
            Bank bank = list.get(0);
            return bank.getBalance();
        }
        System.out.println("You haven't bank card");
        return 0;
    }

}
