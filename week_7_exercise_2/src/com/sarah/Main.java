package com.sarah;


public class Main {
    public static void main(String[] args) {
        Contact arthur = new Contact("Arthur", "aneuman1@cscc.edu");
        BusinessContact bob = new BusinessContact("Bob", "bob@bob.com", "123-456-7890");

        ContactCollection collection = new ContactCollection();
        collection.addContact(arthur);
        collection.addContact(bob);

        collection.displayContacts();

    }



}
