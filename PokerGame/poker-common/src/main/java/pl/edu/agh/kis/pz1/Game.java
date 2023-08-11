package pl.edu.agh.kis.pz1;

import java.util.*;

/**
 * @author tomaszmakowski
 * A class that represents a game of poker
 */
public class Game {
    int numberOfPlayers;

    public List<Player> getListOfPlayers() {
        return listOfPlayers;
    }

    List<Player> listOfPlayers = new ArrayList<>();
    Deck deck;
    List<String> playerNames;
    Map<String, Integer> playerRanking = new HashMap<>();

    /**
     * Constructor of game class
     * @param numberOfPlayers_ number of players in game
     * creates a new deck
     */
    Game(int numberOfPlayers_) {
        this.numberOfPlayers = numberOfPlayers_;
        this.deck = new Deck();
    }

    /**
     * Shuffles the deck and deals cards to players
     */
    public void startGame(){
        deck.Shuffle();
        for (int i = 0; i < numberOfPlayers; i++) {
            listOfPlayers.add(new Player("player" + i));
        }
        for (int i = 0; i < 5; i++) {
            for (Player player : listOfPlayers) {
                player.newCardInHand(deck.getTopCard());
            }
        }

        for(Player player : listOfPlayers){
            player.Sort(player.hand);
        }
    }

    /**
     * Method that show the card in hand of the player
     * @param playerID id of the player
     * @return string with cards in hand
     */
    String printHand(int playerID){
        listOfPlayers.get(playerID).Sort(listOfPlayers.get(playerID).hand);
        StringBuilder handString = new StringBuilder();
        for (Card card : listOfPlayers.get(playerID).hand){
            handString.append(card.rank).append(" ").append(card.suit).append(" | ");
        }
        return handString.toString();
    }

    /**
     * Method that exchanges cards in hand of the player
     * @param playerId id of the player
     * @param cardId id of the card in hand
     */

    void exchangeCard(int playerId, int cardId){
        listOfPlayers.get(playerId).hand.set(cardId, deck.getTopCard());
    }

    /**
     * Method that counts points based on the players' hand
     * @param listOfPlayers list of all players
     */
    void evaluateHands(List<Player> listOfPlayers){
        HandEvaluator evaluator = new HandEvaluator();
        for(Player player : listOfPlayers){
            playerRanking.put(player.playerName, evaluator.handEvaluator(player.hand));
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(playerRanking.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (Map.Entry<String, Integer> value : list) {
            System.out.println(value.getKey() + " " + value.getValue());
        }

        for (Map.Entry<String, Integer> hashMap : playerRanking.entrySet()) {
            if (Objects.equals(hashMap.getValue(), Collections.max(playerRanking.values()))) {
                System.out.println("Player " + hashMap.getKey() + " " + "wins, with score: " + hashMap.getValue());
            }
        }
    }


}
