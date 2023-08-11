import org.junit.Test;
import pl.edu.agh.kis.pz1.util.FakturaWiersz;
import pl.edu.agh.kis.pz1.util.ReaderXLSX;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * A class that tests the FakturaWiersz class
 */
public class FakturaWierszTest {

    private final List<FakturaWiersz> fakturaWierszList = new ArrayList<FakturaWiersz>();

    ReaderXLSX readerXLSX = new ReaderXLSX();

    /**
     * Test for the construction of FakturaWiersz
     */
    @Test
    public void shouldCreateFakturaWierszObject(){
        FakturaWiersz fakturaWiersz = new FakturaWiersz();
        assertNotNull("FakturaWiersz object called.", fakturaWiersz);
    }

    /**
     * Test for the getter methods of FakturaWierszTest class
     */
    @Test
    public void rightGetters(){
        readerXLSX.parserOfXLSX("faktury-sprzedazowe-test-2023.xlsx");
        fakturaWierszList.addAll(readerXLSX.getFakturaWierszList());
        assertEquals("3-09/10/2020", readerXLSX.getFakturaWierszList().get(0).getP2B());
        assertEquals("23.0", String.valueOf(readerXLSX.getFakturaWierszList().get(0).getP12()));
        assertEquals("Sprzedaż usług krajowych", readerXLSX.getFakturaWierszList().get(0).getP7());
        assertEquals("szt", readerXLSX.getFakturaWierszList().get(0).getP8A());
        assertEquals("1.0", String.valueOf(readerXLSX.getFakturaWierszList().get(0).getP8B()));
        assertEquals("3000.0", String.valueOf(readerXLSX.getFakturaWierszList().get(0).getP9A()));
        assertEquals("3690.0", String.valueOf(readerXLSX.getFakturaWierszList().get(0).getP9B()));
        assertEquals("3000.0", String.valueOf(readerXLSX.getFakturaWierszList().get(0).getP11()));
    }
}
