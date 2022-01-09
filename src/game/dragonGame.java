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
        //copy menu game code here for menu

        //code for main menu
        //code for command panel
            //upgrade options


        //apply triggered emotions if any

        //dragon attack code here

        // reset event's temporary effects

        // go to next season
        currentSeason++;
        if (currentSeason >= SEASONS.length) {
            currentSeason = 0;
            year++;
        }



    }

    /**
     * Executes a random event based on the current season
     *
     * @return the executed event
     */
    private String executeRandomEvent() {

        // set random event
        String event = "";
        int eventIndex = random.nextInt(3);
        switch (SEASONS[currentSeason]) {
            case "Spring":
                event = SPRING_EVENTS[eventIndex];
                break;
            case "Summer":
                event = SUMMER_EVENTS[eventIndex];
                break;
            case "Autumn":
                event = AUTUMN_EVENTS[eventIndex];
                break;
            case "Winter":
                event = WINTER_EVENTS[eventIndex];
                break;
        }

        // apply event
        switch (SEASONS[currentSeason]) {
            case "Spring":
                switch (eventIndex) {
                    case 0:
                        tower.upAtkPoint();
                        break;
                    case 1:
                        gold += 100;
                        break;
                    case 2:
                        citizens.increaseBerserk();
                        citizens.increaseDiligent();
                        citizens.increaseFearless();
                        break;
                }
                break;
            case "Summer":
                switch (eventIndex) {
                    case 0:
                        wall.decreaseHp(50);
                        break;
                    case 1:
                        citizens.increaseBerserk();
                        citizens.increaseDiligent();
                        citizens.increaseFearless();
                        break;
                    case 2:
                        citizens.increaseEmotional(50);
                        citizens.increaseNervous(50);
                        citizens.increaseLazy(50);
                        break;
                }
                break;
            case "Autumn":
                switch (eventIndex) {
                    case 0:
                        tower.decreaseAccuracy(0.2f);// temporary
                        break;
                    case 1:
                        wall.decreaseHp(50);
                        break;
                    case 2:
                        gold += 100;
                        break;
                }
                break;
            case "Winter":
                switch (eventIndex) {
                    case 0:
                        wall.decreaseHp(50);
                        break;
                    case 1:
                        citizens.increaseEmotional(50);
                        citizens.increaseNervous(50);
                        citizens.increaseLazy(50);
                        break;
                    case 2:
                        tower.decreaseAccuracy(0.2f);// temporary
                        break;
                    case 3:
                        gold += 100;
                        break;
                }
                break;
        }

        return event;
    }

    /**
     * MAIN METHOD
     */
    public static void main(String args[]) {

        new dragonGame().run();
    }
}
