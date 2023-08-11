package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandEvaluatorTest {
    Player player = new Player("example");
    Map<Rank, Integer> handRanking = new HashMap<>();
    List<Integer> numberOfCards = new ArrayList<>();

    /**
     * Test if the ranking of players is created properly
     */
    @Test
    public void correctListOfValues(){
        player.hand.add(new Card(Rank.ACE, Suit.SPADES));
        player.hand.add(new Card(Rank.ACE, Suit.DIAMONDS));
        player.hand.add(new Card(Rank.ACE, Suit.HEARTS));
        player.hand.add(new Card(Rank.ACE, Suit.CLUBS));
        player.hand.add(new Card(Rank.JACK, Suit.CLUBS));
        for (Card card : player.hand){
            if(!handRanking.containsKey(card.rank)) handRanking.put(card.rank, 1);
            else handRanking.put(card.rank, handRanking.get(card.rank) + 1);
        }
        assertEquals(2, handRanking.size());


        numberOfCards.addAll(handRanking.values());
        Collections.sort(numberOfCards);
        Collections.reverse(numberOfCards);

        assertEquals(Collections.max(numberOfCards), numberOfCards.get(0));
    }

    /**
     * Test if there is a flush in the hand
     */
    @Test
    public void flush(){
        player.hand.add(new Card(Rank.ACE, Suit.SPADES));
        player.hand.add(new Card(Rank.KING, Suit.SPADES));
        player.hand.add(new Card(Rank.QUEEN, Suit.SPADES));
        player.hand.add(new Card(Rank.JACK, Suit.SPADES));
        player.hand.add(new Card(Rank.TEN, Suit.SPADES));
        HandEvaluator evaluator = new HandEvaluator();
        assertEquals(1063, evaluator.handEvaluator(player.hand));
    }

    /**
     * Test if there is a quad in the hand
     */
    @Test
    public void quads(){
        player.hand.add(new Card(Rank.ACE, Suit.SPADES));
        player.hand.add(new Card(Rank.ACE, Suit.HEARTS));
        player.hand.add(new Card(Rank.ACE, Suit.DIAMONDS));
        player.hand.add(new Card(Rank.ACE, Suit.CLUBS));
        player.hand.add(new Card(Rank.TEN, Suit.SPADES));
        HandEvaluator evaluator = new HandEvaluator();
        assertEquals(963, evaluator.handEvaluator(player.hand));
    }

    /**
     * Test if there is a full house in the hand
     */
    @Test
    public void full(){
        player.hand.add(new Card(Rank.ACE, Suit.SPADES));
        player.hand.add(new Card(Rank.ACE, Suit.HEARTS));
        player.hand.add(new Card(Rank.ACE, Suit.DIAMONDS));
        player.hand.add(new Card(Rank.TEN, Suit.CLUBS));
        player.hand.add(new Card(Rank.TEN, Suit.SPADES));
        HandEvaluator evaluator = new HandEvaluator();
        assertEquals(863, evaluator.handEvaluator(player.hand));
    }

    /**
     * Test if there is a colour in the hand
     */
    @Test
    public void colour(){
        player.hand.add(new Card(Rank.KING, Suit.HEARTS));
        player.hand.add(new Card(Rank.KING, Suit.HEARTS));
        player.hand.add(new Card(Rank.QUEEN, Suit.HEARTS));
        player.hand.add(new Card(Rank.NINE, Suit.HEARTS));
        player.hand.add(new Card(Rank.EIGHT, Suit.HEARTS));
        HandEvaluator evaluator = new HandEvaluator();
        assertEquals(757, evaluator.handEvaluator(player.hand));
    }

    /**
     * Test if there is a straight in the hand
     */
    @Test
    public void straight(){
        player.hand.add(new Card(Rank.ACE, Suit.SPADES));
        player.hand.add(new Card(Rank.KING, Suit.SPADES));
        player.hand.add(new Card(Rank.QUEEN, Suit.HEARTS));
        player.hand.add(new Card(Rank.JACK, Suit.SPADES));
        player.hand.add(new Card(Rank.TEN, Suit.SPADES));
        HandEvaluator evaluator = new HandEvaluator();
        assertEquals(663, evaluator.handEvaluator(player.hand));
    }

    /**
     * Test if there is a triple in the hand
     */
    @Test
    public void three_of_kind(){
        player.hand.add(new Card(Rank.ACE, Suit.SPADES));
        player.hand.add(new Card(Rank.ACE, Suit.HEARTS));
        player.hand.add(new Card(Rank.ACE, Suit.DIAMONDS));
        player.hand.add(new Card(Rank.NINE, Suit.CLUBS));
        player.hand.add(new Card(Rank.TEN, Suit.SPADES));
        HandEvaluator evaluator = new HandEvaluator();
        assertEquals(563, evaluator.handEvaluator(player.hand));
    }

    /**
     * Test if there are two pairs in the hand
     */
    @Test
    public void two_pairs(){
        player.hand.add(new Card(Rank.ACE, Suit.SPADES));
        player.hand.add(new Card(Rank.ACE, Suit.HEARTS));
        player.hand.add(new Card(Rank.NINE, Suit.DIAMONDS));
        player.hand.add(new Card(Rank.TEN, Suit.CLUBS));
        player.hand.add(new Card(Rank.TEN, Suit.SPADES));
        HandEvaluator evaluator = new HandEvaluator();
        assertEquals(463, evaluator.handEvaluator(player.hand));
    }

    /**
     * Test if there is a pair in the hand
     */
    @Test
    public void pair(){
        player.hand.add(new Card(Rank.ACE, Suit.SPADES));
        player.hand.add(new Card(Rank.ACE, Suit.HEARTS));
        player.hand.add(new Card(Rank.NINE, Suit.DIAMONDS));
        player.hand.add(new Card(Rank.EIGHT, Suit.CLUBS));
        player.hand.add(new Card(Rank.TEN, Suit.SPADES));
        HandEvaluator evaluator = new HandEvaluator();
        assertEquals(363, evaluator.handEvaluator(player.hand));
    }

    /**
     * Test if there is a high card in the hand
     */
    @Test
    public void high_card(){
        player.hand.add(new Card(Rank.ACE, Suit.SPADES));
        player.hand.add(new Card(Rank.QUEEN, Suit.HEARTS));
        player.hand.add(new Card(Rank.NINE, Suit.DIAMONDS));
        player.hand.add(new Card(Rank.EIGHT, Suit.CLUBS));
        player.hand.add(new Card(Rank.TEN, Suit.SPADES));
        HandEvaluator evaluator = new HandEvaluator();
        assertEquals(263, evaluator.handEvaluator(player.hand));
    }


}
