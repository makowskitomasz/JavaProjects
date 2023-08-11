import org.junit.Test;
import pl.edu.agh.kis.pz1.util.ReaderXLSX;

import static org.junit.Assert.*;

/**
 * A class that tests the ReaderXLSX class
 */
public class ReaderXLSXTest {
    ReaderXLSX readerXLSX = new ReaderXLSX();

    /**
     * Test for the construction of ReaderXLSX
     */
    @Test
    public void readerObjectCalled(){
        assertNotNull(readerXLSX);
    }

    /**
     * Test for the parserOfXLSX method
     */
    @Test
    public void parserWorksCorrectly(){
        readerXLSX.parserOfXLSX("faktury-sprzedazowe-test-2023.xlsx");
        assertNotEquals(null, readerXLSX.getBills());
        assertNotEquals(null, readerXLSX.getFakturaWierszList());
        assertEquals(107 - 44, readerXLSX.getFakturaWierszList().size() - readerXLSX.getBills().size());
    }}
