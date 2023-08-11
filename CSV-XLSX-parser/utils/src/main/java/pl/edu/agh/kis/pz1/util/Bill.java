package pl.edu.agh.kis.pz1.util;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

/**
 * @author tomaszmakowski
 * class that defines the bill
 */

@XmlType(propOrder = {"kodWaluty", "p1", "p2A", "p3A", "p3B", "p3C", "p3D", "p4A", "p4B", "p5B", "p6", "p131", "p141",
"p15", "p16", "p17", "p18", "p18A", "p19", "p20", "p21", "p22", "p23", "p106E2", "p106E3", "rodzajFaktury"})
@XmlRootElement(name="Faktury")
public class Bill {
    String kodWaluty = "PLN";
    String p1;
    String p2A;
    String p3A;
    String p3B;
    String p5B;
    String p6;
    BigDecimal p131;
    BigDecimal p141;
    BigDecimal p15;
    Boolean p16 = false;
    Boolean p17 = false;
    Boolean p18 = false;
    Boolean p18A = false;
    Boolean p19 = false;
    Boolean p20 = false;
    Boolean p21 = false;
    Boolean p22 = false;
    Boolean p23 = false;
    Boolean p106E2 = false;
    Boolean p106E3 = false;

    String p3C = "\"CORE LOGIC\" SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ";
    String p3D = "ul. Feliksa Radwańskiego 15/1, 30-065 Kraków";
    String p4A = "PL";
    String p4B = "6762484560";
    String rodzajFaktury = "VAT";

    public Bill(){
        super();
    }

    /**
     * Constructor that uses the data from the CSV file
     * @param p3A - name of the company
     * @param p3B - address of the company
     * @param p5B - NIP of the company
     * @param p1  - number of the bill
     * @param p6 - date of the bill
     * @param p2A - date of the bill
     * @param p131 - netto value of the bill
     * @param p141 - brutto value of the bill
     * @param p15 - VAT value of the bill
     */

    Bill(String p3A, String p3B, String p5B, String p1, String p6, String p2A, BigDecimal p131, BigDecimal p141, BigDecimal p15){
        this.p1 = p1;
        this.p3A = p3A;
        this.p2A = p2A;
        this.p3B = p3B;
        this.p5B = p5B;
        this.p6 = p6;
        this.p131 = p131;
        this.p141 = p141;
        this.p15 = p15;
    }

    @XmlElement(name="KodWaluty")
    public String getKodWaluty() {
        return kodWaluty;
    }

    @XmlElement(name="P_1")
    public String getP1() {
        return p1;
    }

    @XmlElement(name="P_2A")
    public String getP2A() {
        return p2A;
    }
    @XmlElement(name="P_3A")
    public String getP3A() {
        return p3A;
    }
    @XmlElement(name="P_3B")
    public String getP3B() {
        return p3B;
    }
    @XmlElement (name="P_5B")
    public String getP5B() {
        return p5B;
    }
    @XmlElement(name="P_6")
    public String getP6() {
        return p6;
    }
    @XmlElement(name="P_13_1")
    public BigDecimal getP131() {
        return p131;
    }
    @XmlElement(name="P_14_1")
    public BigDecimal getP141() {
        return p141;
    }
    @XmlElement(name="P_15")
    public BigDecimal getP15() {
        return p15;
    }
    @XmlElement(name="P_16")
    public Boolean getP16() {
        return p16;
    }
    @XmlElement(name="P_17")
    public Boolean getP17() {
        return p17;
    }
    @XmlElement(name="P_18")
    public Boolean getP18() {
        return p18;
    }
    @XmlElement(name="P_18A")
    public Boolean getP18A() {
        return p18A;
    }
    @XmlElement(name="P_19")
    public Boolean getP19() {
        return p19;
    }
    @XmlElement(name="P_20")
    public Boolean getP20() {
        return p20;
    }
    @XmlElement(name="P_21")
    public Boolean getP21() {
        return p21;
    }
    @XmlElement(name="P_22")
    public Boolean getP22() {
        return p22;
    }
    @XmlElement(name="P_23")
    public Boolean getP23() {
        return p23;
    }
    @XmlElement(name="P_106E_2")
    public Boolean getP106E2() {
        return p106E2;
    }
    @XmlElement(name="P_106E_3")
    public Boolean getP106E3() {
        return p106E3;
    }
    @XmlElement(name="P_3C")
    public String getP3C() {
        return p3C;
    }
    @XmlElement(name="P_3D")
    public String getP3D() {
        return p3D;
    }
    @XmlElement(name="P_4A")
    public String getP4A() {
        return p4A;
    }
    @XmlElement(name="P_4B")
    public String getP4B() {
        return p4B;
    }
    @XmlElement(name="RodzajFaktury")
    public String getRodzajFaktury() {
        return rodzajFaktury;
    }
}
