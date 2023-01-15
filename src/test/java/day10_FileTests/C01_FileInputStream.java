package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileInputStream {

    @Test
    public void test01() throws FileNotFoundException {


    // String dosyaYolu= "C:\\Users\\nesri\\OneDrive\\Desktop\\MerhabaJava.docx";

        String dosyaYolu = "C:/Users/nesri/OneDrive/Desktop/MerhabaJava.docx";

FileInputStream fis = new FileInputStream(dosyaYolu);

/*
File testlerinde genellikle downloads'a indirilecek bir dosyanin
indirildigini
veya masa ustundeki bir dosyanin web'e yuklenebildigini test etmek isteriz

Ancak herkesin bilgisayarinin ismi, kullanici isimleri gibi farkliliklar olacagindn, testler tek bir
bilgisayarda calisacakmis gibi yazilmak zorunda kalir

Bu karisikligin onune gecebilmek icin Java 2 basit kod blogu sunmustur

 */
       System.out.println(System.getProperty("user.dir"));

        // o anda calisan dosyanin (C01_FileInputStream) yolunu verir
        // C:\Users\nesri\OneDrive\Desktop\Git\com.Team105JUnit

        System.out.println(System.getProperty("user.home"));

        // kullanicinin temel path'ini verir
        // C:\Users\nesri

        // masaustune gitmek istersek
        // C:\Users\nesri + \ Desktopeklememiz yeterlidir

        // downloads'a gitmek istersek
        // C:\Users\nesri + / Downloads ??? / \

        // Kodlarimizin dinmik olmsi, yani kisinin bilgisayarindaki kullanici adi gibi detaylara takilmamamsi icin, file testlerinde
        // kullanilacak dosya yolunu,
        // user.home ..temel path'ini calistigi bilgisayardan alacak sekilde olustururuz

        String dinamikDosyaYolu = System.getProperty("user.home") + "\\OneDrive\\Desktop\\MerhabaJava.docx";



    }
}
