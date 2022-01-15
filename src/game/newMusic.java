package game;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class newMusic {

    public static void playmusicLose() {

        Scanner s = new Scanner(System.in);

        File file = new File("gameover1.wav");
        AudioInputStream audioStream = null;
        try {
            audioStream = AudioSystem.getAudioInputStream(file);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        try {
            clip.open(audioStream);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        clip.start();

        System.out.println("\n Press any key and enter to exit game.");
        String responds = s.next();
    }

    public static void playmusicWin() {

        Scanner s = new Scanner(System.in);

        File file = new File("win.wav");
        AudioInputStream audioStream = null;
        try {
            audioStream = AudioSystem.getAudioInputStream(file);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        try {
            clip.open(audioStream);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        clip.start();

        System.out.println("\n Press any key and enter to exit game.");
        String responds = s.next();
    }


}