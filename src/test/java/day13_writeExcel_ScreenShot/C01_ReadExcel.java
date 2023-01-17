package day13_writeExcel_ScreenShot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        // excell dosyalari bilgisayarimizda oldugu icin (webDriver kullanamiyoruz)
        // java FileInputStream class'i yardimiyla ulasacagiz

        // ilk adim dosya yolu'nu almak, projenin icindeyse dosya kolay, copy path diyerek buluyoruz
        // bilgisayarda, masaustu veya baska bir clasorde ise, System.getProperty ile once user.home (her bigisayarda degisen kisim) sonra ayni olan dosya di vs olan kismi alarak

        String dosyaYolu = "src/test/java/day12_webtables_excel/ulkeler.xlsx";

        // 2. adim fis objesi olusturup, dosya yolunu paramerte olarak veriyor
        // ve bu adresteki dosyayi oku demis oluyoruz
        // bulamama veya okuyamam ihtimaline karsilik exception firlatmak gerekiyor

        FileInputStream fis = new FileInputStream(dosyaYolu);

        // java yardimiyla dosyaya ulastik ve okuduk
        // dosyanin bir kopyasini kodlarimizin icinde olusturuyoruz, bir obje icinde
        // burda d acreat ekomutu icin exception yapmak gerek

        Workbook workbook = WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(1));
// sayfa 1, in 3. indexli satirinin, 1 indexli data si ni yazdiriyoruz

        // satir ve sutun bilgisini parametre olarak alip, o hucredeki bilgiyi
        // yazdiran bir method olusturun

        dataYazdir(25,2); // Brunei
        dataYazdir(14,3); // Dakka



    }

    private void dataYazdir(int satir, int sutun) throws IOException {
        // workbook ayarlarini burada yapmadik, ya workbook'u buraya
        //yollayacagiz, ya ayarlari yeniden yapacagiz

        String dosyaYolu = "src/test/java/day12_webtables_excel/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sayfa1").getRow(satir).getCell(sutun));



    }

}
