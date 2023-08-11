package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandsTest {
    /**
     * Checks the value of the hands
     */
    @Test
    public void handsHaveRightValue(){
        assertEquals(1000, Hands.FLUSH.value);
        assertEquals(900, Hands.QUADS.value);
        assertEquals(800, Hands.FULL.value);
        assertEquals(700, Hands.COLOUR.value);
        assertEquals(600, Hands.STRAIGHT.value);
        assertEquals(500, Hands.THREE_OF_KIND.value);
        assertEquals(400, Hands.TWO_PAIRS.value);
        assertEquals(300, Hands.PAIR.value);
        assertEquals(200, Hands.HIGH_CARD.value);
    }
}
