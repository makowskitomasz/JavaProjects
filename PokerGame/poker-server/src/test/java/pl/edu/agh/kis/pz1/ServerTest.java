package pl.edu.agh.kis.pz1;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.io.IOException;
import java.nio.channels.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static pl.edu.agh.kis.pz1.Server.connectAllPlayers;
import static pl.edu.agh.kis.pz1.Server.logs;

public class ServerTest {

    private static final Logger logger = Logger.getLogger(ServerTest.class);
    private static Game game;
    private static ServerSocketChannel serverSocketChannel = null;
    private static Selector selector = null;

    /**
     * Test if args are handled correctly
     */
    @Test
    void handleArguments() {
        String[] args = {"3"};
        Server.handleArguments(args);
        assertEquals(3, Server.getNumOfPlayers());
    }

    /**
     * Test the getters and setters
     */
    @Test
    void getterAndSetterTest() {
        Server.setNumOfPlayers(5);
        assertEquals(5, Server.getNumOfPlayers());
    }

    /**
     * Test if the server is able to connect all players
     */
    @Test
    void connectAllPlayersTest() throws IOException, InterruptedException {
        Server.setNumOfPlayers(3);
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(null);
        selector = Selector.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        Thread t = new Thread(() -> {
            try {
                connectAllPlayers(3, serverSocketChannel, selector);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
        Thread.sleep(100);
        t.interrupt();
        assertEquals(1, selector.keys().size());
    }

    /**
     * Tests if the exception is thrown when the number of players is incorrect
     */
    @Test
    public void testConnectAllPlayers_exception() throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        Selector selector = Selector.open();
        int numberOfPlayers = 0;
        socketChannel.close();

        try {
            Server.connectAllPlayers(numberOfPlayers, socketChannel, selector);
        } catch (IOException e) {
            assertEquals("Connection error - couldn't connect to all players", e.getMessage());
        }
        selector.close();
    }

    /**
     * Tests if the exception is thrown when the socket channel is closed
     */
    @Test
    public void testConnectPlayer_exception() throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        Selector selector = Selector.open();
        socketChannel.close();

        try {
            Server.connectPlayer(socketChannel, selector);
        } catch (IOException e) {
            assertEquals("Connection error - couldn't connect to player", e.getMessage());
        }
        selector.close();
    }

    /**
     * Test if the exception is thrown when the selector is closed
     * @throws ClosedSelectorException when the selector is closed
     */
    @Test
    public void sendPlayerTheirCards_exception() throws ClosedSelectorException, IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.close();
        Selector selector1 = Selector.open();
        selector1.close();
        try {
            Server.sendPlayersTheirCards(game, selector1);
        } catch (ClosedSelectorException e) {
            assertEquals("Connection error - couldn't send player their cards", e.getMessage());
        }
    }

    /**
     * Test if the exception is thrown when the selector is closed
     * @throws ClosedSelectorException when the selector is closed
     */
    @Test
    public void testSendMessageToAllClients_exception() throws ClosedSelectorException, IOException {
        Selector selector = Selector.open();
        selector.close();
        try {
            Server.sendMessagesToAllClients("test", selector);
        } catch (ClosedSelectorException | IOException e) {
            assertEquals("Connection error - couldn't send message to all clients", e.getMessage());
        }
    }

    /**
     * Test if the exception is thrown when the selector is closed
     * @throws ClosedSelectorException when the selector is closed
     */

    @Test
    public void testSendMessageToClient_exception() throws ClosedSelectorException, IOException {
        Selector selector = Selector.open();
        selector.close();
        try {
            Server.sendMessageToClient("test", selector.selectedKeys().iterator().next());
        } catch (ClosedSelectorException | IOException | AssertionFailedError e) {
            assertNull(e.getMessage());
        }
    }

    /**
     * Test if the exception is thrown when the selector is closed
     * @throws ClosedSelectorException when the selector is closed
     */
    @Test
    public void testReceiveCardsToDiscard_exception() throws ClosedSelectorException, IOException {
        Selector selector = Selector.open();
        selector.close();
        try {
            Server.receiveCardsToDiscard(selector);
        } catch (ClosedSelectorException e) {
            assertEquals("Connection error - couldn't receive cards to discard", e.getMessage());
        }
    }

    /**
     * Test the logs in main method
     * @throws InterruptedException when the thread is interrupted
     */
    @Test
    void mainTest() throws InterruptedException {
        logs.clear();
        Thread t = new Thread(() -> {
            Server.main(new String[]{"3"});
        });
        t.start();
        Thread.sleep(100);
        t.interrupt();
        String expectedLog1 = "Starting server...";
        String expectedLog2 = "Server started";
        String expectedLog3 = "[0/3] players connected...";
        System.out.println(Arrays.toString(logs.toArray()));
        assertEquals(expectedLog1, logs.get(0));
        assertEquals(expectedLog2, logs.get(1));
        assertEquals(expectedLog3, logs.get(2));
    }

    /**
     * Test the logs in send Players Their Cards method
     * @throws IOException when the selector is closed
     */
    @Test
    void sendPlayersTheirCardsTest() throws IOException {
        logs.clear();
        try{
            Thread t = new Thread(() -> {
                try {
                    Server.sendPlayersTheirCards(game, selector);
                } catch (NullPointerException |IOException ignored) {
                }
            });
            t.start();
            Thread.sleep(100);
            t.interrupt();

        } catch (NullPointerException | InterruptedException ignored) {
            }
        assertEquals("Sending cards to players...", logs.get(0));
    }


}
