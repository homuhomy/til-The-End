import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class Game {

    JFrame window;
    Container con1;
    JPanel titleScreenPanel, startButtonPanel;
    JButton startButton, loadButton;
    //Box box;
    JLabel titleScreenLabel;
    Font pixelFont;
    Font titleFont1 = new Font("Times New Roman", Font.PLAIN, 50);
    Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);

    public static void main(String[] args) {
        new Game(); //call title
    }

    //to create a window
    public Game(){

        //to use custom font
//        try{
//            pixelFont = Font.createFont(Font.TRUETYPE_FONT, new File("PIXELFONT.ttf"));
//            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PIXELFONT.ttf")));
//        }
//        catch (IOException | FontFormatException e){
//        }

        //create new window
        window = new JFrame();
        window.setSize(800,600); //discuss what size for the window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(new Color(109, 215, 254, 179)); //using RGB
        window.setLayout(null); //to use custom layout
        con1 = window.getContentPane();

        titleScreenPanel = new JPanel();
        titleScreenPanel.setBounds(100,100,600,150);
        titleScreenPanel.setBackground(Color.black); //for debug
        //titleScreenPanel.setOpaque(false); //make it transparent


        //make the jpanel fixed at center [doesnt work :()
//        Box box = new Box(BoxLayout.Y_AXIS);
//
//        box.add(Box.createVerticalGlue());
//        box.add(titleScreenPanel);
//        box.add(Box.createVerticalGlue());


        //game title
        titleScreenLabel = new JLabel("TIL THE END");
        titleScreenLabel.setForeground(Color.white);
        //titleScreenLabel.setFont(pixelFont);
        titleScreenLabel.setFont(titleFont1);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 350, 200,100);
        startButtonPanel.setOpaque(false);

        startButton= new JButton("START");
        startButton.setBackground(Color.white); //color of button
        startButton.setForeground(Color.black); //color of text
        startButton.setFont(buttonFont);

        loadButton= new JButton("LOAD");
        loadButton.setBackground(Color.white); //color of button
        loadButton.setForeground(Color.black); //color of text
        loadButton.setFont(buttonFont);


        titleScreenPanel.add(titleScreenLabel);
        startButtonPanel.add(startButton);
        startButtonPanel.add(loadButton);
        con1.add(titleScreenPanel);
        con1.add(startButtonPanel);
        window.setVisible(true);

    }
}
