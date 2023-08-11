import org.junit.Test;
import pl.edu.agh.kis.pz1.util.*;

import static org.junit.Assert.*;

/**
 * A class that tests the FakturaWiersz class
 */
public class JPKTest {

    /**
     * Test for the construction of JPK no parameters
     */
    @Test
    public void nonArgsConstructorCreatesJPKElement(){
        JPK jpk = new JPK();
        assertNotNull(jpk);
    }

    /**
     * Test for the construction of JPK with parameters
     */
    @Test
    public void constructorsCalled(){
        JPK jpk = new JPK(0, "faktury-sprzedazowe-test-2023.xlsx");
        assertNotNull(jpk);
        assertNotNull(jpk.getNaglowek());
        assertNotNull(jpk.getPodmiot1());
        assertNotNull(jpk.getBillList());
        assertNotNull(jpk.getFakturaCtrl());
        assertNotNull(jpk.getListFakturaWiersz());
        assertNotNull(jpk.getFakturaWierszCtrl());
    }

    /**
     *  Test for the getter methods of JPK class
     */
    @Test
    public void rightGetters(){
        JPK jpk = new JPK(0, "faktury-sprzedazowe-test-2023.xlsx");
        assertEquals(jpk.getNaglowek().getClass(), Naglowek.class);
        assertEquals(jpk.getPodmiot1().getClass(), Podmiot1.class);
        assertEquals(jpk.getBillList().getClass(), BillList.class);
        assertEquals(jpk.getFakturaCtrl().getClass(), FakturaCtrl.class);
        assertEquals(jpk.getListFakturaWiersz().getClass(), ListFakturaWiersz.class);
        assertEquals(jpk.getFakturaWierszCtrl().getClass(), FakturaWierszCtrl.class);
    }
}
