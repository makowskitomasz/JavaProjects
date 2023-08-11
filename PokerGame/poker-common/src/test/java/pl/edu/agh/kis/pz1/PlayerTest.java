package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class PlayerTest {
    List<Card> hand = new ArrayList<>(5);
    Random random = new Random();

    /**
     * Test if player has right amount of cards in hand
     */
    @Test
    public void playerGetsACard(){
        Card card = new Card(Rank.ACE, Suit.SPADES);
        hand.add(card);
        assertEquals(1, hand.size());
    }

    /**
     * Test if cards in hand are Sorted
     */
    @Test
    public void cardsSorted(){
        Player player = new Player("example");
        hand.add(new Card(Rank.ACE, Suit.HEARTS));
        hand.add(new Card(Rank.ACE, Suit.SPADES));
        hand.add(new Card(Rank.ACE, Suit.DIAMONDS));
        hand.add(new Card(Rank.ACE, Suit.CLUBS));
        hand.add(new Card(Rank.TWO, Suit.HEARTS));
        player.Sort(hand);
        assertEquals(hand.get(0).suit, Suit.HEARTS);
        assertEquals(hand.get(0).rank, Rank.ACE);
        assertNotEquals(hand.get(0).suit, hand.get(1).suit);
    }

    /**
     * Test if card was exchanged to another card
     */
    @Test
    public void cardExchanged(){
        Player player = new Player("example");
        Deck deck = new Deck();
        for (int i = 0; i < 5; i++) {
            player.hand.add(deck.getTopCard());
        }
        player.exchangesCard(1, deck.getTopCard());
        if(player.hand.get(0).rank == Rank.ACE) assertNotEquals(player.hand.get(0).suit, Suit.HEARTS);
        if(player.hand.get(0).suit == Suit.HEARTS) assertNotEquals(player.hand.get(0).rank, Rank.ACE);
    }

    /**
     * Checks if the hand is properly printed
     */
    @Test
    public void handPrinted(){
        Player player = new Player("example");
        Deck deck = new Deck();
        for (int i = 0; i < 5; i++) {
            player.hand.add(deck.getTopCard());
        }
        player.Sort(player.hand);
        String handString = player.printHand();
        assertEquals("A ❤ | K ❤ | Q ❤ | J ❤ | 10 ❤ | ", handString);
    }
}
