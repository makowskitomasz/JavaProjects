package pl.edu.agh.kis.pz1.util;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a list of FakturaWiersz
 * * @author tomaszmakowski
 *
 */
@XmlRootElement(name="FakturaWiersze")
public class ListFakturaWiersz {
    private List<FakturaWiersz> fakturaWierszList = new ArrayList<>();

    public ListFakturaWiersz(){
        super();
    }

    /**
     * Constructor of ListFakturaWiersz
     * @param i defines the file type
     *          0 - XLSX
     *          1 - CSV
     */
    public ListFakturaWiersz(int i, String source){
        if(i == 0){
            ReaderXLSX readerXLSX = new ReaderXLSX();
            readerXLSX.parserOfXLSX(source);
            fakturaWierszList.addAll(readerXLSX.getFakturaWierszList());
        }
        else if(i == 1){
            ReaderCSV readerCSV = new ReaderCSV();
            readerCSV.parserOfCSV(source);
            fakturaWierszList.addAll(readerCSV.getFakturaWierszList());
        }

    }

    @XmlElement(name = "FakturaWiersz")
    public List<FakturaWiersz> getfakturaWierszList() {
        return fakturaWierszList;
    }

    public void setfakturaWierszList(List<FakturaWiersz> fakturaWierszList) {
        this.fakturaWierszList = fakturaWierszList;
    }
}
