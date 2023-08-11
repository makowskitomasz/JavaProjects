package pl.edu.agh.kis.pz1.util;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * @author tomaszmakowski
 * Class defines JPK
 * The head class which calls other constructors
 */

@XmlType(propOrder = {"naglowek", "podmiot1", "billList", "fakturaCtrl", "listFakturaWiersz", "fakturaWierszCtrl"})
@XmlRootElement(name = "JPK")
public class JPK {

    private Naglowek naglowek;
    private Podmiot1 podmiot1;
    private BillList billList;
    private FakturaCtrl fakturaCtrl;
    private ListFakturaWiersz listFakturaWiersz;
    private FakturaWierszCtrl fakturaWierszCtrl;

    public JPK(){
        super();
    }

    /**
     * Constructor of JPK Class
     * @param i defines filetype
     *          0 - XLSX
     *          1 - CSV
     * Calls the constructors of other classes: Naglowek, Podmiot1, BillList, FakturaCtrl, ListFakturaWiersz, FakturaWierszCtrl
     */
    public JPK(int i, String source) {
            super();
            podmiot1 = new Podmiot1();
            billList = new BillList(i, source);
            fakturaCtrl = new FakturaCtrl(i, source);
            listFakturaWiersz = new ListFakturaWiersz(i, source);
            fakturaWierszCtrl = new FakturaWierszCtrl(i, source);
            naglowek = new Naglowek();
        }
    @XmlElement
    public Naglowek getNaglowek() {
        return naglowek;
    }

    @XmlElement
    public Podmiot1 getPodmiot1() {
        return podmiot1;
    }
    @XmlElement
    public BillList getBillList() {
        return billList;
    }
    @XmlElement
    public FakturaCtrl getFakturaCtrl() {
        return fakturaCtrl;
    }
    @XmlElement
    public ListFakturaWiersz getListFakturaWiersz() {
        return listFakturaWiersz;
    }
    @XmlElement
    public FakturaWierszCtrl getFakturaWierszCtrl() {
        return fakturaWierszCtrl;
    }
}
