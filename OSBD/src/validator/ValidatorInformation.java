package validator;

import entity.Bank;
import input.ConsoleReader;

import java.util.List;

public class ValidatorInformation {

    public static ConsoleReader in = new ConsoleReader();

    public boolean isTheBankCard(List<Bank> banks){
        if(banks.size() > 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean isTheResultMoreThenZero(double firstNumber, double secondNumber, String message){
        if(firstNumber - secondNumber >= 0 ){
            return true;
        }else{
            System.out.println(message);
            return false;
        }
    }

    public int validateIntInRange(int number, int min, int max)  {

        while(number>= max && number <= min) {
            number = in.inputInt();
        }
        return number;
    }

    public int validateIntMax(int number, int max)  {

        while (number >= max) {
            number = in.inputInt();
        }
        return number;
    }

    public int validateIntMin(int number, int min)  {

        while (number <= min) {
            number = in.inputInt();
        }
        return number;
    }

    public double validateDoubleInRange(double number, double min, double max)  {

        while (number >= max && number <= min) {
            number = in.inputDouble();
        }
        return number;
    }

    public double validateDoubleMax(double number, double max)  {

        while (number >= max) {
            number = in.inputDouble();
        }
        return number;
    }

    public double validateDoubleMin(double number, double min)  {

        while (number <= min) {
            number = in.inputDouble();
        }
        return number;
    }

}
