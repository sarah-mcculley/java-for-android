package com.sarah;

import java.util.Scanner;


public class UserInput {
    Scanner scanner = new Scanner(System.in);

    public int promptInt(String message){
        System.out.println(message);
        String userInput = scanner.nextLine();
        int userInt = 0;
        boolean isInt = false;

        while(!isInt) {
            try {
                userInt = Integer.parseInt(userInput);
                isInt = true;

            } catch (NumberFormatException e) {
                System.out.println(userInput + " is not an integer. "
                        + message);
                userInput = scanner.nextLine();
            }
        }
        return userInt;
    }
}
