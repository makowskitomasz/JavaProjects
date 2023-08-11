import org.junit.Test;
import pl.edu.agh.kis.pz1.util.FakturaCtrl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * A class that tests the FakturaCtrl class
 */
public class FakturaCtrlTest {
    FakturaCtrl fakturaCtrl = new FakturaCtrl(0, "faktury-sprzedazowe-test-2023.xlsx");
    FakturaCtrl fakturaCtrl1 = new FakturaCtrl(1, "faktury-sprzedazowe-test-2023.csv");

    /**
     * Test of non arg constructor
     */
    @Test
    public void nonArgConstructorCalled(){
        FakturaCtrl fakturaCtrl2 = new FakturaCtrl();
        assertNotNull(fakturaCtrl2);
    }
    /**
     * Tests if the constructor of FakturaCtrl class works properly
     */
    @Test
    public void fakturaCtrlCalled(){
        assertNotNull(fakturaCtrl);
        assertNotNull(fakturaCtrl1);
    }

    /**
     * Tests if the method getLiczbaFaktur() works properly
     */
    @Test
    public void testGetLiczbaFaktur() {
        assertEquals(44,fakturaCtrl.getLiczbaFaktur());
        assertEquals(44,fakturaCtrl1.getLiczbaFaktur());
    }

    /**
     * Tests if the method getWartoscFaktur() works properly
     */
    @Test
    public void testGetWartoscFaktur(){
        assertEquals("1762317.41", String.valueOf(fakturaCtrl.getWartoscFaktur()));
        assertEquals("1762317.41", String.valueOf(fakturaCtrl1.getWartoscFaktur()));
    }
}
