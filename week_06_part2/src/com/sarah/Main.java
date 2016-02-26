package com.sarah;

public class Main {
    public static void main(String[] args) throws Exception{
        UserInput input = new UserInput();
        int aNumber = input.promptInt("Enter an integer.");
        System.out.println("Twice your number is " + 2 * aNumber);

        double[] someValues = {};
        double averageValue = Arithmetic.average(someValues);
        System.out.println(averageValue);
    }
}
