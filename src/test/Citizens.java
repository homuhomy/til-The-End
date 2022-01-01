package test;

/**
 * test.Citizens in the game
 *
 */
public class Citizens {

    public int emotional = 10;
    public int nervous = 10;
    public int lazy = 10;
    public int berserk = 10;
    public int diligent = 10;
    public int fearless = 10;

    public void decreaseEmotional() {
        Math.max(emotional - 50, 0);
    }

    public void decreaseNervous() {
        Math.max(nervous - 50, 0);
    }

    public void decreaseLazy() {
        Math.max(lazy - 50, 0);
    }

    public void increaseBerserk() {
        berserk += 50;
    }

    public void increaseDiligent() {
        diligent += 50;
    }

    public void increaseFearless() {
        fearless += 50;
    }

    public void increaseEmotional(int amount) {
        emotional += amount;
    }

    public void increaseNervous(int amount) {
        nervous += amount;
    }

    public void increaseLazy(int amount) {
        lazy += amount;
    }

    public void increaseBerserk(int amount) {
        berserk += amount;

    }

    public void increaseDiligent(int amount) {
        diligent += amount;
    }

    public void increaseFearless(int amount) {
        fearless += amount;

    }

    /**
     * displays the stats of the citizens
     */
    public void displayStats() {
        System.out.println("Citizen's Emotional (Decrease Tower's AttackPoint by 1) : " + emotional);
        System.out.println("Citizen's Nervous (Decrease Tower Accuracy Percentage by 5%) : " + nervous);
        System.out.println("Citizen's Lazy (Decrease Wall's HealthPoint by 100) : " + lazy);
        System.out.println("Citizen's Berserk (Increase Tower's AttackPoint by 1) : " + berserk);
        System.out.println("Citizen's Diligent (Increase Wall's HealthPoint by 75) : " + diligent);
        System.out.println("Citizen's Fearless (Increase Tower Critical Chance Percentage by 5%) : " + fearless);
    }

    // getters

    public int getEmotional() {
        return emotional;
    }

    public int getNervous() {
        return nervous;
    }

    public int getLazy() {
        return lazy;
    }

    public int getBerserk() {
        return berserk;
    }

    public int getDiligent() {
        return diligent;
    }

    public int getFearless() {
        return fearless;
    }

}
