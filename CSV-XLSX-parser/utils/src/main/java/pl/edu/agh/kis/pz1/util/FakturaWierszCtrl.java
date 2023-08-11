package pl.edu.agh.kis.pz1.util;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * Class defines FakturaWiersz
 * @author tomaszmakowski
 */
@XmlRootElement(name="FakturaWierszCtrl")
public class FakturaWierszCtrl {
    private int liczbaWierszyFaktur;
    private BigDecimal wartoscWierszyFaktur = new BigDecimal(0);


    public FakturaWierszCtrl(){
        super();
    }

    /**
     * Constructor of FakturaWierszCtrl Class
     * @param i defines file type
     *          0 - XLSX
     *          1 - CSV
     * liczbaWierszyFaktur number of FakturaWiersz in FakturaWierszCtrl
     * wartoscWierszyFaktur value of FakturaWiersz in FakturaWierszCtrl
     */
    public FakturaWierszCtrl(int i, String source) {
        if(i == 0){
            ReaderXLSX readerXLSX = new ReaderXLSX();
            readerXLSX.parserOfXLSX(source);
            for (FakturaWiersz fakturaWiersz : readerXLSX.getFakturaWierszList()) {
                liczbaWierszyFaktur += 1;
                wartoscWierszyFaktur = wartoscWierszyFaktur.add(new BigDecimal(String.valueOf(fakturaWiersz.getP11())));
            }
        }
        else if(i == 1){
            ReaderCSV readerCSV = new ReaderCSV();
            readerCSV.parserOfCSV(source);
            for (FakturaWiersz fakturaWiersz : readerCSV.getFakturaWierszList()){
                liczbaWierszyFaktur += 1;
                wartoscWierszyFaktur = wartoscWierszyFaktur.add(new BigDecimal(String.valueOf(fakturaWiersz.getP11())));
            }
        }


    }
    @XmlElement
    public int getLiczbaWierszyFaktur() {
        return liczbaWierszyFaktur;
    }
    @XmlElement
    public BigDecimal getWartoscWierszyFaktur() {
        return wartoscWierszyFaktur;
    }
}
