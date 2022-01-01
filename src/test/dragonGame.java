package test;

import java.util.Random;
import java.util.Scanner;

public class dragonGame {

    //seasons
    private static final String[] SEASONS = { "Spring", "Summer", "Autumn", "Winter" };

    //different season events
    private static final String[] SPRING_EVENTS = { "Reinforcement! Tower's AttackPoint +1", "Visitors! Gold +100",
            " Festival! Berserk, Diligent and Fearless +50 " };
    private static final String[] SUMMER_EVENTS = { "Drought! Wall�s HealthPoint -50 ",
            "Outing! Berserk, Diligent and Fearless +50", "Heatstroke! Emotional, Nervous, Lazy +50" };
    private static final String[] AUTUMN_EVENTS = { "Rainy! Tower Accuracy -20%", "Flood! Wall�s HealthPoint -50",
            "Harvest! +100 Gold" };
    private static final String[] WINTER_EVENTS = { "Blizzard! Wall�s HealthPoint -50",
            "Avalanche! Emotional, Nervous, Lazy +50", "Hunger! Tower Accuracy-20%", "Tour group! +100 Gold" };

    //taxation amounts
    private static final int[] TAX_AMOUNTS = { 200, 250, 300, 350, 400 };

    private Dragon dragon;
    //private Tower tower;
    //private Wall wall;
    private Citizens citizens;

    private int year = 1;
    private int currentSeason = 0;
    private int tax = 200;
    private int gold = 200;
    private String event;

    private Scanner scan;
    private Random random;

    /**
     * Constructor
     */
    public dragonGame() {
        dragon = new Dragon();
        //tower = new Tower();
        //wall = new Wall();
        citizens = new Citizens();

        scan = new Scanner(System.in);
        random = new Random();
    }

    /**
     * run the game
     */
    public void run(){
        //run the game
    }

    /**
     * MAIN METHOD
     */
    public static void main(String args[]) {
        new dragonGame().run();
    }
}
