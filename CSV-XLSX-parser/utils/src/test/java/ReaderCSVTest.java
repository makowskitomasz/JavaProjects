import org.junit.Test;
import pl.edu.agh.kis.pz1.util.ReaderCSV;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * A class that tests the ReaderCSV class
 */
public class ReaderCSVTest {
    ReaderCSV readerCSV = new ReaderCSV();

    /**
     * Test for the construction of ReaderCSV
     */
    @Test
    public void readerCSVCalled(){
        assertNotNull(readerCSV);
    }

    /**
     * Test for the method stringToDecimal() it checks if the conversion is correct
     */
    @Test
    public void stringToDecimalWorksCorrectly(){
        assertEquals(new BigDecimal("1000.0"), readerCSV.stringToDecimal("1000,0 zł"));
        assertEquals(new BigDecimal("15.00"), readerCSV.stringToDecimal("15,00 zł"));
    }

    /**
     * Test for the method parserOfCSV() it checks if the parser of CSV file works correctly
     */
    @Test
    public void parserWorksCorrectly(){
        readerCSV.parserOfCSV("faktury-sprzedazowe-test-2023.csv");
        assertNotEquals(null, readerCSV.getBills());
        assertNotEquals(null, readerCSV.getFakturaWierszList());
        assertEquals(107 - 44, readerCSV.getFakturaWierszList().size() - readerCSV.getBills().size());
    }
}
