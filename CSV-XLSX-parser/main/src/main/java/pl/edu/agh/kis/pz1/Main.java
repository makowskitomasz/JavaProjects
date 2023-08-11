package pl.edu.agh.kis.pz1;

import pl.edu.agh.kis.pz1.util.WriterXML;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author tomaszmakowski
 * @version 1.0
 *
 */
public class Main {

    /**
     * @param args
     * main method of program that chooses the type of reader and writes a xml file
     */
    public static void main(String[] args){
        int fileType;
        String fileName = args[1];
        if(args[0].endsWith(".xlsx")) fileType = 0;
        else fileType = 1;
        WriterXML writerXML = new WriterXML();
        writerXML.writeXML(fileType, fileName, args[0]);
    }
}
