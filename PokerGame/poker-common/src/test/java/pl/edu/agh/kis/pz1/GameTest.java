package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GameTest {

    /**
     * Test if game is created correctly
     */
    @Test
    void gameObjectCreated(){
        Game game = new Game(2);
        assertNotNull(game);
    }

    /**
     * Test if the game is created with the right number of players
     */
    @Test
    void gameStarts(){
        Game game = new Game(2);
        game.startGame();
        assertEquals(2, game.getListOfPlayers().size());
    }

    /**
     * Test if the hand is created correctly
     */
    @Test
    void gamePrintsHand(){
        Game game = new Game(2);
        game.startGame();
        String hand = game.printHand(0);
        assertNotNull(hand);
    }

    /**
     * Test if the cards are exchanged properly
     */
    @Test
    void gameExchangesCard(){
        Game game = new Game(2);
        game.startGame();
        game.exchangeCard(0, 0);
        assertEquals(5, game.getListOfPlayers().get(0).hand.size());
    }

    /**
     * Test if the handEvaluator returns the right map of players and cards
     */
    @Test
    void gameEvaluatesHands(){
        Game game = new Game(2);
        game.startGame();
        game.evaluateHands(game.getListOfPlayers());
        assertEquals(2, game.playerRanking.size());
    }
}
