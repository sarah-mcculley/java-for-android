package com.sarah;


public class Bee implements Flyer{

    @Override
    public void takeOff() {
        System.out.println("Bee taking off.");
    }

    @Override
    public void fly() {
        System.out.println("Bee buzzing around.");

    }

    @Override
    public void land() {
        System.out.println("Bee landing.");

    }
}
