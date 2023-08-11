package pl.edu.agh.kis.pz1;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;

import org.apache.log4j.Logger;
import org.opentest4j.AssertionFailedError;

/**
 * @author tomaszmakowski
 * Class that represents server. It is responsible for accepting new connections for each of the Clients.
 */
public class Server {
    public static Selector selector = null;

    public static int getNumOfPlayers() {
        return numOfPlayers;
    }

    public static void setNumOfPlayers(int numOfPlayers) {
        Server.numOfPlayers = numOfPlayers;
    }

    private static int numOfPlayers = 4;
    public static ServerSocketChannel sSocket = null;
    private static Game game;
    private static boolean newRound = true;
    static final Logger logger = Logger.getLogger(Server.class.getName());

    public static List<String> logs = new ArrayList<>();

    /**
     * Method that starts the server.
     * Creates the connections
     * Decides how many rounds are played
     * Main method of the program
     * @param args - arguments of the program, the first one is the number of players
     */
    public static void main(String[] args) {
        logger.info("Starting server...");
        logs.add("Starting server...");
        handleArguments(args);
        try {
            selector = Selector.open();
            sSocket = ServerSocketChannel.open();
            ServerSocket serverSocket = sSocket.socket();
            serverSocket.bind(new InetSocketAddress("localhost", 8000));
            sSocket.configureBlocking(false);
            int ops = sSocket.validOps();

            sSocket.register(selector, ops, null);
            logger.info("Server started");
            logs.add("Server started");
            connectAllPlayers(numOfPlayers, sSocket, selector);
            while (newRound) {
                game = new Game(numOfPlayers);
                game.startGame();
                sendPlayersTheirCards(game, selector);
                sendMessagesToAllClients("Chose your cards to discard (0-4) for example 0 2 3" +
                        "if you don't wanto to discard any cards type -1", selector);
                receiveCardsToDiscard(selector);
                sendResultsToAllPlayers();
                getInfoAboutNewRound();
            }
            serverSocket.close();

        } catch (IOException e) {
            logger.info("Connection error");
        }
    }

    /**
     * Method that handles the arguments of the program
     * @param args - arguments of the program the first one is the number of players
     */
    public static void handleArguments(String[] args) {
        if (args.length == 1) {
            try {
                numOfPlayers = Integer.parseInt(args[0]);
                if (numOfPlayers < 2 || numOfPlayers > 4) {
                    logger.info("Wrong number of players, default will be used");
                    numOfPlayers = 4;
                }
            } catch (NumberFormatException e) {
                logger.info("Wrong argument, default number of players will be used");
                numOfPlayers = 4;
            }
        }else {
            logger.info("Wrong number of arguments, default number of players will be used");
            numOfPlayers = 4;
        }
    }
    /**
     * Method that connects all players to the server
     * @param numberOfPlayers - number of players
     * @param socketChannel - server socket
     * @param selector - selector
     * @throws IOException - exception
     */
    public static void connectAllPlayers(int numberOfPlayers, ServerSocketChannel socketChannel, Selector selector) throws IOException {
        int connectedPlayers = 0;
        try {
            logger.info("["+connectedPlayers +"/"+ numberOfPlayers+"] players connected...");
            logs.add("["+connectedPlayers +"/"+ numberOfPlayers+"] players connected...");
            // dopóki nie dołączy się odpowiednia liczba graczy serwer czeka na ich połączenie
            while (connectedPlayers < numberOfPlayers) {
                selector.select();
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keysIterator = selectedKeys.iterator();
                while (keysIterator.hasNext()) {
                    SelectionKey key = keysIterator.next();
                    if (key.isAcceptable()) {
                        connectPlayer(socketChannel, selector);
                        connectedPlayers++;
                        logger.info("["+connectedPlayers +"/"+ numberOfPlayers+"] players connected...");
                    }
                    keysIterator.remove();
                }
            }
            logger.info("["+connectedPlayers +"/"+ numberOfPlayers+"] players connected...");
        } catch (IOException e) {
            logger.info("Connection error - couldn't connect to all players");
            System.exit(1);
        }
    }

    /**
     * Method that connects one player to the server
     * @param sSocket - server socket
     * @param selector - selector
     * @throws IOException - exception if connection error
     */
    static void connectPlayer(ServerSocketChannel sSocket, Selector selector) throws IOException {
        try{
            SocketChannel sChannel = sSocket.accept();
            sChannel.configureBlocking(false);
            sChannel.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            logger.info("Connection error - couldn't connect to player");
        }
    }

