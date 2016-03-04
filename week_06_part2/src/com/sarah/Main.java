package com.sarah;

public class Main {
    public static void main(String[] args) {
        UserInput input = new UserInput();
        int aNumber = input.promptInt("Enter an integer.");
        int bNumber = input.promptInt("Enter a second integer.");
        int quotient = Arithmetic.divide(aNumber, bNumber);
        System.out.println("The quotient is " + quotient);
        System.out.println("Twice your number is " + 2 * aNumber);

        double[] someValues = {};

        try {
            double averageValue = Arithmetic.average(someValues);
            System.out.println(averageValue);
        }

        catch (Exception e){
            System.out.println("An exception occurred.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
