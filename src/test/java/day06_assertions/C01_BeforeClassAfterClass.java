package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClassAfterClass {

    // 3 ayri test method'u olusturun
    // 1. method'da amazon'a gidip , amazon'a gittigimizi test edin
    // 2. method'da amazon'da nutella aratip, sonuclarin nutella icerdigini test edin
    // 3. method'da nutella arama sonuc sayisinin 50'den fazla oldugunu test edin

    //her 3 test ayni sayfada, 2. testi yapabilmek icin
    // 1 adim gerceklesmis ve kapatilmamis olmali
    // bu yuzden @before degil, @beforeclass yani
    // her testten once degil en basta , testler
    // baslamadan once 1 kez yapilacak on ayarlar

static WebDriver driver;
// @BeforeClassve @AfterClass satatic olunca, orda kullanilan
// driver da static olmak zorunda, yoksa o method icinde kullanilamaz

@BeforeClass
// @BeforeClass ve AfterClass notasyonunu kullanan method'lar
// static olmak zorundadir


    public static void setUp(){
    WebDriverManager.chromedriver().setup();
    driver =new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    System.out.println("SetUp method'u calisti");
}

@AfterClass public static void tearDown(){
    driver.close();
    System.out.println("tearDown method'u calisti");
}

@Test
    public void test01(){
    // 1. method'da amazon'a gidip , amazon'a gittigimizi test edin
    driver.get("https://www.amazon.com");

    String expectedKelime="Amazon";
    String actualTitle =driver.getTitle();

    if (actualTitle.contains(expectedKelime)) {
        System.out.println("Amazon gidis testi PASSED");
    }else {
        System.out.println("Amazon gidis testi FAILED");

    }

}

@Test
    public void test02(){
    // 2. method'da amazon'da nutella aratip, sonuclarin nutella icerdigini test edin

    WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
    aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

    String expectedKelime = "Nutella";
    WebElement sonucYaziElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
    String sonucYazisiStr= sonucYaziElementi.getText();

    if (sonucYazisiStr.contains(expectedKelime)) {
        System.out.println(" Nutella arama testi PASSED");
    }else {
        System.out.println(" Nutella arama testi FAILED");
    }
}
// testler bagimsiz calistirilabiliyordu, run tusu ucunde de basilabilir, ancak 1. test calismadan 2, 2 calismadan 3, calismaz cunku amazona gitmemissek arama yapamamyiz,
    // arama yapmamissak sonuc sayisi goremeyiz
    //@Beforeclass ve @Afterclass kullanildiysa test methodlari bagimsiz CALISMAYABILIR
@Test
    public void test03(){
    // 3. method'da nutella arama sonuc sayisinin 50'den fazla oldugunu test edin
    // 2. teste sonucyazisini bulmustuk zaten ve bu bilgi de o yazida
    //ancak o sonuc ve elemente bu scop'tan ulasamiyoruz, ya yeniden locate edecegiz
    // ya da obje olusturmayi (sonucyazisielementi )class levelde yapip deger atamayi teste yapacagiz

    WebElement sonucYaziElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
    String sonucYazisiStr= sonucYaziElementi.getText();

    // System.out.println(sonucYazisiStr);burda arama sonuc sayisini string olarak getirdigini gorduk
    // string icinden istedigimiz rakami ayirmamiz gerek

    String[] sonucYazisiArr = sonucYazisiStr.split(" ");
    String sonucAdediStr = sonucYazisiArr[2];
    int actualsonucAdediInt = Integer.parseInt(sonucAdediStr);

    int expectedAramaSonucSayisi=50;

    if (actualsonucAdediInt > expectedAramaSonucSayisi) {
        System.out.println("Nutella arama sonuc sayisi testi PASSED");
    }else {
        System.out.println("Nutella arama sonuc sayisi testi FAILED");
    }

    }

}
