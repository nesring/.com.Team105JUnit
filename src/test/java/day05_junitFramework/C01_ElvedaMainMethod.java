package day05_junitFramework;

import org.junit.Ignore;
import org.junit.Test;

public class C01_ElvedaMainMethod {

@Test
    public void test01() {
    System.out.println("test 01 calisti");

    }
    // main method olmayinca yazacagimiz
    // herhangibir test methodunu da calistiramiyoruz

    // @Test notasyonu sayesinde her bir test method'u bagimsiz calisabilir
    // eger testin icersinde bir assertion yoksa
    // kod problem yasanmadan calisip bittiginde
    //JUnit test passed olarak raporlar

    @Test @Ignore
    public void test02() {
        System.out.println("test 02 calisti");

        //@Ignore notasyonu yazildigi test methodunun calistirilMAmasini saglar
    }


    @Test
    public void test03() {
        System.out.println("test 03 calisti");

    }


}
