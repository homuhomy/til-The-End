package game;

/**
 * Dragon in the game.
 *
 */
public class Dragon extends sameBehaviour {

    private int level = 1;
    private int hp = 100;

    private int currentHp = hp;
    private int currentAtkPoint;

    /**
     * Constructor
     */
    public Dragon() {
        atkPoint = 7;
        critChance = 0.2f;
        recover();
    }

    /**
     * decrease dragon's hp
     */

    public void decreaseHp(int atkPoint) {
        currentHp -= atkPoint;

    }

    /**
     * Recovers the dragon
     */
    public void recover() {
        currentHp = hp; //go back to current hp
        currentAtkPoint = atkPoint;
        accuracy = 0.8f;
    }

    /**
     * Levels up the dragon
     */
    public void levelUp() {
        level++;
        hp += 15;
        atkPoint++;
        critChance += 0.02f;



    }

    @Override
    public void displayStats() {
        System.out.println("Dragon's Level: " + level);
        System.out.println("Dragon's HealthPoint: " + currentHp);
        System.out.println("Dragon's AttackPoint: " + atkPoint);
        System.out.println("Dragon's Critical Chance: " + String.format ("%.1f", critChance *100) + "%");
        System.out.println("Dragon's Accuracy: " + String.format("%.1f", accuracy * 100) + "%");
    }



    //getters
    public int getHp() {
        return currentHp;
    }

    public int getAtkPoint() {
        return currentAtkPoint;
    }



}
