package pl.edu.agh.kis.pz1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Player{
    List<Card> hand = new ArrayList<>(5);
    String playerName;

    /**
     * Constructor of Player class
     * @param playerName name of player
     */

    Player(String playerName){
        this.playerName = playerName;
    }

    /**
     * Method to add card to player's hand
     * @param card card to add
     */
    void newCardInHand(Card card){
        hand.add(card);
    }

    /**
     * Method to sort player's hand
     */
    public void Sort(List<Card> list){
        Collections.sort(list, new Comparator<Card>() {
            @Override
            public int compare(Card card1, Card card2) {
                Suit suit1 = (card1).getSuit();
                Suit suit2 = (card2).getSuit();

                Rank rank1 = (card1).getRank();
                Rank rank2 = (card2).getRank();
                int sComp = rank1.compareTo(rank2);
                if (sComp != 0){
                    return sComp;
                }
                return suit1.compareTo(suit2);
            }
        });
    }

    /**
     * Method that changes the card at the index to the new one
     * @param number index of card to change
     * @param card new card
     */
    void exchangesCard(int number, Card card){
        hand.remove(number - 1);
        newCardInHand(card);
        Sort(hand);
    }


    /**
     * Method that returns player's hand
     * @return player's hand
     */
    String printHand(){
        StringBuilder handString = new StringBuilder();
        for (Card card : hand){
            handString.append(card.rank).append(" ").append(card.suit).append(" | ");
        }
        return handString.toString();
    }

}
