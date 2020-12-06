package input;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ConsoleReader {

    public String inputString()
    {
        Scanner in = new Scanner(System.in);
        String inputLine;
        inputLine = in.nextLine();
        return inputLine;
    }


    public int inputInt()
    {
        Scanner in = new Scanner(System.in);

        int numberInt = 0;
        try {
            numberInt = in.nextInt();
        }
        catch (InputMismatchException ex){
            System.out.println("This is not right number, please check your input and try again");
        }
        return numberInt;
    }

    public double inputDouble()
    {
        Scanner in = new Scanner(System.in);
        double numberDouble = 0;
        try {
            numberDouble = in.nextDouble();
        }
        catch (InputMismatchException ex){
            System.out.println("This is not right number, please check your input");
        }
        return numberDouble;
    }

}
