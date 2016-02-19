

class WeatherData {
    final static String TEMP_UNIT = "F";
    final static String HUMIDITY_UNIT = "%";
    final static String PRECIPITATION_UNIT = "%";
    final static int FREEZE_TEMP = 32;

    static int counter = 0;

    String cityName;
    double temperature;
    double humidity;
    double precip;

    WeatherData(String city, double temp, double humidity, double precip) {
        counter++;
        //cityName corresponds to the field, city corresponds to the parameter
        cityName = city;
        temperature = temp;
        //this corresponds to the specific object (for example columbus.humidity
        this.humidity = humidity;
        this.precip = precip;
    }
    //default constructor
    //WeatherData() { }

    static void displayFreezeTemp(){
        System.out.println(FREEZE_TEMP + TEMP_UNIT);
    }

    static double tempFToC(double f){
        return 5.0 / 9 * (f - 32);
    }

    static double tempCToF(double c){
        return 9.0 / 5 * c + 32;
    }

    boolean willSnow(){
        return (temperature <= FREEZE_TEMP) && (precip >= 50);
    }

    void displayWeatherReport(){
        String displayTemp = temperature + TEMP_UNIT;
        String displayHumidity = humidity + HUMIDITY_UNIT;
        String displayPrecip = precip + PRECIPITATION_UNIT;
        // three expressions, boolean express, what it returns if true, return if false
        String snowLikely = willSnow() ? "likely" : "unlikely";

        System.out.println("The current temperature in " + cityName
                + "is " + displayTemp
                + ". The current relative humidity is " + displayHumidity
                + ". The current chance of precipitation is " + displayPrecip
                + ". It is " + snowLikely + " to snow.");
    }

}

class SchmeatherData {
    final static String TEMP_UNIT = "F";
    final static String HUMIDITY_UNIT = "%";
    final static String PRECIPITATION_UNIT = "%";
    final static int FREEZE_TEMP = 32;

    int counter = 0;

    SchmeatherData(String city, double temp, double humidity, double precip) {
        counter++;
    }


}


public class Main {

    public static void main(String[] args) {
        System.out.println(WeatherData.tempCToF(100));
        System.out.println(WeatherData.tempFToC(32));

        WeatherData.displayFreezeTemp();


        System.out.println("WeatherData Freeze Temp: "
                + WeatherData.FREEZE_TEMP + WeatherData.TEMP_UNIT);
        System.out.println("WeatherData Counter: " + WeatherData.counter);

        WeatherData columbus = new WeatherData("Columbus", 70, 70, 70);

        columbus.displayWeatherReport();

        System.out.println("WeatherData Counter: " + WeatherData.counter);
        System.out.println("City name: " + columbus.cityName);
        System.out.println("Temperature: " + columbus.temperature + WeatherData.TEMP_UNIT);

        WeatherData cleveland = new WeatherData("Cleveland", 70, 70, 70);
        System.out.println("WeatherData Counter: " + cleveland.counter);

        columbus.counter++;

        System.out.println("WeatherData Counter: " + WeatherData.counter);
        System.out.println("WeatherData Counter: " + columbus.counter);
        System.out.println("WeatherData Counter: " + cleveland.counter);

        System.out.println("\nWeatherData Freeze Temp: "
                + WeatherData.FREEZE_TEMP + WeatherData.TEMP_UNIT);
        System.out.println("WeatherData Counter: " + WeatherData.counter);

        SchmeatherData kent = new SchmeatherData("Kent", 70, 70, 70);
        System.out.println("Kent Counter: " + kent.counter);

        SchmeatherData warren = new SchmeatherData("Warren", 70, 70, 70);
        System.out.println("Warren Counter: " + warren.counter);

        kent.counter++;

        System.out.println("WeatherData Counter: " + WeatherData.counter);
        System.out.println("Kent Counter: " + kent.counter);
        System.out.println("Warren Counter: " + warren.counter);

    }
}
