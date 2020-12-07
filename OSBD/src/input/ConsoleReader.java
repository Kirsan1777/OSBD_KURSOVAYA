package input;

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

        int numberInt;

            while (!in.hasNextInt()) {
                System.out.println("That not a right number!");
                in.next();
            }
            numberInt = in.nextInt();


        return numberInt;
    }


    public double inputDouble()
    {
        Scanner in = new Scanner(System.in);

        double numberDouble;
            while (!in.hasNextDouble()) {
                System.out.println("That not a right number!");
                in.next();
            }
        numberDouble = in.nextInt();

        return numberDouble;
    }




}
