package game;

import java.util.Random;
import java.util.Scanner;

public class dragonGame {

    //seasons
    public static final String[] SEASONS = { "Spring", "Summer", "Autumn", "Winter" };

    //different season events
    //extra: add more varieties to the events
    public static final String[] SPRING_EVENTS = { "Reinforcement! Tower's AttackPoint +1", "Visitors! Gold +100",
            " Festival! Berserk, Diligent and Fearless +50 " };
    public static final String[] SUMMER_EVENTS = { "oh no it's the drought! Wall's HealthPoint -50 ",
            "Outing! Berserk, Diligent and Fearless +50", "Heatstroke! Emotional, Nervous, Lazy +50" };
    public static final String[] AUTUMN_EVENTS = { "Oh no it's rainy! Tower Accuracy -20%", "Oh no it's the flood! Wall's HealthPoint -50",
            "Harvest! +100 Gold" };
    public static final String[] WINTER_EVENTS = { "Oh no it's the blizzard! Wall's HealthPoint -50",
            "Avalanche! Emotional, Nervous, Lazy +50", "Hunger! Tower Accuracy-20%", "Tour group! +100 Gold" };

    private Dragon dragon;
    private Tower tower;
    private Wall wall;
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
        tower = new Tower();
        wall = new Wall();
        citizens = new Citizens();

