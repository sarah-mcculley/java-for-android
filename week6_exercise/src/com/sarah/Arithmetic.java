package com.sarah;

public class Arithmetic {
    public static double average(double[] values) throws Exception {
        if (values.length == 0){
            throw new Exception("Cannot divide by zero.");
        }
        double average = 0;
        for(double value: values){
            average += value;
        }
        return average / values.length;
    }

    public static int divide (int a, int b){

        return a/b;
    }
}
