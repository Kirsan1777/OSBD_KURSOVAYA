package access;

import creator.BankCreator;


import dao.DaoImplement;

import entity.Bank;
import entity.Product;
import entity.User;
import exception.NumberException;
import exception.ProgramException;
import input.ConsoleReader;
import service.BankService;
import service.OrderService;
import service.ProductService;
import validator.ValidatorInformation;

import java.util.List;

public class UserInterface {


    public static ProductService product = new ProductService();
    public static DaoImplement dao = new DaoImplement();

    public void useUserOperation(User user) throws ProgramException, NumberException {
        ConsoleReader in = new ConsoleReader();
        int kod = 11;
        while (kod!=0) {
            System.out.println("1 - add product \n2 - buy product \n3 - show all product \n4 - search products by name  \n5 - show my product \n6 - add money  to card \n7 - delete my product\n8 - accept orders \n9 - check your money  \n10 - add bank card");
            System.out.println("Input your choose:");
            kod = in.inputInt();
            switch (kod) {
                case 1:
                    addProduct(user);
                    break;
                case 2:
                    showAllProduct();
                    buyProduct(user);
                    break;
                case 3:
                    showAllProduct();
                    break;
                case 4:
                    showProductByName();
                    break;
                case 5:
                    showMyProduct(user);
                    break;
                case 6:
                    addMoney(user);
                    break;
                case 7:
                    showMyProduct(user);
                    deleteMyProduct(user);
                    break;
                case 8:
                    showOrders(user);
                    acceptOrder(user);
                    break;
                case 9:
                    checkMoney(user);
                    break;
                case 10:
                    addBankCard(user);
                case 0:
                    default:
            }
        }
    }

    public void addProduct(User user){
        product.addProduct(user);
    }

    public void addMoney(User user) throws NumberException {
        BankService bank = new BankService();
        bank.addMoney(user);
    }

    public void showAllProduct() throws ProgramException {
        product.showAllProduct(dao.findAllProducts());
    }

    public void showMyProduct(User user) throws ProgramException {
        product.showAllProduct(dao.findAllYourProducts(user));
    }

    public void showProductByName() throws ProgramException {
        ConsoleReader in = new ConsoleReader();
        String str = in.inputString();
        product.showAllProduct(dao.findAllProductsByName(str+'%'));
    }

    public void buyProduct(User user) throws ProgramException, NumberException {
        ConsoleReader in = new ConsoleReader();
        BankService bankService = new BankService();
        Bank bank;
        Product productMain;
        OrderService order = new OrderService();
        ValidatorInformation validator = new ValidatorInformation();
        boolean result = validator.isTheBankCard(dao.findTargetBanks(user));

        if(result){

            System.out.println("Input id for buy product or 0 for exit:");
            int idProduct = in.inputInt();

            if(idProduct != 0) {
                System.out.println("Input count of buy products:");
                int count = in.inputInt();

                productMain = dao.findProductById(idProduct);

                if(productMain.getIdSeller() == user.getId()){
                    System.out.println("No problem, but you buy your product :D ");
                }

                List<Bank> listBank = dao.findTargetBanks(user);
                bank = listBank.get(0);
                double balance = bank.getBalance();

                boolean resultCount = validator.isTheResultMoreThenZero(productMain.getCount(), count, "We don't have so many goods");
                boolean resultCost = validator.isTheResultMoreThenZero(balance, productMain.getPrice() * count, "You don't have so much money");

                if (resultCost && resultCount) {
                    product.buyProduct(idProduct, count);
                    bankService.transactionMoney(user, productMain, count);
                    order.organizeOrder(user, productMain);
                } else {
                    System.out.println("Please try again");
                }
            }
        }else{
            System.out.println("Please registering bank card and try again");
        }
    }

    public void deleteMyProduct(User user){
        ConsoleReader in = new ConsoleReader();
        System.out.println("Input name product for delete");
        String nameProduct = in.inputString();
        dao.deleteProduct(nameProduct, user.getId());
    }

    public void checkMoney(User user) throws ProgramException {
        BankService bank = new BankService();
        double money = bank.checkMoney(user);
        System.out.println("Your balance is " + money);
    }

    public void addBankCard(User user){
        BankCreator bank = new BankCreator();
        dao.addBank(bank.createBank(user));
    }

    public void showOrders(User user) throws ProgramException {
        OrderService order = new OrderService();
        order.seeOrders(dao.findAllOrders(user));
    }

    public void acceptOrder(User user) throws ProgramException {
        OrderService order = new OrderService();
        order.acceptOrder(user);
    }


}

