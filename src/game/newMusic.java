package game;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class newMusic {

    static Clip clip;

    //play sound for win or lose condition
    public static void playSound(String soundLocation) {

        Scanner s = new Scanner(System.in);
        AudioInputStream audioStream = null;

        try {
            File file = new File(soundLocation);
            if (file.exists()) {
                audioStream = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            } else
                System.out.println("Cant find file!!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n Press any key and enter to exit game.");
        String responds = s.next();
    }

    //play music for dragon attack and main menu
    public static void playMusic(String musicLocation){
        try {
            File musicPath = new File(musicLocation);

            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }
            else{
                System.out.println("Can't find file");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    // call stop method to stop clip from playing
    public static void stopMusic(){
        clip.stop();
    }
}