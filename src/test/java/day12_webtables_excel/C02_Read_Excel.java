package day12_webtables_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_Read_Excel {

    @Test
    public void test01() throws IOException {

        // dosya yolunu olusturalim

    String dosyaYolu= "src/test/java/day12_webtables_excel/ulkeler.xlsx";
// FileInputstream objesi olusturup, parametre olarak dosya yolunu yazalim

 FileInputStream fis= new FileInputStream(dosyaYolu);

 // kod alanimiyzda excel'in bir kopyasini olusturup,
 // tum bilgilri oraya koyalayacagiz

   Workbook workbook = WorkbookFactory.create(fis);

   // workbook icersinde birden fazla sayfa olabilir
    // istedigimiz sayfaya gidelim

   Sheet sheet = workbook.getSheet("Sayfa1");

   // Angola yazdirmak istedigimiz icin 5. satra gidelim

        Row row = sheet.getRow(5);
   // 5. satirda 2. indekteki datayi alalim

        Cell cell =row.getCell(2);

        System.out.println(cell);



    }
}
