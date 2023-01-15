package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_NewWindow {
    /*
    Selenium 4 ile windows konusunda yeni bir ozellik geldi

    Istersek kontrollu olarak driver icin yeni bir window veya tab olusturabiliriz
    bu durumda driver'imiz da otomati olarak yeni sayfaya gecmis olur

    Testin ilerleyen asamalarinda yeniden eski sayfalara donus gorevi varsa;
    o sayfada iken. o sayfanin Window Handle Degeri alinip kaydedilir
    ve o sayfaya gecmek istendiginde,
    driver.switchTo().window(IstenenSayfaninWindowHandleDegeri)
    kodu ile o sayfaya gecis yapilir

     */

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

        driver.get("https://www.amazon.com");

        Thread.sleep(3000);

        // testin ilerleyen asamalarinda yenidem amazon sayfasina donmek gerekiyorsa;
        // bu window'un window handle degerini alip kaydedtmeliyiz

        String ilkSayfaHandleDegeri = driver.getWindowHandle();

        // yeni bir tabda wisequareter.com a gidin ve gittiginizi test edin

        // ayni tabda gitmesi icin
      //  driver.get("https://www.wisequarter.com"); once amazon sonra ayni ekranda wisequarter acar

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");

        String actualUrl=driver.getCurrentUrl();
        String expectedKelime="wisequarter";
        Assert.assertTrue(actualUrl.contains(expectedKelime));
        Thread.sleep(3000);

        // wisequarter testini yaptiktan sonra ,
        // yeniden amazon'un acik oldugu tab'a gecin
        // ve amazon anasayfanin acik oldugunu test edin

        driver.switchTo().window(ilkSayfaHandleDegeri);

        actualUrl=driver.getCurrentUrl();
        expectedKelime="amazon";
        Assert.assertTrue(actualUrl.contains(expectedKelime));
        Thread.sleep(3000);
    }


}
