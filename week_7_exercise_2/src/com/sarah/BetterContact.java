package com.sarah;


public class BetterContact {
    private Contact contactField;
    private String phoneNumber;

    BetterContact(String name, String email, String phoneNumber){
        contactField = new Contact(name, email);
    }

    public void display(){
        contactField.display();
    }

    public void sendEmail(String message){
        //code to send email
    }

}
