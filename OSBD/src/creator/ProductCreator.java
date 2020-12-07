package creator;

import entity.Product;
import input.ConsoleReader;
import validator.ValidatorInformation;

public class ProductCreator {

    public static ValidatorInformation validator = new ValidatorInformation();

    public Product createProduct(){

        ConsoleReader in = new ConsoleReader();
        Product newProduct = new Product();
        System.out.println("Input name product: ");
        newProduct.setNameProduct(in.inputString());
        System.out.println("Input name manufacture: ");
        newProduct.setManufacture(in.inputString());
        System.out.println("Input price: ");
        newProduct.setPrice(validator.validateDoubleMin(in.inputDouble(), 0));
        System.out.println("Input count: ");
        newProduct.setCount(validator.validateIntMin(in.inputInt(), 0));
        return newProduct;
    }

    public Product createProduct(String nameProduct,String manufacture, double price, int count, int idSeller, int idProduct){
        Product newProduct = new Product();
        newProduct.setCount(count);
        newProduct.setPrice(price);
        newProduct.setManufacture(manufacture);
        newProduct.setNameProduct(nameProduct);
        newProduct.setIdSeller(idSeller);
        newProduct.setIdProduct(idProduct);
        return newProduct;
    }
}
