package game;

public class Tower extends sameBehaviour {

    // tower constructor
    public Tower() {
        atkPoint = 5;
        critChance = 0.1f;
        accuracy = 0.8f;
    }

    // method to increase tower attack point
    public void upAtkPoint() {
        ++atkPoint;
    }

    //method to increase tower critchance
    public void upCritChance() {
        critChance += 0.05f;
        critChance = Math.min(0.5f, critChance);
        }

    //method to increase tower accuracy
    public void upAccuracy() {
        accuracy += 0.04f;
        accuracy = Math.min(1.0f, accuracy);
    }

    //method to decrease tower attack point
    public void decreaseAtkPoint(){
        --atkPoint;
    }

    //public void decreaseCritChance(){}

    //method to decrease tower accuracy
    public void decreaseAccuracy(float decreasePnt){
        accuracy -= decreasePnt;
        accuracy = Math.min(0.8f, accuracy);
    }

    @Override //from samebehavor class
    public void displayStats() {
        //System.out.println("\n");
        System.out.println("Tower's AttackPoint: " + atkPoint);
        System.out.print("Towers Critical Chance: " + String.format("%.1f", critChance * 100) + "% (Max is 50%)");
        System.out.print("\nTower's Accuracy: " + String.format("%.1f", accuracy * 100) + "% (Max is 100%) \n");
        //System.out.println("\n");

    }

    //method for overwriting parent stats for load - izzul
    public  void OWtowerCritChance(float a) {
        critChance = a;
    }
    public  void OWtowerAccuracy(float a) {
        accuracy = a;
    }
    public  void OWtowerAttackPoint(int a) {
        atkPoint = a;
    }

    //getters
    public float getTowerAccuracy() {
        return accuracy;
    }
    public int getTowerAttackPoint() {
        return atkPoint;
    }

}
