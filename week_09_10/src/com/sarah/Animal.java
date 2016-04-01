package com.sarah;

abstract public class Animal {
    private String name;
    private int age;


    Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

   abstract public void Speak();
}
