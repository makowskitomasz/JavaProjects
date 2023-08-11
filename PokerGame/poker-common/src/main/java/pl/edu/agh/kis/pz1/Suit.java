package pl.edu.agh.kis.pz1;

public enum Suit {
    HEARTS(2) {
        @Override
        public String toString() {
            return "❤";
        }
    },
    DIAMONDS(1){
        @Override
        public String toString() {
            return "♦";
        }
    },
    CLUBS(0)
    {
        @Override
        public String toString() {
            return "♣";
        }
    },
    SPADES(3)
    {
        @Override
        public String toString() {
            return "♠";
        }
    };

    final int value;

    /**
     * Method to get value of suit
     * @param value_ value of suit
     */
    Suit(int value_){
        this.value = value_;
    }
}
