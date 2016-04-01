package com.sarah;


public class Cat extends Animal {
    private String furColor;

    Cat(String name, int age, String furColor){
        super(name, age);
        this.furColor = furColor;
    }

    public void Speak(){
        System.out.println("Meow!");
    }
}
