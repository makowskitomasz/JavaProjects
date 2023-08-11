package pl.edu.agh.kis.pz1.util;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;


/**
 * @author tomaszmakowski
 * Class defines FakturaCtrl rows
 */
@XmlRootElement(name="FakturaCtrl")
public class FakturaCtrl {
    private int liczbaFaktur;
    private BigDecimal wartoscFaktur = new BigDecimal(0);

    public FakturaCtrl(){
        super();
    }

    /**
     * Constructor of FakturaCtrl Class
     * @param i that defines type of file
     *          0 - XLSX
     *          1 - CSV
     * counts number of bills and their value
     */
    public FakturaCtrl(int i, String source){
        if(i == 0){
            ReaderXLSX readerXLSX = new ReaderXLSX();
            readerXLSX.parserOfXLSX(source);
            for(Bill bill : readerXLSX.getBills()){
                liczbaFaktur += 1;
                wartoscFaktur = wartoscFaktur.add(new BigDecimal(String.valueOf(bill.getP15())));
            }
        }
        else if(i == 1){
            ReaderCSV readerCSV = new ReaderCSV();
            readerCSV.parserOfCSV(source);
            for(Bill bill : readerCSV.getBills()){
                liczbaFaktur += 1;
                wartoscFaktur = wartoscFaktur.add(new BigDecimal(String.valueOf(bill.getP15())));
            }
        }
    }

    @XmlElement
    public int getLiczbaFaktur() {
        return liczbaFaktur;
    }

    @XmlElement
    public BigDecimal getWartoscFaktur() {
        return wartoscFaktur;
    }
}
