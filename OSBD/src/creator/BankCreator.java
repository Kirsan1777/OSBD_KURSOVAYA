package creator;

import entity.Bank;
import entity.User;
import input.ConsoleReader;

public class BankCreator {
    public Bank createBank(User user){
        ConsoleReader in = new ConsoleReader();
        Bank newBank = new Bank();
        newBank.setNameBank(in.inputString());
        newBank.setBalance(0.0);
        newBank.setMobileNumber(in.inputInt());
        newBank.setBankId(user.getId());
        return newBank;
    }

    public Bank createBank(){
        ConsoleReader in = new ConsoleReader();
        Bank newBank = new Bank();
        newBank.setNameBank(in.inputString());
        newBank.setBalance(0.0);
        newBank.setMobileNumber(in.inputInt());
        newBank.setBankId(in.inputInt());
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
