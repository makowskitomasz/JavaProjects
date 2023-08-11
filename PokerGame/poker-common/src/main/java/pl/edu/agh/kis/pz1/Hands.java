package pl.edu.agh.kis.pz1;

public enum Hands {
    FLUSH(1000),
    QUADS(900),
    FULL(800),
    COLOUR(700),
    STRAIGHT(600),
    THREE_OF_KIND(500),
    TWO_PAIRS(400),
    PAIR(300),
    HIGH_CARD(200);

    final int value;

    /**
     * @param value_ value of hand
     */
    Hands(int value_){
        this.value = value_;
    }
}
