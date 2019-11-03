package konto02;

/**
 * Eine sehr einfache Klasse für ein Konto
 * 
 * @author Folz 
 * @version 1.1
 */
public class Konto {
    private int kontonr;
    private String inhaber;
    private double kontostand;

    /**
     * ausführlicher Konstruktor
     *
     * @param kontonr 4-stellige Kontonummer
     * @param inhaber darf nicht leer sein
     * @param kontostand muss >= 0 sein
     */
    public Konto(int kontonr, String inhaber, double kontostand) {
    	check(kontonr >= 1000 && kontonr <= 9999,
              "Kontonr muss 4-stellig sein");
     	check(kontostand >= 0, "Kontostand muss >= 0.0 sein");
        this.kontonr = kontonr;
        setInhaber(inhaber);
        this.kontostand = kontostand;
    }


    public Konto(int kontonr, String inhaber) {
        this(kontonr, inhaber, 0.0);
        
    }

    /**
     * Einzahlen eines Betrages, 
     *
     * @param betrag muss > 0 sein
     */
    public void einzahlen (double betrag) {  
        check(betrag > 0.0,  "betrag muss > 0.0 sein!");
        kontostand = kontostand + betrag;
    }
    
    /**
     * Einen Betrag abheben
     * 
     * @param  betrag muss > 0 sein 
     * 
     */    
    public void abheben(double betrag) {
        check(betrag > 0.0,  "betrag muss > 0.0 sein!");
        kontostand = kontostand - betrag;
    }

    /**
     * Überweise einen Betrag vom aktuellen Konto auf das übergebene Zielkonto
     *
     * @param zielkonto Referenz auf ein Konto (!= null)
     * @param betrag zu überweisender Betrag
     */
    public void ueberweisen(Konto zielkonto, double betrag) {
        this.abheben(betrag);
        zielkonto.einzahlen(betrag);
    }
    
    
    public int getKontonr() {
    	return kontonr;
    }
    
    public double getKontostand() {
        return kontostand;
    }

    public String getInhaber() {
		return inhaber;
	}

    /**
     * Inhaber wird verändert
     *
     * @param inhaber neuer Wert (darf nicht leer sein!)
     */
    public void setInhaber(String inhaber) {
        check (inhaber != null && !inhaber.isEmpty(), 
        	  "Inhaber darf nicht leer sein"); 
        this.inhaber = inhaber;
    }
    
    public String toString() {
        return "Kontonr: " + kontonr
             + ", Inhaber: " + inhaber
             + ", Kontostand: " + kontostand;
    }
    
    public static void check(boolean bedingung, String msg) {
        if (!bedingung)
            throw new IllegalArgumentException(msg);
    }
}
