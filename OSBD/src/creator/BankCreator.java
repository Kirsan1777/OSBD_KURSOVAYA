package creator;

import entity.Bank;
import entity.User;
import input.ConsoleReader;
import validator.ValidatorInformation;

public class BankCreator {
    public Bank createBank(User user){
        ConsoleReader in = new ConsoleReader();
        ValidatorInformation validator = new ValidatorInformation();
        Bank newBank = new Bank();
        System.out.println("Input name bank: ");
        newBank.setNameBank(in.inputString());
        newBank.setBalance(0.0);
        System.out.println("Input mobile number: ");
        newBank.setMobileNumber(validator.validateIntMin(in.inputInt(), 0));
        newBank.setBankId(user.getId());
        return newBank;
    }

    public Bank createBank(){
        ConsoleReader in = new ConsoleReader();
        Bank newBank = new Bank();
        ValidatorInformation validator = new ValidatorInformation();
        newBank.setNameBank(in.inputString());
        newBank.setBalance(0.0);
        newBank.setMobileNumber(in.inputInt());
        newBank.setBankId(validator.validateIntMin(in.inputInt(), 0));
        return newBank;
    }

    public Bank createBank(String nameBank, double balance, int mobileNumber, int bankId){
        Bank newBank = new Bank();
        newBank.setBankId(bankId);
        newBank.setMobileNumber(mobileNumber);
        newBank.setBalance(balance);
        newBank.setNameBank(nameBank);
        return newBank;
    }
}
