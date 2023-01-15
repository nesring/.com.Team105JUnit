package day07_dropdown_jsAlerts;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_handleDropdownMenu {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void teardown(){
        driver.close();

    }
    @Test
    public void test01() throws InterruptedException {
        // ilgili ayarlari yapip
        // amazon ana sayfaya gidin
        // arama kutusu yanindaki dropdown menuden book secin
        // arama kutusuna java yazdirip aramayi yaptirin
        // title'in java icerdigini test edin

        driver.get("https://www.amazon.com");
        // Dropdown menuden istedigimiz option'i secebilmek icin,
        // oncelikle select class'indan bir obje olusturmaliyiz
        // ancak select on+bjesi olusturmak icin, select class'inin conscructor'i
        // handle edecegimiz webElement'i istediginden

        // 1.select objesi olusturmadan once dropdown webelementini locat eetmeliyiz

        WebElement dropdownwebElementi = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        // 2. select class'indan obje olusturma

        Select select = new Select(dropdownwebElementi);

        // 3-select objesini kullanarak istedigimiz method/method'lari calistirin

        //select.selectByValue("search-alias=stripbooks-intl-ship");
       //select.selectByIndex(5);

        select.selectByVisibleText("Books");

        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);

        //System.out.println(driver.getTitle());

        String expectedKelime="Java";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedKelime));

        // dropdown menuden Books seceneginin secildigini test edin

        /*
        locate tettigimiz elementi bulamazsa. NoSuchElementException verir
        sayfa yenilendigi icin var olan bir elemnti kullanamazsa
        StaleElementException verir
        bu durumda locate ve secme islemlerini yeniden yaparsak kod calisir
         */
       dropdownwebElementi =driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
       select =new Select(dropdownwebElementi);
       select.selectByVisibleText("Books");

       String actualSecilenOption= select.getFirstSelectedOption().getText();
       String expectedSecilecekOption = "Books";

        Assert.assertEquals(expectedSecilecekOption,actualSecilenOption);

        // Dropdown menudeki secenek sayisinin 28 oldugunu test edin

       List<WebElement> optionsWEbElementListesi =select.getOptions();

       int actualOptionSayisi= optionsWEbElementListesi.size();
       int expectedOptionSayisi =28;

       Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);




        Thread.sleep(3000);
    }
}
