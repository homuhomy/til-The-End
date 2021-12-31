import javax.swing.*;
import java.awt.*;

public class Game {

    JFrame window;
    Container con1;

    public static void main(String[] args) {
        new Game(); //call title
    }

    //to create a window
    public Game(){

        //create new window
        window = new JFrame();
        window.setSize(1000,800); //discuss what size for the window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(new Color(109, 215, 254, 179)); //using RGB
        window.setLayout(null); //to use custom layout
        window.setVisible(true);

        con1 = window.getContentPane();

    }
}
