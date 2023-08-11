package pl.edu.agh.kis.pz1;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        int numberOfPlayers = game.chooseNumberOfPlayers();
        game.createPlayers(numberOfPlayers);
        game.prepareDeck();
        game.dealCards();
        for(Player player : game.players){
            System.out.println(player.getPlayersHand());
        }
        int howMany = game.howManyToExchange();
        for (int i = 0; i < howMany; i++) {
            int whichOne = game.takeDecision();
            game.players.get(0).exchange(whichOne, game.deck.getTopCard());
            System.out.println(game.players.get(0).getPlayersHand());
        }
        for(Player player : game.players){
            System.out.println(player.getPlayersHand());
        }
    }
}
