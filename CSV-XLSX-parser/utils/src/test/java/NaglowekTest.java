import org.junit.Test;
import pl.edu.agh.kis.pz1.util.Naglowek;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * A class that tests the Naglowek class
 */
public class NaglowekTest {

    /**
     * Test for the construction of Naglowek
     */
    @Test
    public void naglowekTestCalled(){
        Naglowek naglowek = new Naglowek();
        assertNotNull(naglowek);
    }


    /**
     * Test for getters of Naglowek class
     */
    @Test
    public void rightGetters(){
        Naglowek naglowek = new Naglowek();
        assertEquals("JPK_FA", naglowek.getKodFormularza());
        assertEquals("3", naglowek.getWariantFormularza());
        assertEquals("1", naglowek.getCelZlozenia());
        assertEquals("2021-10-28T16:30:54.533", naglowek.getDataWytworzeniaJPK());
        assertEquals("2020-10-01", naglowek.getDataOd());
        assertEquals("2020-12-31", naglowek.getDataDo());
        assertEquals("1208", naglowek.getKodUrzedu());
    }
}
