package access;

import creator.BankCreator;


import dao.DaoImplement;

import entity.Product;
import entity.User;
import exception.ProgramException;
import input.ConsoleReader;
import service.BankService;
import service.ProductService;

public class UserInterface {


    public static ProductService product = new ProductService();
    public static DaoImplement dao = new DaoImplement();

    public void useUserOperation(User user) throws ProgramException {
        ConsoleReader in = new ConsoleReader();
        int kod = 11;
        while (kod!=0) {
            System.out.println("1 - add product \n2 - buy product \n3 - show all product \n4 - show my product \n5 - add money  to card \n6 - delete my product \n7 - add bank card");
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
                    showMyProduct(user);
                    break;
                case 5:
                    addMoney(user);
                    break;
                case 6:
                    showMyProduct(user);
                    deleteMyProduct(user);
                    break;
                case 7:
                    addBankCard(user);
                case 0:
                    default:
            }
        }
    }

    public void addProduct(User user){
        product.addProduct(user);
    }

    public void addMoney(User user){
        BankService bank = new BankService();
        bank.addMoney(user);
    }

    public void showAllProduct() throws ProgramException {
        product.showAllProduct(dao.findAllProducts());
    }

    public void showMyProduct(User user) throws ProgramException {
        product.showAllProduct(dao.findAllYourProducts(user));
    }

    public void buyProduct(User user) throws ProgramException {
        ConsoleReader in = new ConsoleReader();
        BankService bankService = new BankService();
        Product productMain = new Product();
        System.out.println("Input id for buy product:");
        int idProduct = in.inputInt();
        System.out.println("Input count of buy products:");
        int count = in.inputInt();
        product.buyProduct(idProduct, count);
        productMain = dao.findProductById(idProduct);
        System.out.println("Id seller = " + productMain.getIdSeller());
        bankService.transactionMoney(user, productMain, count);

    }

    public void deleteMyProduct(User user){
        ConsoleReader in = new ConsoleReader();
        System.out.println("Input name product for delete");
        String nameProduct = in.inputString();
        dao.deleteProduct(nameProduct, user.getId());
    }

    public void addBankCard(User user){
        BankCreator bank = new BankCreator();
        dao.addBank(bank.createBank(user));
    }

}

