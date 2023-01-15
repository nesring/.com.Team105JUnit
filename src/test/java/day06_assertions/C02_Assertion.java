package day06_assertions;

import org.junit.Assert;
import org.junit.Test;

public class C02_Assertion {
    /*
    JUnit framework'u calistiriln test'lerin passed veya failed olmasini raporlar
    Ancak raporlmnin dogru sonuc vermesi icin, Test'lerin
    Assert calss'indaki hazir method'larla yapilmasi gerekir.

    Eger Assert class'i kullanilmazsa,
    JUnit kodlarin sorunsuz olarak calisip bittigini raporlar
    C01 de testleri if-else ile yaptigimiz icin , Testler failed olsa da kodlar
    sorunsuz calistigi icin testler yesil tik ile isaretlendi

     */

    int P1yas=60;
    int P2yas=66;
    int P3yas=70;

    @Test
    public void test01(){
        //emekli yasi 65 olduguna gore,
        // P2 nin emekli olabilecegini test edin

        Assert.assertTrue(P2yas > 65);
    }

    @Test
    public void test02(){
        //emekli yasi 65 olduguna gore,
        // P1 in emekli olaMayacagini test edin

        Assert.assertFalse(P1yas > 65);

    }

    @Test
    public void test03(){
        //emekli yasi 65 olduguna gore,
        // P3 un emekli olaMAyacagini test edin

        Assert.assertFalse("Girilen yas 65 ten kucuk olmadigindan emekli olabilir ",P3yas > 65);
    }

}
