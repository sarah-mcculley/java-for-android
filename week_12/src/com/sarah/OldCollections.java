package com.sarah;


import java.util.ArrayList;
import java.util.List;

class Contact{
    private String name;
    private String email;

    public Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void displayInfo(){
        System.out.println("Name: " + name
                + ", Email: " + email);
    }


}

public class OldCollections {

    public static void main(String[] args){
        List<Contact> contacts = new ArrayList<>();

        Contact bob = new Contact("Bob", "bob@bob.com");
        Contact sue = new Contact("Sue", "sue@sue.com");

        contacts.add(bob);
        contacts.add(sue);



        for (Object o: contacts){
            Contact c = (Contact) o;
            c.displayInfo();
        }
    }
}
