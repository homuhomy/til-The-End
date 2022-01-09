package game;

import java.util.Random;
import java.util.Scanner;

public class dragonGame {

    //seasons
    public static final String[] SEASONS = { "Spring", "Summer", "Autumn", "Winter" };

    //different season events
    public static final String[] SPRING_EVENTS = { "Reinforcement! Tower's AttackPoint +1", "Visitors! Gold +100",
            " Festival! Berserk, Diligent and Fearless +50 " };
    public static final String[] SUMMER_EVENTS = { "oh no it's the drought! Wall's HealthPoint -50 ",
            "Outing! Berserk, Diligent and Fearless +50", "Heatstroke! Emotional, Nervous, Lazy +50" };
    public static final String[] AUTUMN_EVENTS = { "Oh no it's rainy! Tower Accuracy -20%", "Oh no it's the flood! Wall's HealthPoint -50",
            "Harvest! +100 Gold" };
    public static final String[] WINTER_EVENTS = { "Oh no it's the blizzard! Wall's HealthPoint -50",
            "Avalanche! Emotional, Nervous, Lazy +50", "Hunger! Tower Accuracy-20%", "Tour group! +100 Gold" };

    private Dragon dragon;
    //private Tower tower;
    //private Wall wall;
    public Citizens citizens;

    public int year = 1;
    public  int currentSeason = 0;
    public  int tax = 200;
    public int RandomGold = 0;
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

        //save and load game option

        //game loop starts here
        while(true){
            //execute random event
            event = executeRandomEvent();
            //execute tax from citizens
            ExecuteTax();
            tax = RandomGold;
            gold += tax;

            //copy menu game code here for menu

            //code for main menu
            //code for command panel
            //upgrade options


            // apply triggered emotions (from citizens) if any and to tower/wall stats
            if (citizens.getEmotional() >= 100) {
                //tower.decreaseAtkPoint();
                citizens.increaseEmotional(-100);
            }
            if (citizens.getNervous() >= 100) {
                //tower.decreaseAccuracy(0.05f);
                citizens.increaseNervous(-100);
            }
            if (citizens.getLazy() >= 100) {
                //wall.decreaseHp(100);
                citizens.increaseLazy(-100);
            }
            if (citizens.getBerserk() >= 100) {
                //tower.upAtkPoint();
                citizens.increaseBerserk(-100);
            }
            if (citizens.getDiligent() >= 100) {
                //wall.upHp();
                citizens.increaseDiligent(-100);
            }
            if (citizens.getFearless() >= 100) {
                //tower.upCritChance();
                citizens.increaseFearless(-100);
            }

            //put dragon attack method here
            //dragonAttack();

            //dragon level up and recovery AFTER dragonAttack is over and no win/lose yet
            //dragon.levelUp();
            //dragon.recover();

            // reset event's temporary effects
            if ((SEASONS[currentSeason].equals("Autumn") && event.contains("Rainy"))
                    || (SEASONS[currentSeason].equals("Winter") && event.contains("Hunger")))
                //tower.decreaseAccuracy(-0.2f);

            // go to next season
            currentSeason++;
            if (currentSeason >= SEASONS.length) {
                currentSeason = 0;
                year++;
            }
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
                        //tower.upAtkPoint();
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
                        //wall.decreaseHp(50);
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
                        //tower.decreaseAccuracy(0.2f);// temporary
                        break;
                    case 1:
                        //wall.decreaseHp(50);
                        break;
                    case 2:
                        gold += 100;
                        break;
                }
                break;
            case "Winter":
                switch (eventIndex) {
                    case 0:
                        //wall.decreaseHp(50);
                        break;
                    case 1:
                        citizens.increaseEmotional(50);
                        citizens.increaseNervous(50);
                        citizens.increaseLazy(50);
                        break;
                    case 2:
                        //tower.decreaseAccuracy(0.2f);// temporary
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
     * Performs dragon attack. The dragon attacks 10 times
     */

    //put dragon attack method code here

    /**
     * Perform random tax from citizens
     */
    public int ExecuteTax(){

        int [] randomGold = {200, 250, 300, 350, 400};
        Random random = new Random();
        int randomGoldIndex = random.nextInt(5);
        //System.out.println(randomGoldIndex);
        switch (randomGoldIndex){
            case 0:RandomGold = randomGold[0];
                break;
            case 1:RandomGold = randomGold[1];
                break;
            case 2:RandomGold = randomGold[2];
                break;
            case 3:RandomGold = randomGold[3];
                break;
            case 4:RandomGold = randomGold[4];
                break;
        }
        //System.out.println(RandomGold);
        return RandomGold;
    }
    /**
     * MAIN METHOD
     */
    public static void main(String args[]) {

        new dragonGame().run();
    }
}
