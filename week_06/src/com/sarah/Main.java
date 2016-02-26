package com.sarah;

public class Main {
    public static void main(String[] args){
        AddressBook myAddressBook = new AddressBook();
        myAddressBook.newContact("arthur", "arthur@arthur.com");
        myAddressBook.newContact("bob", "bob@bob.com");
        myAddressBook.newContact("sue", "sue@sue.com");

        String bobsEmail = myAddressBook.searchByName("bob");
        System.out.println("Bob's email address is " + bobsEmail);


    }
}
