import java.util.Random;

public class seasonEvent {
    String season;
    String randomEventName;
    String randomEffect;
    int upperbound;
    int int_random;

    public seasonEvent() {

        season = "Spring"; //not final
        randomEventName = "";
        randomEffect = "";
        int_random = 0;

        Random randEvent = new Random(); //instance of random class

        if (season.equals("Spring")) {
            upperbound = 3; //generate random values from 0-2
            int int_random = randEvent.nextInt(upperbound);
            switch (int_random) {
                case 0:
                    randomEventName = "Reinforcement!";
                    randomEffect = "tower Attack Point +1!";
                    int towerAP = +1;
                    break;
                case 1:
                    randomEventName = "Visitors from other cities!";
                    randomEffect = "You get extra 100 Gold!";
                    int gold = +100;
                    break;
                case 2:
                    randomEventName = "It's the festival";
                    randomEffect = "berserk =+50\n" +
                            "diligent =+50\n" + "fearless=+50";
                    int berserk = +50;
                    int diligent = +50;
                    int fearless = +50;
                    break;
            }
        }
        if (season.equals("Summer")) {
            upperbound = 3;
            int int_random = randEvent.nextInt(upperbound);
            switch (int_random) {
                case 0:
                    randomEventName = "Drought!";
                    randomEffect = " wall HP -50!";
                    int wallHP = -50;
                    break;
                case 1:
                    randomEventName = "Outing!";
                    randomEffect = " Berserk =+50\n" +
                            "diligent =+50\n" + "fearless=+50";
                    int berserk = +50;
                    int diligent = +50;
                    int fearless = +50;
                    break;
                default: //case 2
                    randomEventName = "Heatstroke";
                    randomEffect = " Emotional =+50\n" +
                            "nervous =+50\n" + "lazy =+50";
                    int emotional = +50;
                    int nervous = +50;
                    int lazy = +50;
            }
        }
        if (season.equals("Autumn")) {
            upperbound = 3;
            int int_random = randEvent.nextInt(upperbound);
            switch (int_random) {
                case 0:
                    randomEventName = "Rainy!";
                    randomEffect = " Tower accuracy -20%!";
                    double towerAcc = -0.2;
                    break;
                case 1:
                    randomEventName = "Flood";
                    randomEffect = " Wall HP -50!";
                    int wallHP = -50;
                    break;
                default:
                    randomEventName = "Harvest!";
                    randomEffect = " You received extra 50 gold!";
                    int gold=+100;
            }
        }
        if (season.equals("Winter")) {
            upperbound = 4;
            int int_random = randEvent.nextInt(upperbound);
            switch (int_random) {
                case 0:
                    randomEventName = "Drought!";
                    randomEffect = "wall HP -50!";
                    int wallHP = -50;
                    break;
                case 1:
                    randomEventName = "Avalanche!";
                    randomEffect = "emotional=+50\n" + "nervous=+50\n" +"lazy=+50";
                    int berserk = +50;
                    int diligent = +50;
                    int fearless = +50;
                    break;
                case 2:
                    randomEventName = "Heatstroke";
                    randomEffect = " tower Accuracy -20%!";
                    double towerAcc =-0.2;
                    break;
                default:
                    randomEventName = "Tour group!";
                    randomEffect = " You received extra 100 Gold!";
                    int gold = +100;
                    break;
            }
        }
    }
}

