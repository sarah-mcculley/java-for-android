package com.sarah;


abstract class Contact{
    private String name;

    Contact(String name){
        this.name = name;
    }

    abstract public void contact();
}

class PhoneContact extends Contact{
    String phoneNumber;

    PhoneContact(String name, String phoneNumber) {
        super(name);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void contact() {
        System.out.println("Dialing " + phoneNumber);
    }
}

class EmailContact extends Contact{
    String emailAddress;

    EmailContact(String name, String emailAddress){
        super(name);
        this.emailAddress = emailAddress;

    }

    @Override
    public void contact() {
        System.out.println("Emailing " + emailAddress);
    }
}
public class Exercise9 {
    public static void main(String[] args){
        PhoneContact phone = new PhoneContact("Bob", "123-456-7890");
        EmailContact email = new EmailContact("Sue", "sue@sue.com");

        phone.contact();
        email.contact();

    }
}
