package com.sarah;

import java.util.List;
import java.util.ArrayList;

public class GenericMethod {
    //    public static void copyList(List<Object> sourceList, List<Object> destList) {
//        for (Object o: sourceList) {
//            destList.add(o);
//        }
//    }

    public static <T> void copyList(List<T> sourceList, List<T> destList) {
        for (T element: sourceList) {
            destList.add(element);
        }
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("bob");
        names.add("sue");
        List<String> namesCopy = new ArrayList<>();
        copyList(names, namesCopy);

        for (String name: namesCopy) {
            System.out.println(name);
        }
    }

}
