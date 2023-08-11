package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankTest {
    @Test
    public void ranksHaveRightValue(){
        assertEquals(60, Rank.ACE.value);
        assertEquals(55, Rank.KING.value);
        assertEquals(50, Rank.QUEEN.value);
        assertEquals(45, Rank.JACK.value);
        assertEquals(40, Rank.TEN.value);
        assertEquals(35, Rank.NINE.value);
        assertEquals(30, Rank.EIGHT.value);
        assertEquals(25, Rank.SEVEN.value);
        assertEquals(20, Rank.SIX.value);
        assertEquals(15, Rank.FIVE.value);
        assertEquals(10, Rank.FOUR.value);
        assertEquals(5, Rank.THREE.value);
        assertEquals(0, Rank.TWO.value);
    }

    @Test
    public void toStringTest(){
        assertEquals("A", Rank.ACE.toString());
        assertEquals("K", Rank.KING.toString());
        assertEquals("Q", Rank.QUEEN.toString());
        assertEquals("J", Rank.JACK.toString());
        assertEquals("10", Rank.TEN.toString());
        assertEquals("9", Rank.NINE.toString());
        assertEquals("8", Rank.EIGHT.toString());
        assertEquals("7", Rank.SEVEN.toString());
        assertEquals("6", Rank.SIX.toString());
        assertEquals("5", Rank.FIVE.toString());
        assertEquals("4", Rank.FOUR.toString());
        assertEquals("3", Rank.THREE.toString());
        assertEquals("2", Rank.TWO.toString());
    }
}
