package pl.edu.agh.kis.pz1;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.*;

import static java.lang.Integer.parseInt;

/**
 * Class that defines client
 */
public class Client {
    private static SocketChannel server = null;
    private static int port = 8000;
    private static boolean connected = false;
    static final Logger logger = Logger.getLogger(Client.class);

    public static List<String> logs = new ArrayList<String>();

    public static int getPortNumber() {
        return portNumber;
    }

    public static int portNumber;

    /**
     * Main method which gets the port number as the parameter and connects to the server
     * @param args port number
     */
    public static void main(String[] args) throws IOException {

        logger.info("Starting client...");
        logs.add("Starting client...");
        logger.info("select server port, default is 8000");
        logs.add("select server port, default is 8000");
        if(args.length == 0) portNumber = 8000;
        else portNumber = Integer.parseInt(args[0]);
        connectToServer(portNumber);
        logger.info("Waiting for other players to connect...");
        logs.add("Waiting for other players to connect...");
        getCards();
        while (connected) {
            logger.info("\n"+getMessageFromServer());
            sendCardIndicesToServer();
            logger.info(getMessageFromServer());
            logger.info("Waiting for other players to play...");
            logger.info("\n"+getMessageFromServer());
            logger.info("Thank you for playing!");
            checkIfNextRound();
        }
        server.close();
    }

    /**
     * Method that connects client to the server
     * @param portNumber the mumber of port
     * @throws IOException if connection is not possible
     */
    static void connectToServer(int portNumber) throws IOException {
        try{
            server = SocketChannel.open();
            server.connect(new InetSocketAddress("localhost", portNumber));
            logger.info("Connected to server");
            connected = true;
        } catch (IOException e) {
            logger.info("Connection error - couldn't connect to server");
            }
    }

    /**
     * Auxillary method that scans integer value
     * @param scanner scanner object
     * @return integer value - number of port
     */
    static int scanForInt(Scanner scanner) {
        try{
            port = scanner.nextInt();

        }
        catch (Exception e){
            logger.info("wrong port, default will be used");
        }
        return port;
    }

    /**
     * Method that gets cards from the server
     * and log  them
     */
    static void getCards() throws IOException {
        logger.info(getMessageFromServer());
    }

    /**
     * Method that get message from the server
     * @return message from the server
     */
    static String getMessageFromServer() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.clear();
        server.write(buffer);
        buffer.flip();
        server.read(buffer);
        buffer.flip();
        return new String(buffer.array()).trim();
    }

    /**
     * Method that sends card indices to the server
     */
    private static void sendCardIndicesToServer() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
        server.write(buffer);
        logger.info("Cards sent to the server");
    }

    /**
     * Method that asks a client if he wants to play another round
     * @throws IOException if connection is not possible
     */
    static void checkIfNextRound() throws IOException {
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (!input.equals("y") && !input.equals("n")) {
            logger.info("If you want to play another round press y, if not press n");
            scanner.useDelimiter("");
            input = scanner.next();
        }
        ByteBuffer buffer = ByteBuffer.wrap(input.getBytes());
        server.write(buffer);
        String message = getMessageFromServer();
        logger.info(message);
        if (message.equals("GameOver")) {
            connected = false;
        }
    }
}
