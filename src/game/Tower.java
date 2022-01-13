package game;

public class Tower extends sameBehaviour {

    public Tower() {
        atkPoint = 5;
        critChance = 0.1f;
        accuracy = 0.8f;
    }

    public void upAtkPoint() {
        ++atkPoint;
    }

    public void upCritChance() {
        critChance += 0.05f;
        critChance = Math.min(0.5f, critChance);
    }

    public void upAccuracy() {
        accuracy += 0.8f;
        accuracy = Math.min(1.0f, accuracy);
    }

    public void decreaseAtkPoint(){
        --atkPoint;
    }

    public void decreaseCritChance(){}

    public void decreaseAccuracy(float decreasePnt){
        accuracy -= decreasePnt;
        accuracy = Math.min(0.8f, accuracy);
    }

    public void displayStats() {
        //System.out.println("\n");
        System.out.println("Tower's AttackPoint: " + atkPoint);
        System.out.println("Towers Critical Chance: " + (critChance * 100) + "%");
        System.out.println("Tower's Accuracy: " + (accuracy * 100) + "%");

    }

}
