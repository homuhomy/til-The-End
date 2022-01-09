package game;
import java.util.Random;

public class Tax {
    int RandomGold;

    public int ExecuteTax(){
        int [] randomgold = {200, 250, 300, 350, 400};
        Random random = new Random();
        int randomgoldIndex = random.nextInt(5);
        //System.out.println(randomgoldIndex);
        switch (randomgoldIndex){
            case 0:RandomGold = randomgold[0];
                break;
            case 1:RandomGold = randomgold[1];
                break;
            case 2:RandomGold = randomgold[2];
                break;
            case 3:RandomGold = randomgold[3];
                break;
            case 4:RandomGold = randomgold[4];
                break;
        }
        System.out.println(RandomGold);
        return RandomGold;
    }
}
