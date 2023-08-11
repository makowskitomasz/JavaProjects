package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class CardTest
{
    Random random = new Random();

    /**
     * Test the constructor of the Card class
     */
    @Test
    public void cardObjectCreated(){
        Card card = new Card(Rank.ACE, Suit.CLUBS);
        assertNotNull(card);
    }

    /**
     * Test if the constructor creates a card with the right rank and suit
     */
    @Test
    public void rightCardCreated()
    {
        int random1 = random.nextInt(Rank.values().length);
        int random2 = random.nextInt(Suit.values().length);
        Card card = new Card(Rank.values()[random1], Suit.values()[random2]);
        assertEquals(card.rank, Rank.values()[random1]);
        assertEquals(card.suit, Suit.values()[random2]);
    }

    /**
     * Test for getters of the Card class
     */
    @Test
    public void rightGetters(){
        Card card = new Card(Rank.ACE, Suit.CLUBS);
        assertEquals(Rank.ACE, card.getRank());
        assertEquals(Suit.CLUBS, card.getSuit());
    }
}
