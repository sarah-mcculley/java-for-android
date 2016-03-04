package com.sarah;

enum Direction{North, South, East, West};

class Storm{
    private double latitude;
    private double longitude;
    private double speed;
    private Direction direction;

    Storm(double latitude, double longitude, double speed, Direction direction)
    {
        this.longitude = longitude;
        this.latitude = latitude;
        this.speed = speed;
        this.direction = direction;
    }


    //region - getters and setters
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    //endregion

    public void display(){
        System.out.println("The storm currently located at (" + latitude + ", " + longitude
                + ") is moving " + speed + "MPH " + direction + "." );
    }
}

class Thunderstorm extends Storm{
    private int numberOfLightningStrikes;


    public int getNumberOfLightningStrikes() {
        return numberOfLightningStrikes;
    }

    public void setNumberOfLightningStrikes(int numberOfLightningStrikes) {
        this.numberOfLightningStrikes = numberOfLightningStrikes;
    }

    Thunderstorm(double latitude, double longitude, double speed,
                 Direction direction, int numberOfLightningStrikes){
        super(latitude, longitude, speed, direction);
        this.numberOfLightningStrikes = numberOfLightningStrikes;
    }

    public void displayLightningStrikes(){
        String message;
        if (numberOfLightningStrikes == 1){
            message = "There has been one lightning strike.";
        }
        else {
            message = "There have been " + numberOfLightningStrikes
                    + " lightning strikes.";
        }

        System.out.println(message);
    }


}

public class Main {
    public static void main(String[] args){
        Thunderstorm thunderStorm = new Thunderstorm(39.970, -82.989, 5, Direction.East, 20);

        thunderStorm.display();
        thunderStorm.displayLightningStrikes();

    }
}
