package game;

public class Tower extends sameBehaviour {

    public Tower() {
        atkPoint = 5;
        critChance = 0.1f;
        accuracy = 0.8f;
    }

    public int year;
    public int gold;
    public String SEASONS;

    public int getYear () {
        return year;
    }

    public String getSEASONS () {
        return SEASONS;
    }

    public int getGold () {
        return gold;
    }

    public void upAtkPoint() {
        ++atkPoint;
    }
    public void upCritChance() {
        critChance += 0.05f;
        critChance = Math.min(0.05f, critChance);
    }
    public void upAccuracy() {
        accuracy += 0.8f;
        accuracy = Math.min(0.8f, accuracy);
    }
    public void decreaseAtkPoint(){
        atkPoint--;
    }
    public void decreaseCritChance(){

    }

    public void decreaseAccuracy(){
        accuracy -= 0.2f;
        accuracy = Math.min(0.8f, accuracy);
    }


    public void displayStats() {
        System.out.println("Year: " + getYear());
        System.out.println("Season: " + getSEASONS());
        System.out.println("Gold: " + getGold());
        System.out.println("Tower's AttackPoint: " + atkPoint);
        System.out.println("Towers Critical Chance: " + critChance);
        System.out.println("Tower's Accuracy: " + (accuracy * 100) + "%");

    }


}
