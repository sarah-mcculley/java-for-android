package com.sarah;


class QueueFullException extends Exception {}

class QueueEmptyException extends Exception {}

class Queue<E> {
    private E[] elements;
    private int index;
    private int size;

    Queue(int size) {
        this.size = size;
        elements = (E[]) new Object[size];
        index = 0;
    }

    public void enqueue(E element) throws QueueFullException {
        if (index >= size) {
            throw new QueueFullException();
        }

        elements[index] = element;
        index++;
    }

    public E dequeue() throws QueueEmptyException {
        if (index == 0) {
            throw new QueueEmptyException();
        }

        E returnValue = elements[0];

        E[] newElements = (E[]) new Object[size];
        for(int i = 1; i < size; i++) {
            newElements[i-1] = elements[i];
        }
        index--;
        elements = newElements;
        return returnValue;
    }
}

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> names = new Queue(2);

        try {
            names.enqueue("bob");
            names.enqueue("sue");
            System.out.println(names.dequeue());
            System.out.println(names.dequeue());
        }
        catch (QueueEmptyException | QueueFullException e) {
            e.printStackTrace();
        }
    }
}

