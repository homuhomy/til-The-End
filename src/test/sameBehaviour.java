package test;

public abstract class sameBehaviour {
    protected int atkPoint;
    protected float critChance = 0.1f;
    protected float accuracy = 0.8f;

    /**
     * Displays the stats
     *
     */
    public abstract void displayStats();


    //getters
    public float getCritChance() {
        return critChance;
    }

    public int getAtkPoint() {
        return atkPoint;
    }
}
