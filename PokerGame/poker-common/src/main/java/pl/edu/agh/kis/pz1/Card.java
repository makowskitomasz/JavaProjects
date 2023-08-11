package pl.edu.agh.kis.pz1;

/**
 * A class using to show card with its rank and suit.
 */
class Card {


    Rank rank;

    Suit suit;

    /**
     * Constructor of Card class.
     * @param rank_ rank of card
     * @param suit_ suit of card
     */
    Card(Rank rank_, Suit suit_){
        this.rank = rank_;
        this.suit = suit_;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }


}
