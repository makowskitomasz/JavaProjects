package pl.edu.agh.kis.pz1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Deck {
    List<Card> deck = new ArrayList<>();

    /**
     * Constructor of Deck class.
     * adds all cards to deck list
     */
    Deck(){
        for (Suit suit : Suit.values()){
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, suit));
            }
        }
    }

    public List<Card> getDeck() {
        return deck;
    }

    /**
     * Method to shuffle deck.
     */

    void Shuffle(){
        Collections.shuffle(deck);
    }

    /**
     * Method to sort cards in deck.
     * @param list a list of cards to sort
     */
    public void Sort(List<Card> list){
        deck.clear();
        for (Suit suit : Suit.values()){
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, suit));
            }
        }
    }

    /**
     * Method to draw card from deck.
     * @return the card from the top of the deck
     */
    Card getTopCard(){
        return deck.remove(0);
    }

}