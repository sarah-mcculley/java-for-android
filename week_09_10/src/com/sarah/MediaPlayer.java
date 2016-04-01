package com.sarah;

import java.util.List;
import java.util.ArrayList;

class File{
    private String location;

    File(String location){
        this.location = location;
    }

    protected byte[] read(){
        int fileLength = 10; //replace with code that determines file length
        byte[] content = new byte[fileLength];
        System.out.println("Reading file from " + location);
        //code to open file and read into byte array
        //code to close file
        return content;
    }
}

interface Displayable {
    void display();
}

interface Playable{
    void play();
}

interface Sharable{
    void postOnFacebook(String message);
    void tweet(String message);
    void email(String message, String destinationAddress);
}

class Picture extends File implements Displayable, Sharable{
    private byte[] pictureData;

    Picture(String location) {
        super(location);
        pictureData = read();
    }

    @Override
    public void display() {
        System.out.println("Displaying a picture");
    }

    @Override
    public void postOnFacebook(String message) {
        System.out.println("Posting a picture with this message " + message);
    }

    @Override
    public void tweet(String message) {
        System.out.println("Tweeting about a picture with this message " + message);
    }

    @Override
    public void email(String message, String destinationAddress) {
        System.out.println("Sending a picture to "
                + destinationAddress + " with this message: " + message);
    }
}


class Song extends File implements Playable, Sharable{

    private byte[] songData;

    Song(String location) {
        super(location);
        songData = read();
    }

    @Override
    public void play() {
        System.out.println("Playing a song.");
    }

    @Override
    public void postOnFacebook(String message) {
        System.out.println("Posting a song on facebook with this message " + message);
    }

    @Override
    public void tweet(String message) {
        System.out.println("Tweeting about a song with this message " + message);
    }

    @Override
    public void email(String message, String destinationAddress) {
        System.out.println("Sending email to "
                + destinationAddress + " with this song and this message " + message);
    }
}

class Video extends File implements Playable, Sharable{

    private byte[] videoData;

    Video(String location) {
        super(location);
        videoData = read();
    }

    @Override
    public void play() {
        System.out.println("Playing a video.");
    }

    @Override
    public void postOnFacebook(String message) {
        System.out.println("Posting a video on facebook with this message " + message);
    }

    @Override
    public void tweet(String message) {
        System.out.println("Tweeting about a video with this message " + message);
    }

    @Override
    public void email(String message, String destinationAddress) {
        System.out.println("Sending email to "
                + destinationAddress + " with this video and this message " + message);
    }
}

class PlayList{
    private String name;
    private List<Playable> playListItems = new ArrayList<>();
    private Playable currentItem;

    PlayList(String name){
        this.name = name;
    }

    public String GetName(){
        return name;
    }

    public void addItem(Playable item){
        playListItems.add(item);
    }

    public void playNextItem(){
        if (playListItems.isEmpty()){
            return;
        }
        else if(currentItem == null){
            currentItem = playListItems.get(0);
        }
        else {
            int currentIndex = playListItems.indexOf(currentItem);
            int newIndex = (currentIndex + 1) % playListItems.size();
            currentItem = playListItems.get(newIndex);
        }

        currentItem.play();
    }

}


public class MediaPlayer {
    public static void main(String[] args){
        Picture pic = new Picture("image.jpg");

        pic.display();
        pic.email("Check out this picture.", "smcculle@gmail.com");

        Video movie = new Video("my_favorite_movie.avi");
        movie.play();
        movie.postOnFacebook("This is my favorite movie.");

        Song song1 = new Song("song1.mp3");
        Song song2 = new Song("song2.mp3");

        PlayList partySongs = new PlayList("Party Songs");
        partySongs.addItem(song1);
        partySongs.addItem(song2);

        partySongs.playNextItem();
        partySongs.playNextItem();
        partySongs.playNextItem();
    }

}
