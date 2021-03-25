package javaLearning.AdapterPattern;

import java.util.ArrayList;
import java.util.LinkedList;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "happy.mp3");
        audioPlayer.play("mp4", "unhappy.mp4");
        audioPlayer.play("vlc", "GOODTEK.vlc");
        audioPlayer.play("avi", "helloworld.avi");
        LinkedList
    }
}
