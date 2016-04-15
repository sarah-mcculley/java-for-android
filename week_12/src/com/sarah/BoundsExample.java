package com.sarah;

import java.util.ArrayList;
import java.util.List;

interface Video {
    void display();
}

interface Audio {
    void playAudio();
}

class Movie implements Video, Audio{
    private String location;

    Movie(String location){
        this.location = location;
    }

    @Override
    public void playAudio() {
        System.out.println("Displaying audio");
    }

    @Override
    public void display() {
        System.out.println("Displaying video");
    }
}

class DifferentStack<E extends Video & Audio>{
    private List<E> elements = new ArrayList<E>();
    private int index = 0;
    private int size;

    DifferentStack(int size){
        this.size = size;
    }

    void push(E element) throws StackFullException{
        if (index >= size) {
            throw new StackFullException();
        }

        elements.add(index, element);
        index++;
    }

    E pop() throws StackEmptyException {
        if (index == 0) {
            throw new StackEmptyException();
        }
        E returnElement = elements.get(index - 1);
        index--;
        return returnElement;
    }

    void playAll(){
        while (index > 0 ) {
            try {
                E element = pop();
                element.playAudio();
                element.display();
            } catch (StackEmptyException e) {
                //won't get here because of while condition
            }
        }
    }
}

public class BoundsExample {

    public static void main(String[] args){

        DifferentStack<Movie> movies = new DifferentStack<>(2);
        try {
            movies.push(new Movie("movie_file"));
            movies.push(new Movie("different_file"));
        } catch (StackFullException e) {
            e.printStackTrace();
        }
        movies.playAll();
    }
}
