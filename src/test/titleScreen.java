package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class titleScreen {

    JFrame window;
    Container con1;
    JPanel titleScreenPanel, startButtonPanel;
    JButton startButton, loadButton;
    JLabel titleScreenLabel;
    Font pixelFont;
    Font titleFont1 = new Font("Times New Roman", Font.PLAIN, 50);
    Font buttonFontBig = new Font("Times New Roman", Font.PLAIN, 25);
    Font buttonFontSmall = new Font("Times New Roman", Font.PLAIN, 20);

    //for the buttons
    JPanel mainTextPanel, choiceButtonPanel;
    JTextArea mainTextArea;
    titleScreenHandler tsHandler = new titleScreenHandler();
    JButton towerButton, wallButton, citizenButton, continueButton;

//    //for wall and dragon hp
//    JPanel hpPanel;
//    JLabel dragonHpLabel, dragonHpLabelNum, wallHpLabel, wallHpLabelNum;
//    int wallHp, dragonHp;


    //to create a window
    public titleScreen(){

        //create new window
        window = new JFrame();
        window.setSize(800,600); //discuss what size for the window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black); //using RGB
        window.setLayout(null); //to use custom layout
        //window.setResizable(false);
        con1 = window.getContentPane();

        titleScreenPanel = new JPanel();
        titleScreenPanel.setBounds(100,100,600,150);
        titleScreenPanel.setBackground(Color.black); //for debug
        //titleScreenPanel.setOpaque(false); //make it transparent

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
        startButton.setFont(buttonFontBig);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        loadButton= new JButton("LOAD");
        loadButton.setBackground(Color.white); //color of button
        loadButton.setForeground(Color.black); //color of text
        loadButton.setFont(buttonFontBig);

        titleScreenPanel.add(titleScreenLabel);
        startButtonPanel.add(startButton);
        startButtonPanel.add(loadButton);
        con1.add(titleScreenPanel);
        con1.add(startButtonPanel);
        window.setVisible(true);
    }

    public void createGameScreen(){
        //need to disable these panels so it wont be visible when we click start
        titleScreenPanel.setVisible(false);
        startButtonPanel.setVisible(false);


        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setBackground(Color.black);
        con1.add(mainTextPanel);

        mainTextArea = new JTextArea("Event : [randomEvent]\n" +
                "Tax received from citizens this test.season: [random gold]\n" + "\n" +
                "Year : [current year]\n" +
                "Season : [current test.season]\n" +
                "Gold : [current gold accumulated]");

        mainTextArea.setBounds(150,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(buttonFontBig);
        mainTextArea.setLineWrap(true); //will wrap automatically if text too long
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250,350,300,150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con1.add(choiceButtonPanel);

        towerButton = new JButton("Upgrade Tower");
        towerButton.setForeground(Color.black);
        towerButton.setFont(buttonFontBig);
        choiceButtonPanel.add(towerButton);

        wallButton = new JButton("Upgrade Wall");
        wallButton.setForeground(Color.black);
        wallButton.setFont(buttonFontBig);
        choiceButtonPanel.add(wallButton);

        citizenButton = new JButton("test.Citizens");
        citizenButton.setForeground(Color.black);
        citizenButton.setFont(buttonFontBig);
        choiceButtonPanel.add(citizenButton);

        continueButton = new JButton("I'm all ready!");
        continueButton.setForeground(Color.black);
        continueButton.setFont(buttonFontBig);
        choiceButtonPanel.add(continueButton);

//        hpPanel = new JPanel();
//        hpPanel.setBounds(100,15,600,50);
//        hpPanel.setBackground(Color.black);
//        hpPanel.setLayout(new GridLayout(1,4));
//        con1.add(hpPanel);

//        //this one for dragonAttack
//        dragonHpLabel = new JLabel("Dragon HP: ");
//        dragonHpLabel.setFont(buttonFontSmall);
//        dragonHpLabel.setForeground(Color.white);
//        hpPanel.add(dragonHpLabel);
//
//        dragonHpLabelNum = new JLabel();
//        dragonHpLabelNum.setFont(buttonFontSmall);
//        dragonHpLabelNum.setForeground(Color.white);
//        dragonHpLabel.add(dragonHpLabelNum);
//
//        wallHpLabel= new JLabel("Wall HP: ");
//        wallHpLabel.setFont(buttonFontSmall);
//        wallHpLabel.setForeground(Color.white);
//        hpPanel.add(wallHpLabel);
//
//        wallHpLabelNum = new JLabel("5");
//        wallHpLabelNum.setFont(buttonFontSmall);
//        wallHpLabelNum.setForeground(Color.white);
//        wallHpLabel.add(wallHpLabelNum);
//
//        playerSetup();

    }

//    public void playerSetup(){
//        wallHp = 150;
//        dragonHp = 100;
//        dragonHpLabelNum.setText("" +dragonHp);
//        wallHpLabelNum.setText("" + wallHp);
//    }

    public class titleScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            createGameScreen();
        }
    }

}
