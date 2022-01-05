package game;

public class Dragon {
    public class dragon extends sameBehaviour {
        private int level = 1;
        private int hp = 100;

        private int currentHp = hp;
        private int currentAtkPoint;

        /**
         * Constructor
         */
        public dragon() {
            atkPoint = 7;
            recover();
        }

        /**
         * Recovers the dragon (after it flee)
         */
        public void recover() {
            currentHp = hp;
            currentAtkPoint = atkPoint;
            critChance = 0.2f;
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
            System.out.println("Dragon's Critical Chance: " + critChance);
            System.out.println("Dragon's Accuracy: " + (accuracy * 100) + "%");
        }


        public void decreaseHp(int atkPoint) {
            currentHp -= atkPoint;

        }

        //getters
        public int getHp() {
            return hp;
        }

        public int getAtkPoint() {
            return currentAtkPoint;
        }

    }
}