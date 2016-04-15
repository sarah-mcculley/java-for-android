package com.sarah;
import java.util.ArrayList;
import java.util.List;


public class WildcardExample {

    public static void displayList(List<?> list){
        for (Object o: list) {
            System.out.println(o);

        }

    }

    public static void main(String[] args){
        List<String> names = new ArrayList<>();
        names.add("bob");
        names.add("sue");
        displayList(names);
    }
}
