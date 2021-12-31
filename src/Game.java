import javax.swing.*;
import java.awt.*;

public class Game {

    JFrame window;

    public static void main(String[] args) {
        new Game(); //call title
    }

    public Game(){
        //create new window
        window = new JFrame;
        window.setSize(1000,800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(new Color());

    }
}
