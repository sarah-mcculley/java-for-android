package com.sarah;


public class Airplane implements Flyer {
    @Override
    public void takeOff() {
        System.out.println("Airplane taking off.");
    }

    @Override
    public void fly() {
        System.out.println("Maintaining altitude.");
    }

    @Override
    public void land() {
        System.out.println("Landing at the airport.");

    }
}
