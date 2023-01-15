package day08_HandlingWindows;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandles {

    // ● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void teardown(){
        driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {

        // ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.

             String expectedSayfaYazisi= "Opening a new window" ;
             String actualSayfaYazisi= driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expectedSayfaYazisi,actualSayfaYazisi);
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String expectedSayfaTitle="The Internet";
        String actualsayfaTitle = driver.getTitle();
        String ilkSayfaHandleDegeri =driver.getWindowHandle();

        Assert.assertEquals(expectedSayfaTitle,actualsayfaTitle);

        //● Click Here butonuna basın.

        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(3000);
        /*
        Kontrolsuz acilan tab'a gecis yapmak icin

        1- ilk sayfada iken WHD alip kaydedin

        2-2. sayfa acildiktan sonra getWindowHandles() kullanarak
        acik olan tum sayfalarin WH degerini bir Set olarak kaydedin

        3- su anda elimizde 2 elemntli bir Set var. element'lerden bir tanesi 1.sayfanin WHD olur
        veya setten ilk WHD remove ederiz, elimizde kalan aradigimiz olur(ama sette index olmadiginda ietartor kullanmak gerekli )
        veya, karsilastirma yapariz, ilkWHD esit olmayan ".WH degeridir

        4-bu sekilde 2. sayfanin WHD elde edildikten sonea,
        WHD'leri kullanilarak sayfalar arasinda gecis yapilabilir
          */

        Set<String> tumWHDegerlerSeti =driver.getWindowHandles();
        String ikinciSayfaWHD="";

        for (String eachWhd: tumWHDegerlerSeti
             ) {
            if (!eachWhd.equals(ilkSayfaHandleDegeri)) {
                ikinciSayfaWHD=eachWhd;
            }

        }
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciSayfaWHD);
        String expectedNewSayfaTitle="New Window";
        String actualNewSayfaTitle = driver.getTitle();

        Assert.assertEquals(expectedNewSayfaTitle,actualNewSayfaTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.

         String expectedYeniSayfaYazi = "New Window";
         String actualYeniSayfaYazi = driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expectedYeniSayfaYazi,actualYeniSayfaYazi);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın

        driver.switchTo().window(ilkSayfaHandleDegeri);

        expectedSayfaTitle="The Internet";
        actualsayfaTitle = driver.getTitle();
        ilkSayfaHandleDegeri =driver.getWindowHandle();

        Assert.assertEquals(expectedSayfaTitle,actualsayfaTitle);

        Thread.sleep(3000);


    }
}
