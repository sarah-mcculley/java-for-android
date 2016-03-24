package com.sarah;

import java.util.ArrayList;
import java.util.List;


public class ContactCollection {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact newContact){
        contacts.add(newContact);
    }

    public void displayContacts(){
        for (Contact contact: contacts) {
            contact.display();

        }
    }
}
