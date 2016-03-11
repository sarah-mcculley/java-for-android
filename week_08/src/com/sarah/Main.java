package com.sarah;

import com.sun.org.apache.regexp.internal.RE;

class Shape{

    public void draw(){
        System.out.println("Drawing a shape.");
    }

}

class Rectangle extends Shape{
    @Override
    public void draw(){
        System.out.println("Drawing a rectangle.");
    }

}

class Triangle extends Shape{
    @Override
    public void draw(){
        System.out.println("Drawing a triangle.");
    }

}
class Circle extends Shape{
    int radius = 10;
    @Override
    public void draw(){
        System.out.println("Drawing a circle.");
    }

    public int getRadius(){
        return radius;
    }

}
public class Main {
    public static void main(String[] args){
        Triangle triangle = new Triangle();
        Rectangle rectangle = new Rectangle();
        Circle circle = new Circle();

        Shape[] shapes = {triangle, rectangle, circle};

        for(Shape item : shapes){
            item.draw();
        }



    }
}
