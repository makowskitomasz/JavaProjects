package pl.edu.agh.kis.pz1;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ClosedSelectorException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {
    Client client = new Client();

    /**
     * Test if client is created
     */
    @Test
    void clientObjectCreated(){
        assertNotNull(client);
    }

    /**
     * Test if scanForInt() method works properly
     */
    @Test
    void scanForIntTest(){
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        int port = Client.scanForInt(scanner);
        assertEquals(1, port);
    }

    /**
     * test if connectToServer() method catches an exception
     */
    @Test
    void connectToSever_exception(){
        try{
            Client.connectToServer(8888);
        } catch (IOException e){
            assertEquals("Connection refused: connect", e.getMessage());
        }
    }

    /**
     * tests if scanForInt() method catches an exception
     */
    @Test
    void testScanForInt_exception(){
        String input = "a";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        try{
            Client.scanForInt(scanner);
        } catch (NumberFormatException e){
            assertEquals("For input string: \"a\"", e.getMessage());
        }
    }

    /**
     * Test getter of portNumber
     */
    @Test
    void getPortNumberTest(){
        Client.portNumber = 8888;
        assertEquals(8888, Client.getPortNumber());
    }

    @Test
    void mainTest() throws IOException {
        try{
            Client.main(new String[]{"8000"});
            String expectedLog1 = "Starting client...";
            String expectedLog2 = "select server port, default is 8000";
            String expectedLog3 = "Waiting for other players to connect...";
            assertEquals(expectedLog1, Client.logs.get(0));
            assertEquals(expectedLog2, Client.logs.get(1));
            assertEquals(expectedLog3, Client.logs.get(2));
        }catch (ClosedSelectorException | ClosedChannelException e){
            assertNull(e.getMessage());
        }

    }
}
