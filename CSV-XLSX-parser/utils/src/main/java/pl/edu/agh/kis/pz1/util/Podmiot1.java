package pl.edu.agh.kis.pz1.util;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Class that stores date about podmiot1
 * @author tomaszmakowski
 */
@XmlRootElement(name = "tns:Podmiot1")
public class Podmiot1 {
    private static final String NIP = "6762484560";
    private static final String PELNA_NAZWA = "\"CORE LOGIC\" SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ";

    public Podmiot1() {
        super();
    }
    @XmlElement
    public String getNIP() {
        return NIP;
    }
    @XmlElement
    public String getPelnaNazwa() {
        return PELNA_NAZWA;
    }
}
