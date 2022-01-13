package game;

public class Wall {
    private int hp=100;
    private float blockPercent=0.1f;

    public void IncreaseWallHp(){
        hp+=75;
    }

    public void IncreaseWallBlock(){
        blockPercent+=0.05f;
    }

    public void decreaseHp(int atkPoint){
        hp-=atkPoint;
    }

    public void increaseHp(){
        hp+=75;
    }

    public void displayStats(){
        //System.out.println("\n");
        System.out.println("Wall's HP : "+hp);
        System.out.println("Wall's Block : "+(blockPercent*100) + "%");
    }

    //getters
    public float getBlockPercent(){
        return blockPercent;
    }
    public int getHp(){
        return hp;
    }
}
