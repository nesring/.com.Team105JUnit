package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {

    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {

        }
    }

    public static void tumSayfaScreenshotCek(WebDriver driver) {

        // 1-TakesScreenshot objesi olustur
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2-resmi nihai olarak kaydedcegimiz dosyayi olustur
        // her resim cektiginde ust uste kaydetmemsi icin,
        // resim dosya yoluna tarih ve saat iceren bir ek yapalim

        LocalDateTime ldt= LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih =ldt.format(dtf);
        String dosyaYolu = "target/ekranResimleri/tumEkranSs.jpeg";


        File tumSayfaScreenshot= new File("target/ekranResimleri/tumEkranSS"+tarih+".jpeg");

        // 3-tss objesi kullanarak ekran goruntusu alip gecici dosyaya kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        //4-gecici dosyayi ana dosyay kopyalayin


        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);
        } catch (IOException e) {

        }

        // burada dosya yolu icin exception firlatmisti ama merhodu kullandigimiz her seferinde orda da exception firlatmamiz gerekecek
        // bunu onlemek icin buradaki exception'i silip try catch yapiyoruz(4.madde icin)


    }

    public static void elementSSCek(WebElement element) {

        //1-ss alacagimiz elementi locat et
        // 2-kaydedecigimiz dosyayi olustur

        LocalDateTime ldt= LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih =ldt.format(dtf);
        String dosyaYolu = "target/ekranResimleri/istenenElementSS"+tarih+".jpeg";

        File elementSS = new File(dosyaYolu);

        // 3-gecici dosyayi olusturup element uzerinden ss yapalim

        File gecici = element.getScreenshotAs(OutputType.FILE);

        // gecici dosyayi hedef dosyaya kopyala

        try {
            FileUtils.copyFile(gecici,elementSS);
        } catch (IOException e) {

        }


    }



}


// exception firlatirsak kullandigimiz her yerde exception gelecek
// onun yerine surround try catch daha kullanisli

