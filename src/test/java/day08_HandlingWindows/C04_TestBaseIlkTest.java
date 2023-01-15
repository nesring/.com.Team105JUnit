package day08_HandlingWindows;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_TestBaseIlkTest extends TestBase {

    @Test

    public void test01() throws InterruptedException {

        // amazon'a gidin

        driver.get("https://www.amazon.com");

        // amazon'a gittiginizi test edin

        String expectedKelime= "amazon";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedKelime));

        ReusableMethods.bekle(3);

        /*
        test base clasorunune inherit ettoik boylece ondaki methodlar direkt olarak burda calisacak, (overriding icin
        yeni method gerekirdi
        extends etmek yeterli degil,
        driver in ulasilabilir olmasi icin access
        modifier i onemli , defalt tan protected'a cevirdik

         */
    }
}
