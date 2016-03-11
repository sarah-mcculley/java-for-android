package com.sarah;


public class Contact {
    private String name;
    private String email;

    Contact(String name, String email){
        this.name = name;
        this.email = email;
    }

    public void display(){
        System.out.println("Name: " + name);
        System.out.println("Email " + email);
    }


}
