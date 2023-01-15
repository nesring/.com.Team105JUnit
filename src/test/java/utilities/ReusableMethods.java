package utilities;

public class ReusableMethods {

    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {

        }
    }
}

// exception firlatirsak kullandigimiz her yerde exception gelecek
// onun yerine surround try catch daha kullanisli

