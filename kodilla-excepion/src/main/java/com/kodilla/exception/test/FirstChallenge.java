package com.kodilla.exception.test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {
        try { // create where problem might be found.
            FirstChallenge firstChallenge = new FirstChallenge();
            double result = firstChallenge.divide(3, 0);
        } catch (ArithmeticException e) { //If the program find a problem then goes to catch.
            System.out.println("Don't divide by 0 :" +e);
        } finally { //This part runs always even if no exception occurs.
            System.out.println("Try again");
        }
    }
}