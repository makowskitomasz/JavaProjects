package pl.edu.agh.kis.pz1.util;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


/**
 * Class that defines the list of all bills
 * @author tomaszmakowski
 */
@XmlRootElement(name="Faktury")
public class BillList {
    private List<Bill> listBill = new ArrayList<>();

    public BillList(){
        super();
    }

    /**
     * Constructor of BillList Class
     * @param i the number of the file type
     *         0 - XLSX
     *          1 - CSV
     */
    public BillList(int i, String source){
        if(i == 0){
            ReaderXLSX readerXLSX = new ReaderXLSX();
            readerXLSX.parserOfXLSX(source);
            listBill.addAll(readerXLSX.getBills());
        }
        else if(i == 1){
            ReaderCSV readerCSV = new ReaderCSV();
            readerCSV.parserOfCSV(source);
            listBill.addAll(readerCSV.getBills());
        }

    }

    @XmlElement(name = "Faktura")
    public List<Bill> getBillList() {
        return listBill;
    }

    public void setBillList(List<Bill> listBill) {
        this.listBill = listBill;
    }
}
