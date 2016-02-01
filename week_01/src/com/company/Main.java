package com.company;

public class Main {

    public static void main(String[] args) {
        String cityName = "Columbus";
        int zipCode = 43215;
        int[] highTemps = {32, 25, 27, 40, 45};

        double average = (highTemps[0] + highTemps[1]
                + highTemps[2] + highTemps[3] + highTemps[4]) / 5.0;

        System.out.println("City: " + cityName);
        System.out.println("Zip code: " + zipCode);
        System.out.println("Average high: " + average);
    }
}
