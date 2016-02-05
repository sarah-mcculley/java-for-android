package com.company;

/**
 * Created by sarahmcculley on 2/5/16.
 */
public class Main {
    static double getUserFahrenheit() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Enter a Fahrenheit temperature.");
        String userInput = scanner.nextLine();
        return Double.parseDouble(userInput);
    }

    static double fToC(double fTemp) {
        return 5.0 / 9 * (fTemp - 32);
    }

    static void display(double cTemp) {
        System.out.println("The celsius temperature is " + cTemp);
    }

    public static void main(String[] args) {
        double fTemp = getUserFahrenheit();
        while (fTemp >= -460) {
            double cTemp = fToC(fTemp);
            display(cTemp);
            fTemp = getUserFahrenheit();
        }
    }
}
