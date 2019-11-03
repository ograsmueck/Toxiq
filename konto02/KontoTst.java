package konto02;


/**
 * Sehr rudimentäres "Testprogramm"
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class KontoTst {
    public static void main(String [] args) {
        Konto k1 = new Konto(4711, "Meier");
        k1.einzahlen(2000.0);
        System.out.println("Konto: " + k1);
        k1.abheben(-1000.0);
    }
}
