package com.sarah;


public class Dog extends Animal {

    private String breed;

    Dog(String name, int age, String breed){
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void Speak(){
        System.out.println("Woof!");
    }
}