    /**
     * Method that sends the cards to the players
     * @param gm - game object
     * @param selector - selector
     * @throws IOException - exception if connection error
     */
    public static void sendPlayersTheirCards(Game gm, Selector selector) throws IOException {
        int sentCards = 0;
        try {
            logger.info("Sending cards to players...");
            logs.add("Sending cards to players...");
            while (sentCards < numOfPlayers){
                selector.select();
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keysIterator = selectedKeys.iterator();
                while (keysIterator.hasNext()) {
                    SelectionKey key = keysIterator.next();
                    if (key.isReadable()) {
                        int playerID = sentCards;
                        key.attach(playerID);
                        String s = gm.printHand(playerID);
                        sendMessageToClient(s, key);
                        sentCards++;
                        logger.info("sent cards to player #" + playerID);
                    }else{
                        logger.info("key not readible");
                    }
                    keysIterator.remove();
                }
            }
        } catch (ClosedSelectorException e) {
            logger.info("Connection error - couldn't send players their cards");
        }
    }
    /**
     * Method that sends message to all clients
     * @param message - message to send
     * @param selector - selector
     * @throws IOException - exception if connection error
     */
    static void sendMessagesToAllClients(String message, Selector selector) throws IOException {
        try {
            int sentMessages = 0;
            while (sentMessages < numOfPlayers){
                selector.select();
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keysIterator = selectedKeys.iterator();
                while (keysIterator.hasNext()) {
                    SelectionKey key = keysIterator.next();
                    if (key.isReadable()) {
                        sendMessageToClient(message, key);
                        sentMessages++;
                    }
                    keysIterator.remove();
                }
            }
        }
        catch (ClosedSelectorException e) {
            logger.info("Connection error - couldn't send messages to all clients");
        }
    }

    /**
     * Method that send message to one clienta
     * @param message - message to send
     * @param key - key of the client
     * @throws IOException - exception if connection error
     */
    static void sendMessageToClient(String message, SelectionKey key) throws IOException {
        try{
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            SocketChannel client = (SocketChannel) key.channel();
            buffer.clear();
            buffer = ByteBuffer.wrap(message.getBytes());
            client.write(buffer);
            buffer.clear();
        }
        catch (IOException | AssertionFailedError e) {
            logger.info("Connection error - couldn't send message to client");
        }
    }
    /**
     * Metoda służąca do odbierania wiadomości od wskazanego klienta
     * @param key klucz do klienta
     */
    static String readFromClient(SelectionKey key)  {
        try {
            SocketChannel client = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(512);
            client.read(buffer);

            return new String(buffer.array()).trim();
        }
        catch (IOException e) {
            logger.info("Connection error - couldn't read message from client");
            System.exit(1);
        }
        return "error";
    }

    /**
     * Method that receives cards from the players to be discarded
     * @param selector - selector
     */
    static void receiveCardsToDiscard(Selector selector){
        try {
            int receivedMessages = 0;
            while (receivedMessages < numOfPlayers){
                selector.select();
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keysIterator = selectedKeys.iterator();
                while (keysIterator.hasNext()) {
                    SelectionKey key = keysIterator.next();
                    receivedMessages = getReceivedMessages(receivedMessages, keysIterator, key);
                }
            }
        }
        catch (IOException | ClosedSelectorException e) {
            logger.info("Connection error - " +
                    "couldn't receive messages from all clients");
        }
    }

    /**
     * Method that receives messages from the players
     * @param receivedMessages - number of received messages
     * @param keysIterator - iterator of keys
     * @param key - key of the client
     * @return - number of received messages
     * @throws IOException - exception if connection error
     */
    private static int getReceivedMessages(int receivedMessages, Iterator<SelectionKey> keysIterator, SelectionKey key) throws IOException {
        if (key.isReadable() && (int) key.attachment() == receivedMessages) {
            String message = readFromClient(key);
            if (!message.isEmpty()){
                int playerID = (int) key.attachment();
                if(message.equals("-1")) {
                    sendMessageToClient("No cards were exchanged\n" + game.printHand(playerID)+"\n\n", key);
                    receivedMessages++;
                }
                else{
                    String[] cardsToDiscard = message.split(" ");
                    for (String s : cardsToDiscard) {
                        game.exchangeCard(playerID, Integer.parseInt(s));
                    }
                    receivedMessages++;
                    sendMessageToClient(game.printHand(playerID)+"\n\n", key);
                }
            }
        }
        keysIterator.remove();
        return receivedMessages;
    }

    /**
     * Method that sends the results of the game to the players
     * @throws IOException - exception if connection error
     */
    static void sendResultsToAllPlayers() throws IOException {
        StringBuilder results = new StringBuilder();
        for (Player player : game.listOfPlayers){
            HandEvaluator handEvaluator = new HandEvaluator();
            results.append(player.printHand()).append(player.playerName).append(" has ").append(handEvaluator.handEvaluator(player.hand)).append(" points\n");
        }
        sendMessagesToAllClients(results.toString(), selector);
    }


    /**
     * Method that gets the messages if players want to play again
     * @throws IOException - exception if connection error
     */
    private static void getInfoAboutNewRound() throws IOException{
        int receivedMessages = 0;
        boolean gameOver = false;
        while (receivedMessages < numOfPlayers){
            selector.select();
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> keysIterator = selectedKeys.iterator();
            while (keysIterator.hasNext()) {
                SelectionKey key = keysIterator.next();
                if (key.isReadable() && (int)key.attachment() == receivedMessages) {
                    String message = readFromClient(key);
                    if(message.equals("n")){
                        newRound = false;
                        gameOver = true;
                        receivedMessages++;
                    }else if(message.equals("y")){
                        newRound = true;
                        receivedMessages++;
                    }
                }
                keysIterator.remove();
            }
        }
        checkIfGameOver(gameOver);

    }

    /**
     * Method that checks if the game is over and sends message that it is over if it is
     * @param gameOver - boolean value
     * @throws IOException - exception if connection error
     */
    static void checkIfGameOver(boolean gameOver) throws IOException {
        if(gameOver){
            sendMessagesToAllClients("GameOver", selector);
        }
    }


}
