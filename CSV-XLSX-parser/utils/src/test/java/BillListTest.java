import org.junit.Test;
import pl.edu.agh.kis.pz1.util.Bill;
import pl.edu.agh.kis.pz1.util.BillList;

import static org.junit.Assert.*;

/**
 * Test for the BillList class
 */
public class BillListTest {
    BillList billList = new BillList(0, "faktury-sprzedazowe-test-2023.xlsx");
    BillList billList1 = new BillList(1, "faktury-sprzedazowe-test-2023.csv");

    /**
     * Test for the BillList no arg constructor
     */
    @Test
    public void testNoArgConstructor(){
        BillList billList = new BillList();
        assertNotNull(billList);
    }
    /**
     * Test for the construction of BillList
     */
    @Test
    public void billListCalled(){
        assertNotNull(billList);
        assertNotNull(billList1);
    }

    /**
     * Test for the method addBill() it checks if the number of bills increases if the bill is added
     */
    @Test
    public void testGetBillList() {
        assertEquals(44, billList.getBillList().size());
        assertEquals(44, billList1.getBillList().size());
    }

    /**
     * Test for the method getBillList() it checks if the number of bills is correct
     */
    @Test
    public void testSetBillList() {
        billList.setBillList(null);
        assertNull(billList.getBillList());
        billList1.setBillList(null);
        assertNull(billList1.getBillList());
    }


}
