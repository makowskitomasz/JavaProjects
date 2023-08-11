import org.junit.Test;
import pl.edu.agh.kis.pz1.util.ListFakturaWiersz;

import static org.junit.Assert.*;


/**
 * A class that tests the ListFakturaWiersz class
 */
public class ListFakturaWierszTest {
    ListFakturaWiersz listFakturaWiersz = new ListFakturaWiersz(0, "faktury-sprzedazowe-test-2023.xlsx");
    ListFakturaWiersz listFakturaWiersz1 = new ListFakturaWiersz(1, "faktury-sprzedazowe-test-2023.csv");

    /**
     * Test for a non-arg constructor
     */
    @Test
    public void listFakturaWierszNoArgConstructorTest(){
        ListFakturaWiersz listFakturaWiersz = new ListFakturaWiersz();
        assertNotNull(listFakturaWiersz);
    }
    /**
     * Test for the construction of ListFakturaWiersz with arguments
     */
    @Test
    public void listFakturaWierszWasCalled(){
        assertNotNull(listFakturaWiersz);
        assertNotNull(listFakturaWiersz1);
    }

    /**
     * Test for the getter methods of ListFakturaWiersz class
     */
    @Test
    public void testGetFakturaWierszList(){
        assertEquals(107, listFakturaWiersz.getfakturaWierszList().size());
        assertEquals(107, listFakturaWiersz1.getfakturaWierszList().size());
    }

    /**
     * Test for the setter methods of ListFakturaWiersz class
     */
    @Test
    public void testSetFakturaWierszList(){
        listFakturaWiersz.setfakturaWierszList(null);
        assertNull(listFakturaWiersz.getfakturaWierszList());
        listFakturaWiersz1.setfakturaWierszList(null);
        assertNull(listFakturaWiersz1.getfakturaWierszList());
    }
}
