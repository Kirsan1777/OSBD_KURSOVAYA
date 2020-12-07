package main;


import access.MainInterface;
import exception.NumberException;
import exception.ProgramException;


public class Main {
    public static void main(String[] args) throws ProgramException, NumberException {
        MainInterface realise = new MainInterface();
        realise.realiseInterface();
    }
}
