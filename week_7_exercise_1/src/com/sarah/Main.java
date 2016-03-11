package com.sarah;


public class Main {
    public static void main(String[] args){
        Contact arthur = new Contact("Arthur", "aneuman1@cscc.edu");
        arthur.display();

        BusinessContact bob = new BusinessContact("Bob", "bob@bob.com", "123-456-7890");
        bob.display();
    }
}
