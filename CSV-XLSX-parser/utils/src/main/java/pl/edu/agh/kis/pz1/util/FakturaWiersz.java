package pl.edu.agh.kis.pz1.util;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * Class defines FakturaWiersz
 * @author tomaszmakowski
 */
@XmlType(propOrder = {"p2B", "p7", "p8A", "p8B", "p9A", "p9B", "p11", "p12"})
@XmlRootElement(name="FakturaWiersz")
public class FakturaWiersz {

    private String p2B;
    private String p12;
    private BigDecimal p9B;
    private static final String P7 = "Sprzedaż usług krajowych";
    private static final String P8A = "szt";
    private BigDecimal p8B;
    private BigDecimal p9A;
    private BigDecimal p11;

    public FakturaWiersz(){
        super();
    }


    /**
     * Constructor of FakturaWiersz Class
     * @param p2B - name of the product
     * @param p12 - tax rate
     * @param p8B - quantity of the product
     * @param p9A - price of the product
     * @param p9B - unit of the product
     * @param p11 - tax amount
     */
    FakturaWiersz(String p2B, String p12, BigDecimal p8B, BigDecimal p9A, BigDecimal p9B, BigDecimal p11){
        this.p2B = p2B;
        this.p12 = p12;
        this.p8B = p8B;
        this.p9A = p9A;
        this.p9B = p9B;
        this.p11 = p11;
    }
    @XmlElement(name = "P_2B")
    public String getP2B() {
        return p2B;
    }
    @XmlElement(name = "P_12")
    public String getP12() {
        return p12;
    }
    @XmlElement(name = "P_7")
    public String getP7() {
        return P7;
    }
    @XmlElement(name = "P_8A")
    public String getP8A() {
        return P8A;
    }
    @XmlElement(name = "P_8B")
    public BigDecimal getP8B() {
        return p8B;
    }
    @XmlElement(name = "P_9A")
    public BigDecimal getP9A() {
        return p9A;
    }
    @XmlElement(name = "P_9B")
    public BigDecimal getP9B() {
        return p9B;
    }
    @XmlElement(name = "P_11")
    public BigDecimal getP11() {
        return p11;
    }
}
