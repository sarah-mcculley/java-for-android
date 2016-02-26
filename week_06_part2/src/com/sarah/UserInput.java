package com.sarah;

import java.util.Scanner;


public class UserInput {
    Scanner scanner = new Scanner(System.in);

    public int promptInt(String message){
        System.out.println(message);
        String userInput = scanner.nextLine();
        int userInt = Integer.parseInt(userInput);
        return userInt;
    }
}
