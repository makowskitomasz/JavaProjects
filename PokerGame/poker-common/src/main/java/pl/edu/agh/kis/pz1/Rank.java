package pl.edu.agh.kis.pz1;

public enum Rank {

    ACE(60){
        @Override
        public String toString() {
            return "A";
        }
    },
    KING(55){
        @Override
        public String toString() {
            return "K";
        }
    },
    QUEEN(50){
        @Override
        public String toString() {
            return "Q";
        }
    },
    JACK(45){
        @Override
        public String toString() {
            return "J";
        }
    },
    TEN(40){
        @Override
        public String toString() {
            return "10";
        }
    },
    NINE(35){
        @Override
        public String toString() {
            return "9";
        }
    },
    EIGHT(30){
        @Override
        public String toString() {
            return "8";
        }
    },
    SEVEN(25){
        @Override
        public String toString() {
            return "7";
        }
    },
    SIX(20){
        @Override
        public String toString() {
            return "6";
        }
    },
    FIVE(15){
        @Override
        public String toString() {
            return "5";
        }
    },
    FOUR(10){
        @Override
        public String toString() {
            return "4";
        }
    },
    THREE(5){
        @Override
        public String toString() {
            return "3";
        }
    },
    TWO(0){
        @Override
        public String toString() {
            return "2";
        }
    };

    final int value;

    /**
     * Mathod that returns value of rank
     * @param value_ value of rank
     */
    Rank(int value_){
        this.value = value_;
    }
}
