package pl.edu.agh.kis.pz1;

import java.util.*;

public class HandEvaluator{
    Hands whatInHand = Hands.HIGH_CARD;
    private boolean colour = true;
    private boolean straight = true;
    int highestCard = 0;
    Map<Rank, Integer> handRanking = new HashMap<>();
    List<Integer> numberOfCards = new ArrayList<>();

    HandEvaluator(){

    }

    /**
     * method that counts points of hand (the better cards the more points you gain
     * @param hand list of cards in hand
     * @return points of hand
     */
    public int handEvaluator(List<Card> hand){
        for (Card card : hand){
            if(!handRanking.containsKey(card.rank)) handRanking.put(card.rank, 1);
            else handRanking.put(card.rank, handRanking.get(card.rank) + 1);
        }

        numberOfCards.addAll(handRanking.values());
        Collections.sort(numberOfCards);
        Collections.reverse(numberOfCards);
        if(numberOfCards.get(0) == 4) whatInHand = Hands.QUADS;
        else if(numberOfCards.get(0) == 3 && numberOfCards.get(1) == 2) whatInHand = Hands.FULL;
        else if(numberOfCards.get(0) == 3) whatInHand = Hands.THREE_OF_KIND;
        else if(numberOfCards.get(0) == 2 && numberOfCards.get(1) == 2) whatInHand = Hands.TWO_PAIRS;
        else if(numberOfCards.get(0) == 2) whatInHand = Hands.PAIR;

        for (Card card : hand){
            if (card.rank.value + card.suit.value > highestCard) highestCard = card.rank.value + card.suit.value;
        }

        int actualCard = hand.get(0).rank.value;
        for(int i = 1; i < 5; i++){
            if(!(hand.get(i).rank.value - actualCard == -5)){
                straight = false;
                break;
            }
            actualCard = hand.get(i).rank.value;
        }
        if(straight) whatInHand = Hands.STRAIGHT;

        Suit playerSuit = hand.get(0).suit;
        for (Card card : hand) {
            if(!(card.suit == playerSuit)){
                colour = false;
                break;
            }
        }
        if(colour) whatInHand = Hands.COLOUR;

        if(colour && straight) whatInHand = Hands.FLUSH;

        return whatInHand.value + highestCard;
    }
}
