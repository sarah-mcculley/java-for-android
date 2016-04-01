package com.sarah;

abstract public class FlyingAnimal extends Animal {
    FlyingAnimal(String name, int age){
        super(name, age);
    }

    abstract public void fly();
}
