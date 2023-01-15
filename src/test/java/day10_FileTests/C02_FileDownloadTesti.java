package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTesti extends TestBase {

    @Test
    public void test01(){

        // 1- https://the-internet.herokuapp.com/download adresine gidelim

        driver.get("https://the-internet.herokuapp.com/download");

        // 2- 1.png // Facebookd.png dosyasini indirelim

        driver.findElement(By.xpath("//a[text()='1.png']")).click();

        ReusableMethods.bekle(5);

        // 3- dosyanin basariyla indirilip indirilmedigini test edelim

        // Test icin oncelikle dosyanin indirildiginde dosyaYolu
        // ne olacak bunu olusturmaliyiz

        String dosyaYolu=System.getProperty("user.home") + "\\Downloads\\1.png";
        // bir dosyanin bilgissayarinizda var oldugunu (exist) test
        // etmek icin JAva'daki Files class'indan yardim alacagiz

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }


    @Test
    public void test02(){

        // Masaustunde MerhabaJava.docx dosyasi oldugunu test edin

        // dinamik dosya yolu olusturalim

        String dosyaYolu = System.getProperty("user.home") + "/OneDrive/Desktop/MerhabaJava.docx";


        // Assert edelim

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        ReusableMethods.bekle(5);


    }

}
