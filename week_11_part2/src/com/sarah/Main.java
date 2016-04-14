package com.sarah;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Map;

interface WeatherDataListener{
    public void updateData(WeatherData data);
}

interface WeatherDataSource{
    public void addListener(WeatherDataListener listener);
    public void removeListener(WeatherDataListener listener);
    public void update();
}

abstract class WeatherData{
    private String dataType;
    private double measureValue;

    WeatherData(String dataType, double measureValue){
    this.dataType = dataType;
        this.measureValue = measureValue;
    }

    public double getMeasureValue() {
        return measureValue;
    }

    public String getDataType() {
        return dataType;
    }

    abstract public String getUpdateMessage();
}

class TemperatureSensor implements WeatherDataSource{
    private List<WeatherDataListener> listeners = new ArrayList<>();
    private double currentTemperature;

    TemperatureSensor(){
        updateTemperature();
    }

    public double getCurrentTemperature(){
        return currentTemperature;
    }

    private void updateTemperature(){
        //read from temperature sensor
        currentTemperature = new Random().nextDouble() * 100;
    }

    @Override
    public void addListener(WeatherDataListener listener){
        listeners.add(listener);
    }

    @Override
    public void removeListener(WeatherDataListener listener){
        listeners.remove(listener);
    }

    @Override
    public void update(){
        System.out.println("TemperatureSensor: getting new data");
        updateTemperature();
        for (WeatherDataListener listener: listeners) {
            listener.updateData(new WeatherData("temperature", currentTemperature) {
                @Override
                public String getUpdateMessage() {
                    return "The new temperature is " + currentTemperature;
                }
            });
        }

    }
}

class HumiditySensor implements WeatherDataSource{
    private List<WeatherDataListener> listeners = new ArrayList<>();
    private double currentHumidity;

    HumiditySensor(){
        updateHumidity();
    }

    public double getCurrentTemperature(){
        return currentHumidity;
    }

    private void updateHumidity(){
        //read from temperature sensor
        currentHumidity = new Random().nextDouble() * 100;
    }

    @Override
    public void addListener(WeatherDataListener listener){
        listeners.add(listener);
    }

    @Override
    public void removeListener(WeatherDataListener listener){
        listeners.remove(listener);
    }

    @Override
    public void update(){
        System.out.println("HumiditySensor: getting new data");
        updateHumidity();
        for (WeatherDataListener listener: listeners) {
            listener.updateData(new WeatherData("humidity", currentHumidity) {
                @Override
                public String getUpdateMessage() {
                    return "Humidity updated to " + currentHumidity;
                }
            });
        }

    }
}

class PressureSensor implements WeatherDataSource{
    private List<WeatherDataListener> listeners = new ArrayList<>();
    private double currentPressure;

    PressureSensor(){
        updatePressure();
    }

    public double getCurrentTemperature(){
        return currentPressure;
    }

    private void updatePressure(){
        //read from temperature sensor
        currentPressure = new Random().nextDouble() * 100;
    }

    @Override
    public void addListener(WeatherDataListener listener){
        listeners.add(listener);
    }

    @Override
    public void removeListener(WeatherDataListener listener){
        listeners.remove(listener);
    }

    @Override
    public void update(){
        System.out.println("PressureSensor: getting new data");
        updatePressure();
        for (WeatherDataListener listener: listeners) {
            listener.updateData(new WeatherData("pressure", currentPressure) {
                @Override
                public String getUpdateMessage() {
                    return "Pressure updated to " + currentPressure;
                }
            });
        }

    }
}

class WeatherStation implements WeatherDataListener{
    private Map<String, Double> allWeatherData = new HashMap<>();
    private List<String> log = new ArrayList<>();


    @Override
    public void updateData(WeatherData data) {
        System.out.println("WeatherStation: Updating the weather station data with new"
                + data.getDataType() + " data.");
        allWeatherData.put(data.getDataType(), data.getMeasureValue());
        log.add(data.getUpdateMessage());
    }

    public void displayCurrentWeather(){
        System.out.println("Weather Report");
        for (String dataType: allWeatherData.keySet()) {
            System.out.println(dataType + ": " + allWeatherData.get(dataType));

        }
    }

    public void displayLog(){
        for (int i = 0; i < log.size(); i++){
            int currentLine = i + 1;
            System.out.println(currentLine + ": " + log.get(i));
        }
    }
}


public class Main {
    public static void main(String[] args){
        System.out.println("Main: creating objects");
        WeatherStation localWeatherStation = new WeatherStation();

        TemperatureSensor temp = new TemperatureSensor();
        HumiditySensor humid = new HumiditySensor();
        PressureSensor pressure = new PressureSensor();

        temp.addListener(localWeatherStation);
        humid.addListener(localWeatherStation);
        pressure.addListener(localWeatherStation);

        System.out.println("Main: simulating updates from sensors");
        temp.update();
        humid.update();
        pressure.update();
        temp.update();

        System.out.println("Main: displaying report and log");
        localWeatherStation.displayCurrentWeather();
        localWeatherStation.displayLog();
    }
}
