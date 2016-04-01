package com.sarah;
import java.util.List;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args){
        Dog odie = new Dog("Odie", 5, "beagle");
        Cat garfield = new Cat("Garfield", 6, "orange");
        Bat batty = new Bat("Batty", 3, 2);

        odie.Speak();
        garfield.Speak();
        batty.Speak();
        batty.fly();

        //making use of upcasting and late binding
        List<Animal> zoo = new ArrayList<>();
        //due to upcasting we can add each animal even though they are not instances of animal
        zoo.add(odie);
        zoo.add(garfield);
        zoo.add(batty);

        //because of late binding, calls method associated with animal itself, not the abstract method on Animal class
        for (Animal animal : zoo){
            animal.Speak();
        }

    }
}
