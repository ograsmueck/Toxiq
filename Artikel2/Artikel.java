/**
 * Beschreiben Sie hier die Klasse Artikel.
 * 
 * @author Alexander Lorbach, Oliver Grasmück 
 * @version 26.10.2019
 */
public class Artikel
{
    // Variablen für die Klasse Artikel
    private int artikelnr;
    private String bezeichnung;
    private int bestand;
    
    /**
     * Eine Methode um den Bestand eines Artikels zu erhöhen
     * 
     * @param  menge	(Die zuzubuchende Menge)
     */
    public void bucheZugang(int menge)
    {
       //Bestand erhöhen um eine bestimmte menge
       if (menge <= 0){
           System.out.println("Die Zahl muss groesser 0 sein");          //User Fehler ausgeben
       } else{
       this.bestand = bestand + menge;
       }
    }
    
    /**
     * Eine Methode um den Bestand eines Artikels zu reduzieren
     * 
     * @param  menge	(Die abzubuchende Menge)
     */
    public void bucheAbgang(int menge)
    {
       //Bestand reduzieren um eine bestimmte menge
       if (menge <= 0){
          System.out.println("Die Zahl muss groesser 0 sein");          //User Fehler ausgeben 
       } else{
          if (bestand - menge < 0)
           {
               System.out.println("Der Artikelbestand darf nicht weniger als 0 sein");      //User Fehler ausgeben
            } else {
                this.bestand = bestand - menge;
            } 
       }
    }
    
    /**
     * Eine Methode um alle Atribute dieser Klasse auzugegeben
     * 
     * @return		Alle Atribute der Klasse
     */
    public String toString()
    {
        // Die Atribute werden als Zeichenkette ausgegeben
        return "Artikelnummer: " + artikelnr +
                ", Artikelbezeichnung: " + bezeichnung +
                ", Artikelbestand: " + bestand;
    }

    /**
     * get-Methode für Artikelnummer
     * 
     * @return		Die Artikelnummer wird ausgegeben
     */
    public int getArtikelnummer()
    {
        // Artikelnummer ausgeben
        return artikelnr;
    }
    
    /**
     * get-Methode für Artikelbezeichnung
     * 
     * @return		Die Artikelbezeichnung wird ausgegeben
     */
    public String getArtikelbezeichnung()
    {
        // Artikelbezeichnung ausgeben
        return bezeichnung;
    }
    
    /**
     * get-Methode für Artikelbestand
     * 
     * @return		Die Artikelbestand wird ausgegeben
     */
    public int getArtikelbestand()
    {
        // Artikelbestand ausgeben
        return bestand;
    }
    
    /**
     * set-Methode für Artikelbestand
     * 
     * @param  	        Artikelbestand
     */
    public void setArtikelbestand(int bestand)
    {
        //Ueberprüfen ob etwa eingegeben wurde
        check(bestand > 0, "Der Bestand darf nicht kleiner als 0 sein");        
        //Attribut Artikelbezeichnung füllen mit einem String
        this.bestand = bestand;        
    }

    /**
     * Konstruktor für Objekte der Klasse Artikel
     */
    public Artikel(int artikelnr, String bezeichnung, int bestand)
    {
        //Ueberprüfen ob alle Werte das Korrekte das "Korrekte Formate" haben
        check(artikelnr >= 1000 && artikelnr <=9999, "Artikelnummer muss 4-stellig und positiv sein");
        check(bezeichnung != null, "Die Bezeichnung darf nicht leer stehen");  
        //check(bezeichnung.isEmpty(), "Die Bezeichnung darf nicht leer stehen");
        //Atribute mit Werten füllen
        this.artikelnr = artikelnr;
        this.bezeichnung = bezeichnung;
        setArtikelbestand(bestand);
    }
    
    /**
     * Konstruktor für Objekte der Klasse Artikel
     */
    public Artikel(int artikelnr, String bezeichnung)
    {
        //Attribute werden gefüllt ohne die angabe eines Bestands(Bestand bleibt 0)
        this(artikelnr, bezeichnung, 0);
    }
    
    /**
     * Check Methode
     * 
     * @param  bedingung	(Bedingung kann wahr oder falsch sein)
     */
    public static void check(boolean bedingung, String msg)
    {
        //Check Methode mit Ausgabe des Problems in msg
        if (!bedingung)
            throw new IllegalArgumentException(msg);
    }

}
