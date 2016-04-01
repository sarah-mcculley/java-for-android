package com.sarah;


public class Bat extends FlyingAnimal {
    private int weight;

    Bat(String name, int age, int weight){
        super(name, age);
        this.weight = weight;
    }

    @Override
    public void fly() {
        System.out.println("Flying!");

    }

    @Override
    public void Speak() {
        System.out.println("Bat sounds!");

    }
}
