package com.company;

public class Main {

    public static void main(String[] args) {
        int[] highTemps = {45, 29, 10, 22, 41, 28, 33};
        int[] precipProb = {95, 60, 25, 5, 0, 75, 90};
        String[] dayOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        for (int i = 0; i < highTemps.length; i++)
        {
            if((highTemps[i] <= 32) && (precipProb[i] > 50))
            {
                System.out.println(dayOfWeek[i]);
            }
        }


    }
}
