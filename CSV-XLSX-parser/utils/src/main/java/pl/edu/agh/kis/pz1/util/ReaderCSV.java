package pl.edu.agh.kis.pz1.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * A parser of CSV files
 * @author tomaszmakowski
 */
public class ReaderCSV {

    private final List<Bill> bills = new ArrayList<>();
    private final List<FakturaWiersz> fakturaWierszList = new ArrayList<>();

    /**
     * A method which changes string in csv file to BigDecimal
     * @param value - string to be changed
     * @return BigDecimal
     */
    public BigDecimal stringToDecimal(String value){
        value = value.replace(",", ".");
        value = value.replace("zł", "");
        value = value.replace("\u00A0", "");
        value = value.trim();
        return new BigDecimal(value);
    }

    public List<Bill> getBills() {
        return bills;
    }

    public List<FakturaWiersz> getFakturaWierszList() {
        return fakturaWierszList;
    }

    /**
     * A method which reads csv file and creates list of bills and list of fakturaWiersz
     */
    public void parserOfCSV(String source){
        String p3A;
        BigDecimal p131;
        BigDecimal p141;
        BigDecimal p15;
        BigDecimal p8B;
        BigDecimal p9A;
        BigDecimal p11;
        String p3B;
        String p5B;
        String p1;
        String p6;
        String p2A;
        String p2B;
        String p12;
        BigDecimal p9B;
        try (Reader in = new FileReader(source)) {
            Iterable<CSVRecord> records = CSVFormat.TDF.parse(in);
            int counter = 0;
            for (CSVRecord csvRecord : records) {
                boolean alreadyExists = false;
                if(counter == 0){
                    counter += 1;
                    continue;
                }
                p3A = csvRecord.get(0);
                p3B = csvRecord.get(1);
                p5B = csvRecord.get(2);
                p1 = csvRecord.get(3);
                p6 = csvRecord.get(3);
                p2A = csvRecord.get(5);
                p131 = stringToDecimal(csvRecord.get(7));
                p141 = stringToDecimal(csvRecord.get(10));
                p15 = stringToDecimal(csvRecord.get(14));
                p2B = csvRecord.get(5);
                p12 = csvRecord.get(9);
                p8B = stringToDecimal(csvRecord.get(7));
                p9A = stringToDecimal(csvRecord.get(8));
                p11 = stringToDecimal(csvRecord.get(11));
                p9B = stringToDecimal(csvRecord.get(12));
                for(Bill bill : bills){
                    if(bill.p2A.equals(p2A)){
                        alreadyExists = true;
                        break;
                    }
                }
                if(!alreadyExists)  bills.add(new Bill(p3A, p3B, p5B, p1, p6, p2A, p131, p141, p15));
                fakturaWierszList.add(new FakturaWiersz(p2B, p12, p8B, p9A, p9B, p11));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}