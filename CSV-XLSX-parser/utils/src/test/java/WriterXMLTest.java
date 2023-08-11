import jakarta.xml.bind.JAXBException;
import org.junit.Test;
import pl.edu.agh.kis.pz1.util.JPK;
import pl.edu.agh.kis.pz1.util.WriterXML;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.delete;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * A class that tests the WriterXML class
 */
public class WriterXMLTest {
    WriterXML writerXML = new WriterXML();

    /**
     * Test for the construction of WriterXML
     */
    @Test
    public void writerObjectCalled(){
        assertNotNull(writerXML);
    }

    /**
     * Test for the writeXML method
     */
    @Test
    public void writeXMLWorksCorrectly() throws IOException, JAXBException {
        File myFile = new File("test.xml");
        JAXBContext context = JAXBContext.newInstance(JPK.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(new JPK(1, "faktury-sprzedazowe-test-2023.csv"), myFile);
        assertTrue(myFile.exists());
        delete(myFile);
    }
}
