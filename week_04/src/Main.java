import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<String, List<Double>>  getUserInput( ){
        Map<String, List<Double>> cities = new LinkedHashMap<>();
        Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("\nPlease enter a list of city names.  When you are finished, enter END. \n");
        String cityName = scanner.nextLine();

        while(!cityName.toUpperCase().equals("END")) {
            cities.put(cityName, null);
            System.out.println("\nPlease enter a list of city names.  When you are finished, enter END. \n");
            cityName = scanner.nextLine();
        }
        for (String name: cities.keySet()) {
            System.out.println("Enter the temperature for the next five days for " + name
                    + " (separate each temperature with a space).");
            String temps = scanner.nextLine();

            String[] stringTemps = temps.split(" ");

            List<Double> doubleTemps = new ArrayList<>();
            for (String temp: stringTemps) {
                doubleTemps.add(Double.parseDouble(temp));
            }

            cities.put(name, doubleTemps);
        }

        return cities;
    }

    static Map<String, Double> calculateAverages(Map<String, List<Double>> dailyTemps) {
        Map<String, Double> averages = new LinkedHashMap<>();

        for (String city : dailyTemps.keySet()) {
            List<Double> temps = dailyTemps.get(city);
            double total = 0;
            for (double temp : temps) {
                total += temp;
            }
            total /= temps.size();
            averages.put(city, total);
        }

        return averages;
    }

    static void displayAverages(Map<String, Double> averages) {
        for (String key: averages.keySet()) {
            System.out.println(key + ": " + averages.get(key));
        }
    }

    public static void main(String[] args) {
        Map<String, List<Double>> userInput = getUserInput();
        Map<String, Double> averages = calculateAverages(userInput);
        displayAverages(averages);
    }

}


