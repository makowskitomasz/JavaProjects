package pl.edu.agh.kis.pz1.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * A parser of XLSX files
 * @author tomaszmakowski
 */
public class ReaderXLSX {

    private List<Bill> bills = new ArrayList<>();
    private List<FakturaWiersz> fakturaWierszList = new ArrayList<>();

    public List<Bill> getBills() {
        return bills;
    }

    public List<FakturaWiersz> getFakturaWierszList() {
        return fakturaWierszList;
    }

    /**
     * A method which reads xlsx file and creates list of bills and list of fakturaWiersz
     */
    public void parserOfXLSX(String source){
        String p3A;
        String p3B;
        String p5B;
        String p1;
        String p6;
        String p2A;
        BigDecimal p131;
        BigDecimal p141;
        BigDecimal p15;
        String p2B;
        String p12;
        BigDecimal p8B;
        BigDecimal p9A;
        BigDecimal p11;
        BigDecimal p9B;
        int counter = 0;
        try (FileInputStream file = new FileInputStream(source)) {
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                boolean contains = false;
                if(counter == 0){
                    counter += 1;
                    continue;
                }
                p3A = String.valueOf(row.getCell(0));
                p3B = String.valueOf(row.getCell(1));
                p5B = String.valueOf(row.getCell(2));
                p1 = String.valueOf(row.getCell(3));
                p6 = String.valueOf(row.getCell(4));
                p2A = String.valueOf(row.getCell(5));
                p131 = BigDecimal.valueOf(row.getCell(7).getNumericCellValue());
                p141 = BigDecimal.valueOf(row.getCell(10).getNumericCellValue());
                p15 = BigDecimal.valueOf(row.getCell(14).getNumericCellValue());
                p2B = String.valueOf(row.getCell(5));
                p12 = String.valueOf(row.getCell(9));
                p8B = BigDecimal.valueOf(row.getCell(7).getNumericCellValue());
                p9A = BigDecimal.valueOf(row.getCell(8).getNumericCellValue());
                p11 = BigDecimal.valueOf(row.getCell(11).getNumericCellValue());
                p9B = BigDecimal.valueOf(row.getCell(12).getNumericCellValue());
                fakturaWierszList.add(new FakturaWiersz(p2B, p12, p8B, p9A, p9B, p11));
                for(Bill bill : bills){
                    if(bill.p2A.equals(p2A))
                    {
                        contains = true;
                        break;
                    }
                }
                if(!contains){
                    bills.add(new Bill(p3A, p3B, p5B, p1, p6, p2A, p131, p141, p15));
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