        scan = new Scanner(System.in);
        random = new Random();
    }

    /**
     * run the game
     */
    public void run(){
        //new game option or continue game (load)

        //new game
        System.out.println("\n");
        System.out.println("Citizen A: ...wait what is that?");
        System.out.println("Citizen B: ...is that a dragon?!");
        System.out.println("\n");

        dragonAttackArt();

        dragonAttack();
        dragonFlyingArt();
        dragon.recover();

        //game loop starts here
        while(true){
            //execute random event
            event = executeRandomEvent();
            //execute tax from citizens
            ExecuteTax();
            tax = RandomGold;
            gold += tax;


            //code for main menu
            System.out.println("_________A RANDOM EVENT HAS OCCURRED!!_____________");
            System.out.println("Event: " + event);
            System.out.println("Tax received from citizens this season: " + tax);
            System.out.println("Year: " + year);
            System.out.println("Season: " + SEASONS[currentSeason]);
            System.out.println("Gold: " + gold);

            // command panel
            int option = 0;
            do {
                System.out.println("\n");
                System.out.println("____________________________MAIN MENU____________________________");
                System.out.println("Select towers, walls and citizens to upgrade their stats OR Start Game.");
                System.out.println("1. Tower");
                System.out.println("2. Wall");
                System.out.println("3. Citizens");
                System.out.println("4. I am all ready!");
                System.out.print("Please enter your command: ");
                option = scan.nextInt();

                switch (option) {
                    case 1:
                        TowerMenu();
                        break;
                    case 2:
                        wallMenu();
                        break;
                    case 3:
                        citizensMenu();
                        break;
                    // Move to dragon attack
                    case 4:
                        break;
                    // Invalid option
                    default:
                        break;
                }

            } while (option != 4);

            // apply triggered emotions (from citizens) if any to tower/wall stats
            if (citizens.getEmotional() >= 100) {
                tower.decreaseAtkPoint();
                citizens.increaseEmotional(-100);
            }
            if (citizens.getNervous() >= 100) {
                tower.decreaseAccuracy(0.05f); //decrease 5%
                citizens.increaseNervous(-100);
            }
            if (citizens.getLazy() >= 100) {
                wall.decreaseHp(100);
                citizens.increaseLazy(-100);
            }
            if (citizens.getBerserk() >= 100) {
                tower.upAtkPoint();
                citizens.increaseBerserk(-100);
            }
            if (citizens.getDiligent() >= 100) {
                wall.IncreaseWallHp();
                citizens.increaseDiligent(-100);
            }
            if (citizens.getFearless() >= 100) {
                tower.upCritChance();
                citizens.increaseFearless(-100);
            }

            dragonAttackArt();
            dragonAttack();
            dragonFlyingArt();

            //dragon level up and recovery AFTER dragonAttack is over and no win/lose yet
            dragon.levelUp();
            dragon.recover();

            // reset event's temporary effects
            if ((SEASONS[currentSeason].equals("Autumn") && event.contains("Rainy")) || (SEASONS[currentSeason].equals("Winter") && event.contains("Hunger"))){
                tower.decreaseAccuracy(0.02f);
            }


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
     * Shows the wall menu upgrades
     */
    private void wallMenu(){
        int option = 0;
        do{
            //wall.displayStats();
            System.out.println("\n");
            System.out.println("____________CURRENT STATS____________");
            System.out.println("Year: " + year);
            System.out.println("Season: " + SEASONS[currentSeason]);
            System.out.println("Current Gold: " + gold);
            wall.displayStats();
            System.out.println("_______________________________________");
            //System.out.println("\n");
            System.out.println("Choose which to upgrade.");
            System.out.println("1. Upgrade Health (100 Gold -> 75 HealthPoint)");
            System.out.println("2. Upgrade Block Chance (100 Gold -> 5 Block Chance %)");
            System.out.println("3. Back to Menu");
            System.out.print("Please Enter your command: ");
            option = scan.nextInt();

            if (option != 3 && gold < 100)
                System.out.println("You do not have enough gold to upgrade.");
            else{
                switch(option){
                    case 1:
                        gold-=100;
                        wall.IncreaseWallHp();
                        System.out.println("Wall Health Increased by 75");
                        break;
                    case 2:
                        gold-=100;
                        wall.IncreaseWallBlock();
                        System.out.println("Wall Block Chance Increased by 5%");
                        break;
                    case 3: break;
                    default:
                        System.out.println("Invalid Option Selected.");
                        break;

                }
            }
        }while(option!=3);
    }
    /**
     * Shows the tower menu upgrades
     */

    private void TowerMenu() {

        int command = 0;
        do {
            //call tower stats from tower class
            System.out.println("\n");
            System.out.println("____________CURRENT STATS____________");
            System.out.println("Year: " + year);
            System.out.println("Season: " + SEASONS[currentSeason]);
            System.out.println("Current Gold: " + gold);
            tower.displayStats();
            System.out.println("_______________________________________");
            //System.out.println("\n");
            System.out.println("Choose which to upgrade.");
            System.out.println("1. Upgrade Attack (100 Gold -> 1 AttackPoint)");
            System.out.println("2. Upgrade Critical Chance (100 Gold -> 5 Critical Chance %");
            System.out.println("3. Upgrade Accuracy (100 Gold -> 4% Accuracy)");
            System.out.println("4. Back to menu");
            System.out.println("Please enter your command: ");
            command = scan.nextInt();

            if (command != 4 && gold < 100)
                System.out.println("You do not have enough gold to upgrade.");
            else {
                switch (command) {
                    case 1:
                        gold -= 100;
                        tower.upAtkPoint();
                        System.out.println("Tower AttackPoint upgraded +1");
                        break;
                    case 2:
                        gold -= 100;
                        tower.upCritChance();
                        System.out.println(" Tower Critical Chance Upgraded +5");
                        break;
                    case 3:
                        gold -= 100;
                        tower.upAccuracy();
                        System.out.println(" Tower Accuracy Upgraded 4%");
                        break;
                    case 4:
                        break;

                    default:
                        System.out.println("Invalid Option Selected.");
                        break;
                }
            }
        } while (command != 4);

    }


    /**
     * Shows the citizens upgrades menu
     */
    private void citizensMenu() {
        int option = 0;
        do {
            System.out.println("\n");
            System.out.println("____________________________CURRENT STATS______________________________");
            System.out.println("Year: " + year);
            System.out.println("Season: " + SEASONS[currentSeason]);
            System.out.println("Current Gold: " + gold);
            citizens.displayStats();
            System.out.println("________________________________________________________________________");
            //System.out.println("\n");
            System.out.println("Choose which to increase/decrease.");
            System.out.println("1. Decrease Emotional (50 Gold -> 50 Emotional Point)");
            System.out.println("2. Decrease Nervous (50 Gold -> 50 Nervous Point)");
            System.out.println("3. Decrease Lazy (50 Gold -> 50 Lazy Point)");
            System.out.println("4. Increase Berserk (50 Gold -> 50 Berserk Point)");
            System.out.println("5. Increase Diligent (50 Gold -> 50 Diligent Point)");
            System.out.println("6. Increase Fearless (50 Gold -> 50 Fearless Point)");
            System.out.println("7. Back to Menu");
            System.out.print("Please Enter your command: ");
            option = scan.nextInt();

            if (option != 7 && gold < 50)
                System.out.println("You do not have enough gold to upgrade.");
            else {
                switch (option) {
                    case 1:
                        gold -= 50;
                        citizens.decreaseEmotional();
                        System.out.println("Citizens Emotional decreased -50");
                        break;
                    case 2:
                        gold -= 50;
                        citizens.decreaseNervous();
                        System.out.println("Citizens Nervous decreased -50");
                        break;
                    case 3:
                        gold -= 50;
                        citizens.decreaseLazy();
                        System.out.println("Citizens Lazy decreased -50");
                        break;
                    case 4:
                        gold -= 50;
                        citizens.increaseBerserk();
                        System.out.println("Citizens Berserk Increased +50");
                        break;
                    case 5:
                        gold -= 50;
                        citizens.increaseDiligent();
                        System.out.println("Citizens Diligent Increased +50");
                        break;
                    case 6:
                        gold -= 50;
                        citizens.increaseFearless();
                        System.out.println("Citizens Fearless Increased +50");
                        break;
                    case 7:
                        break;

                    default:
                        System.out.println("Invalid Option Selected.");
                        break;
                }
            }

        } while (option != 7);
    }

    /**
     * Performs dragon attack. The dragon attacks 10 times
     */
    private void dragonAttack() {
        System.out.println("A dragon performs a sudden attack to your city!");
        dragon.displayStats();
        System.out.println("\n");

        // sleep for 3 second
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {

            // 1. Dragon attack on wall
            int atkPoint = dragon.getAtkPoint();
            boolean isCriticalAtk = Math.random() <= dragon.getCritChance();
            if (isCriticalAtk)
                atkPoint += (int) (atkPoint * 0.5f);

            boolean hasWallBlockedAtk = Math.random() <= wall.getBlockPercent();
            if (hasWallBlockedAtk) {
                System.out.println("Wall successfully blocked dragon's attack!");
                System.out.println("Current Wall's HealthPoint: " + wall.getHp());
            } else {
                wall.decreaseHp(atkPoint);
                System.out.println("Dragon attacked our wall!");
                System.out.println("Wall's health point minus " + atkPoint);
                System.out.println("Current Wall's HealthPoint: " + wall.getHp());
            }

            System.out.println("\n\n");

            //fix dragonHp
            // 2. Tower attack on Dragon
            atkPoint = tower.getAtkPoint();
            isCriticalAtk = Math.random() <= tower.getCritChance();
            if (isCriticalAtk)
                atkPoint += (int) (atkPoint * 0.5f);

            dragon.decreaseHp(atkPoint);
            if (isCriticalAtk)
                System.out.println("Tower attacked dragon with critical attack!");
            else
                System.out.println("Tower attacked dragon!");
            System.out.println("Dragon's health point minus " + atkPoint);
            System.out.println("Current Dragon's HealthPoint: " + dragon.getHp());

            // Check if won/lose
            if (dragon.getHp() <= 0) {
                System.out.println("You killed the dragon! You protected the city!");
                System.exit(0);
            } else if (wall.getHp() <= 0) {
                gameOver();
                System.out.println("You failed to protect your city!");
                System.exit(0);
            }

            System.out.println("\n");

            // sleep for 1 second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void gameOver(){
        System.out.println("\n" +
                "╭━━━┳━━━┳━╮╭━┳━━━╮╭━━━┳╮╱╱╭┳━━━┳━━━╮\n" +
                "┃╭━╮┃╭━╮┃┃╰╯┃┃╭━━╯┃╭━╮┃╰╮╭╯┃╭━━┫╭━╮┃\n" +
                "┃┃╱╰┫┃╱┃┃╭╮╭╮┃╰━━╮┃┃╱┃┣╮┃┃╭┫╰━━┫╰━╯┃\n" +
                "┃┃╭━┫╰━╯┃┃┃┃┃┃╭━━╯┃┃╱┃┃┃╰╯┃┃╭━━┫╭╮╭╯\n" +
                "┃╰┻━┃╭━╮┃┃┃┃┃┃╰━━╮┃╰━╯┃╰╮╭╯┃╰━━┫┃┃╰╮\n" +
                "╰━━━┻╯╱╰┻╯╰╯╰┻━━━╯╰━━━╯╱╰╯╱╰━━━┻╯╰━╯");
    }
    public void dragonFlyingArt(){
        System.out.println("\t\t         \\`----.__                 ____               \n" +
                "\t\t\t\t  |       `--._         <=#  , *--,           \n" +
                " \t\t\t\t  /_             `-.    ,/  / `````            \n" +
                " \t\t\t\t    \\__             (_.'  ,'                   THE DRAGON FLEW AWAY\n" +
                "\t\t\t\t       \\__ ......'       \\___----^__           \n" +
                "\t\t\t\t      ./               ,'           `.         \n" +
                "\t\t\t  |\\     _.'   ___/ )\\...._\"   ___           \\        \n" +
                "\t\t\t  | \\__.'  __.'            `\"\"'   `\"\"`.'\"\"\"`--\\       \n" +
                "\t\t\t   \\____.-'                                           \n");

        // sleep for 1 second
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dragonAttackArt(){
        System.out.println("" +
                "                                                                        |          |            \n" +
                "                                                                        #          #            \n" +
                "                                                                        %%        *%            \n" +
                "                                                                       /*/       (#(\\           \n" +
                "                                                                      /  %&      &( /,          \n" +
                "       \\****__              ____                       #%%%%%         %/,%/     ((,/&          \n" +
                "         |    *****\\_      --/ *\\-__                   #%%%%%         (/* #(    ./,/ /          \n" +
                "         /_          (_    ./ ,/----'                  #%%%%%         (/* /(    ./,/ /          \n" +
                "           \\__         (_./  /                         #%%%%%         %%%%&&    @##%#@/         \n" +
                "              \\__           \\___----^__                #%%%%%         /,* (#    @%,/ //         \n" +
                "               _/   _                  \\               #%%%%%         /,* (#    @%,/ //         \n" +
                "        |    _/  __/ )\\\"\\ _____         *\\             #%%%%%         /,* (/****(%,/ //         \n" +
                "        |\\__/   /    ^ ^       \\____      )            #%%%%%         /,* (# /\\ @%,/ //         \n" +
                "         \\___--\"                    \\_____ )           #%%%%%         /,* (#    @%,/ //         \n" +
                "                                          \"            #%%%%%         /,* (#    @%,/ //         \n" +
                "                                                       #%%%%%         /,* (#    @%,( //         \n" +
                "                                                       #%%%%%         /,* (#    @%,( (/         \n" +
                "                                                       #%%%%%         /,* ##%.(@@@,( (/         \n" +
                "                                                       #%%%%%        @@@@@@@@.@*%*@@@@@@ ");

        // sleep for 1 second
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * MAIN METHOD
     */
    public static void main(String args[]) {

        new dragonGame().run();
    }
}