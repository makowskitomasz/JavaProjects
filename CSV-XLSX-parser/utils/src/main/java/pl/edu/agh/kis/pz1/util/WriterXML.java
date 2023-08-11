package pl.edu.agh.kis.pz1.util;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.io.File;

/**
 * @author tomaszmakowski
 * Class defines WriterXML
 * It is responsible for writing XML file
 */
public class WriterXML {

    /**
     * Method writes XML file
     * @param i - type of the file
     * @param fileName name of the file
     * Using JAXBContext and Marshaller
     */
    public void writeXML(int i, String fileName, String source) {
        try{
            File myFile = new File(fileName);
            JAXBContext context = JAXBContext.newInstance(JPK.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(new JPK(i, source), myFile);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
