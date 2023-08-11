import org.junit.Test;
import pl.edu.agh.kis.pz1.util.Bill;
import pl.edu.agh.kis.pz1.util.ReaderCSV;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Test for the class Bill
 */
public class BillTest {
    ReaderCSV readerCSV = new ReaderCSV();
    private List<Bill> listBill = new ArrayList<>();


    /**
     * Test for the construction of Bill and the
     * bill object being called
     */
    @Test
    public void shouldCreateBillObject(){
        Bill bill = new Bill();
        assertNotNull("Bill object called.", bill);
    }

    /**
     * Test for the getter methods in the Bill class
     */
    @Test
    public void rightGetters(){
        readerCSV.parserOfCSV("faktury-sprzedazowe-test-2023.csv");
        listBill.addAll(readerCSV.getBills());
        assertEquals("PLN", listBill.get(0).getKodWaluty());
        assertEquals("2020-10-09",listBill.get(0).getP1());
        assertEquals("3-09/10/2020",listBill.get(0).getP2A());
        assertEquals("Firma5 SP. Z O.O.",listBill.get(0).getP3A());
        assertEquals("UL. FELIKSA RADWAŃSKIEGO 15/1, 30-065 KRAKÓW",listBill.get(0).getP3B());
        assertEquals("UL. FELIKSA RADWAŃSKIEGO 15/1, 30-065 KRAKÓW",listBill.get(0).getP3B());
        assertEquals("634-27-26-447",listBill.get(0).getP5B());
        assertEquals("2020-10-09",listBill.get(0).getP6());
        assertEquals("1", String.valueOf(listBill.get(0).getP131()));
        assertEquals("690.00" ,String.valueOf(listBill.get(0).getP141()));
        assertEquals("3690.00",String.valueOf(listBill.get(0).getP15()));
    }

    @Test
    public void rightGettersPart2(){
        readerCSV.parserOfCSV("faktury-sprzedazowe-test-2023.csv");
        listBill.addAll(readerCSV.getBills());
        assertEquals(false ,listBill.get(0).getP16());
        assertEquals(false,listBill.get(0).getP17());
        assertEquals(false,listBill.get(0).getP18());
        assertEquals(false,listBill.get(0).getP18A());
        assertEquals(false,listBill.get(0).getP19());
        assertEquals(false,listBill.get(0).getP20());
        assertEquals(false,listBill.get(0).getP21());
        assertEquals(false, listBill.get(0).getP22());
        assertEquals(false,listBill.get(0).getP23());
        assertEquals(false,listBill.get(0).getP106E2());
        assertEquals(false,listBill.get(0).getP106E3());
        assertEquals("\"CORE LOGIC\" SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ",listBill.get(0).getP3C());
        assertEquals("ul. Feliksa Radwańskiego 15/1, 30-065 Kraków",listBill.get(0).getP3D());
        assertEquals("PL",listBill.get(0).getP4A());
        assertEquals("6762484560",listBill.get(0).getP4B());
        assertEquals("VAT",listBill.get(0).getRodzajFaktury());
    }
}
