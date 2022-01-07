package game;

import java.util.Random;
import java.util.Scanner;

public class dragonGame {

    //seasons
    public static final String[] SEASONS = { "Spring", "Summer", "Autumn", "Winter" };

    //different season events
    public static final String[] SPRING_EVENTS = { "Reinforcement! Tower's AttackPoint +1", "Visitors! Gold +100",
            " Festival! Berserk, Diligent and Fearless +50 " };
    public static final String[] SUMMER_EVENTS = { "Drought! Wall�s HealthPoint -50 ",
            "Outing! Berserk, Diligent and Fearless +50", "Heatstroke! Emotional, Nervous, Lazy +50" };
    public static final String[] AUTUMN_EVENTS = { "Rainy! Tower Accuracy -20%", "Flood! Wall�s HealthPoint -50",
            "Harvest! +100 Gold" };
    public static final String[] WINTER_EVENTS = { "Blizzard! Wall�s HealthPoint -50",
            "Avalanche! Emotional, Nervous, Lazy +50", "Hunger! Tower Accuracy-20%", "Tour group! +100 Gold" };

    private Dragon dragon;
    //private Tower tower;
    //private Wall wall;
    public Citizens citizens;

    public int year = 1;
    public  int currentSeason = 0;
    public  int tax = 200;
    public int gold = 200;
    public String event;

    public Scanner scan;
    public Random random;

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
