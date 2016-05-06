package com.sarah;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;


class ExerciseContact{
    String name;
    String email;

    ExerciseContact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email;
    }
}

class ContactCollection implements Iterable<ExerciseContact> {
    List<ExerciseContact> contacts = new ArrayList<>();

    public void addContact(ExerciseContact newContact) {
        contacts.add(newContact);
    }

    public List<ExerciseContact> getContacts () {
        return contacts;
    }

    @Override
    public Iterator<ExerciseContact> iterator() {
        return contacts.iterator();
    }

    @Override
    public void forEach(Consumer<? super ExerciseContact> action) {

    }

    @Override
    public Spliterator<ExerciseContact> spliterator() {
        return null;
    }
}


public class Exercise10 {
    public static void main(String[] args) {
        ExerciseContact bob = new ExerciseContact("bob", "bob@bob.com");
        ExerciseContact arthur = new ExerciseContact("arthur", "aneuman1@cscc.edu");
        ExerciseContact arthur2 = new ExerciseContact("arthur", "arthur@arthur.com");

        ContactCollection contacts = new ContactCollection();
        contacts.addContact(bob);
        contacts.addContact(arthur2);
        contacts.addContact(arthur);

        for(ExerciseContact contact: contacts) {
            System.out.println(contact);
        }
    }
}
