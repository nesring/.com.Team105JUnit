package day12_webtables_excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {

    @Test
    public void test01() {

     // 1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

    // 2. Headers da bulunan basliklari yazdirin

        WebElement headerElementi = driver.findElement(By.xpath("//div[@class='rt-thead -header']"));

        System.out.println("basliktaki bilgiler: " + headerElementi.getText());

    // 3. 3.sutunun basligini yazdirin

        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        System.out.println("3.sutunun basigi : " + basliklarListesi.get(2).getText());

        System.out.println("=========== benim cozumum ");
        WebElement baslikuc = driver.findElement(By.xpath("(//div[@class='rt-th rt-resizable-header -cursor-pointer'])[3]"));
        System.out.println(baslikuc.getText());

    // 4. Tablodaki tum datalari yazdirin

        WebElement bodyElementi = driver.findElement(By.xpath("//div[@class='rt-tbody']"));
        System.out.println("body: " +bodyElementi.getText());

    // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin

        List<WebElement> datalarListesi =driver.findElements(By.xpath("//div[@class='rt-td']"));

        int siraNo=1;

        for (WebElement eachElement: datalarListesi
             ) {

            if (!(eachElement.getText().equals("") || eachElement.getText().equals(" ")) ) {
                System.out.println(siraNo + "." +" "+ eachElement.getText());
                siraNo++;
            }

        }

    // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleriListesi= driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("tablodaki satir sayisi : " + satirElementleriListesi.size());

    // 7. Tablodaki sutun sayisini yazdirin
        // yukarda basliklar listesi olusturmustuk, onun size alalim
        System.out.println("Sutun Sayisi : "+ basliklarListesi.size());

    // 8. Tablodaki 3.kolonu yazdirin

        List<WebElement> ucuncuSutunDatalarListesi = driver.findElements(By.xpath("((//div[@class='rt-tr-group']))//div[1]/div[3]"));
                
        for (WebElement eachElement: ucuncuSutunDatalarListesi
        ) {
            if (!(eachElement.getText().equals("") || eachElement.getText().equals(" "))){
                System.out.println( eachElement.getText() );
            }
        }


        // 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
        // index'i saydiralik, Kierra'yi bulunca, index'inin 4 fazla olani yazdiralim     

        for (int i = 0; i < datalarListesi.size(); i++) {
            if (datalarListesi.get(i).getText().equals("Kierra")) {
                System.out.println("istenen kisinin maasi : " + datalarListesi.get(i+4).getText());
            }
            
        }
        // 10. Page sayfasinda bir method olusturun,
        // Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin





    }
}
