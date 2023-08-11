import org.junit.Test;
import pl.edu.agh.kis.pz1.util.FakturaCtrl;
import pl.edu.agh.kis.pz1.util.FakturaWierszCtrl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * A class that tests the FakturaWierszCtrl class
 */
public class FakturaWierszCtrlTest {
    FakturaWierszCtrl fakturaWierszCtrl = new FakturaWierszCtrl(0, "faktury-sprzedazowe-test-2023.xlsx");
    FakturaWierszCtrl fakturaWierszCtrl1 = new FakturaWierszCtrl(1, "faktury-sprzedazowe-test-2023.csv");

    /**
     * Test of non arg constructor
     */
    @Test
    public void nonArgConstructorCalled(){
        FakturaWierszCtrl fakturaWierszCtrl2 = new FakturaWierszCtrl();
        assertNotNull(fakturaWierszCtrl2);
    }
    /**
     * Tests if the constructor of FakturaWierszCtrl class works properly
     */
    @Test
    public void fakturaCtrlCalled(){
        assertNotNull(fakturaWierszCtrl);
        assertNotNull(fakturaWierszCtrl1);
    }

    /**
     * Tests if the method getLiczbaFaktur() works properly
     */
    @Test
    public void testGetLiczbaFaktur() {
        assertEquals(107,fakturaWierszCtrl.getLiczbaWierszyFaktur());
        assertEquals(107,fakturaWierszCtrl1.getLiczbaWierszyFaktur());
    }

    /**
     * Tests if the method getWartoscFaktur() works properly
     */
    @Test
    public void testGetWartoscFaktur(){
        assertEquals("1432778.41", String.valueOf(fakturaWierszCtrl.getWartoscWierszyFaktur()));
        assertEquals("1432778.41", String.valueOf(fakturaWierszCtrl1.getWartoscWierszyFaktur()));
    }
}
