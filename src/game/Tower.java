package game;

public class Tower<TowerStats> extends sameBehaviour {

    public int year;
    public int gold;
    public String SEASONS;

    public int getYear() {
        return year;
    }
    public String getSEASONS() { return SEASONS; }
    public int getGold() {
        return gold;
    }

    public void TowerStats() {
        int TowerStats = 0;

        switch (TowerStats){
            case 1:
                gold -= 100;
                atkPoint ++;
                break;
            case 2:
                gold -= 100;
                critChance += 5;
                if (critChance > 50)
                    critChance = 50;
                break;
            case 3:
                gold -= 100;
                accuracy+=4;
                if (accuracy > 100)
                    accuracy = 100;
                break;
            case 4:
                return;

        }

    }

    public void displayStats() {
        System.out.println("Year: " + getYear());
        System.out.println("Season: " + getSEASONS());
        System.out.println("Gold: " + getGold());
        System.out.println("Tower's AttackPoint: " + atkPoint);
        System.out.println("Towers Critical Chance: " + critChance);
        System.out.println("Towers Accuracy: " + accuracy);

    }


}
