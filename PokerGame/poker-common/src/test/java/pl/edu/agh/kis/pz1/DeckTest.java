package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class DeckTest {

    /**
     * Test if deck is created and has 52 cards
     */
    @Test
    public void rightNumberOfCards(){
        Deck deck = new Deck();
        assertEquals(52, deck.getDeck().size());
    }

    /**
     * Test if created deck is sorted properly
     */
    @Test
    public void goodDeckCreated(){
        Deck deck = new Deck();
        Card downCard = new Card(Rank.TWO, Suit.SPADES);
        Card topCard = new Card(Rank.ACE, Suit.HEARTS);
        assertEquals(deck.getDeck().get(51).rank, downCard.rank);
        assertEquals(deck.getDeck().get(51).suit, downCard.suit);
        assertEquals(deck.getDeck().get(0).rank, topCard.rank);
        assertEquals(deck.getDeck().get(0).suit, topCard.suit);
    }

    /**
     * Test if deck is sorted properly after sorting
     */
    @Test
    public void deckCorrectlySorted(){
        Deck deck = new Deck();
        Card downCard = new Card(Rank.TWO, Suit.SPADES);
        Card topCard = new Card(Rank.ACE, Suit.HEARTS);
        deck.Shuffle();
        deck.Sort(deck.getDeck());
        assertEquals(deck.getDeck().get(51).rank, downCard.rank);
        assertEquals(deck.getDeck().get(51).suit, downCard.suit);
        assertEquals(deck.getDeck().get(0).rank, topCard.rank);
        assertEquals(deck.getDeck().get(0).suit, topCard.suit);
    }

    /**
     * Test if deck is shuffled properly
     */
    @Test
    public void deckCorrectlyShuffled(){
        Deck deck = new Deck();
        Card topCard = new Card(Rank.ACE, Suit.HEARTS);
        deck.Shuffle();
        for(int i = 0; i < 100; i++){
            if(topCard.suit.value + topCard.rank.value == deck.getDeck().get(0).rank.value + deck.getDeck().get(0).rank.value) deck.Shuffle();
            else break;
        }
        assertNotEquals(topCard.suit.value + topCard.rank.value, deck.getDeck().get(0).rank.value + deck.getDeck().get(0).rank.value);
    }

    /**
     * Test if getTopCard() returns top card
     */
    @Test
    public void getsTopCard(){
        Deck deck = new Deck();
        Card card;
        card = deck.getTopCard();
        assertEquals(Rank.ACE, card.rank);
        assertEquals(Suit.HEARTS, card.suit);
        assertEquals(51, deck.getDeck().size());
        card = deck.getTopCard();
        assertEquals(Rank.KING, card.rank);
        assertEquals(Suit.HEARTS, card.suit);
        assertEquals(50, deck.getDeck().size());
    }
}
