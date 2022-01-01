package test;

import java.util.Random;

public class season {

    public Citizens citizens;
    public final String[] SEASONS = { "Spring", "Summer", "Autumn", "Winter" };

    //different test.season events
    public final String[] SPRING_EVENTS = { "Reinforcement! Tower's AttackPoint +1", "Visitors! Gold +100",
            " Festival! Berserk, Diligent and Fearless +50 " };
    public final String[] SUMMER_EVENTS = { "Drought! Wall's HealthPoint -50 ",
            "Outing! Berserk, Diligent and Fearless +50", "Heatstroke! Emotional, Nervous, Lazy +50" };
    public final String[] AUTUMN_EVENTS = { "Rainy! Tower Accuracy -20%", "Flood! Wall�s HealthPoint -50",
            "Harvest! +100 Gold" };
    public final String[] WINTER_EVENTS = { "Blizzard! Wall's HealthPoint -50",
            "Avalanche! Emotional, Nervous, Lazy +50", "Hunger! Tower Accuracy-20%", "Tour group! +100 Gold" };

    public int year = 1;
    public int currentSeason = 0;

    public Random random;
    public int gold = 200;
    String event;

    //tower
    float towerAcc = 0;
    int towerAP = 0;

    //wall
    int wallHp = 0;

    public void changeSeason() {
        // reset event's temporary effects
        if ((SEASONS[currentSeason].equals("Autumn") && event.contains("Rainy"))
                || (SEASONS[currentSeason].equals("Winter") && event.contains("Hunger")))
            towerAcc = -0.2f; //tower.decreaseAccuracy(-0.2f)

        // next test.season
        currentSeason++;
        if (currentSeason >= SEASONS.length) {
            //when it's Spring again
            currentSeason = 0;
            year++;
        }
    }

    /**
     * Executes a random event based on the current test.season
     *
     * @return the executed event
     */


    public String executeRandomEvent() {

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
                        towerAP =+1;//tower.upAtkPoint();
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
                        wallHp =-50;//wall.decreaseHp(50);
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
                        towerAcc = -0.2f; //tower.decreaseAccuracy(0.2f);// temporary
                        break;
                    case 1:
                        wallHp =-50;//wall.decreaseHp(50);
                        break;
                    case 2:
                        gold += 100;
                        break;
                }
                break;
            case "Winter":
                switch (eventIndex) {
                    case 0:
                        wallHp =-50;//wall.decreaseHp(50);
                        break;
                    case 1:
                        citizens.increaseEmotional(50);
                        citizens.increaseNervous(50);
                        citizens.increaseLazy(50);
                        break;
                    case 2:
                        towerAcc = -0.2f; //tower.decreaseAccuracy(0.2f); temporary
                        break;
                    case 3:
                        gold += 100;
                        break;
                }
                break;
        }

        return event;
    }
}
