package pl.edu.agh.kis.pz1.util;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


/**
 * Class that represents the information about the JPK_file
 * @author tomaszmakowski
 */
@XmlRootElement(name="Naglowek")
public class Naglowek {

    public Naglowek() {
        super();
    }
    @XmlElement
    public String getKodFormularza() {
        return "JPK_FA";
    }
    @XmlElement
    public String getWariantFormularza() {
        return "3";
    }
    @XmlElement
    public String getCelZlozenia() {
        return "1";
    }
    @XmlElement
    public String getDataWytworzeniaJPK() {
        return "2021-10-28T16:30:54.533";
    }
    @XmlElement
    public String getDataOd() {
        return "2020-10-01";
    }
    @XmlElement
    public String getDataDo() {
        return "2020-12-31";
    }
    @XmlElement
    public String getKodUrzedu() {
        return "1208";
    }
}
