package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SuitTest {
    @Test
    public void suitsHaveRightValue(){
        assertNotNull(Suit.HEARTS);
        assertNotNull(Suit.DIAMONDS);
        assertNotNull(Suit.CLUBS);
        assertNotNull(Suit.SPADES);
        assertEquals(2, Suit.HEARTS.value);
        assertEquals(1, Suit.DIAMONDS.value);
        assertEquals(0, Suit.CLUBS.value);
        assertEquals(3, Suit.SPADES.value);
    }

    @Test
    public void toStringTest(){
        assertEquals("❤", Suit.HEARTS.toString());
        assertEquals("♦", Suit.DIAMONDS.toString());
        assertEquals("♣", Suit.CLUBS.toString());
        assertEquals("♠", Suit.SPADES.toString());
    }
}

