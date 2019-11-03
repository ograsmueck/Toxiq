/**
 * Beschreiben Sie hier die Klasse Artikel.
 * 
 * @author Alexander Lorbach, Oliver Grasmueck 
 * @version 26.10.2019
 */
public class Artikel
{
    // Variablen fuer die Klasse Artikel
    private int artikelnr;
    private String bezeichnung;
    private int bestand;
    
    /**
     * Eine Methode um den Bestand eines Artikels zu erhoehen
     * 
     * @param  menge    (Die zuzubuchende Menge)
     */
    public void bucheZugang(int menge)
    {
       //Bestand erhoehen um eine bestimmte menge
       if (menge <= 0){
           System.out.println("Die Zahl muss groesser 0 sein");          //User Fehler ausgeben
       } else{
       this.bestand = bestand + menge;
       }
    }
    
    /**
     * Eine Methode um den Bestand eines Artikels zu reduzieren
     * 
     * @param  menge    (Die abzubuchende Menge)
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
     * Eine Methode um alle Atribute dieser Klasse auszugegeben
     * 
     * @return      Alle Atribute der Klasse
     */
    public String toString()
    {
        // Die Atribute werden als Zeichenkette ausgegeben
        return "Artikelnummer: " + artikelnr +
                ", Artikelbezeichnung: " + bezeichnung +
                ", Artikelbestand: " + bestand;
    }

    /**
     * get-Methode fuer Artikelnummer
     * 
     * @return      Die Artikelnummer wird ausgegeben
     */
    public int getArtikelnummer()
    {
        // Artikelnummer ausgeben
        return artikelnr;
    }
    
    /**
     * get-Methode fuer Artikelbezeichnung
     * 
     * @return      Die Artikelbezeichnung wird ausgegeben
     */
    public String getArtikelbezeichnung()
    {
        // Artikelbezeichnung ausgeben
        return bezeichnung;
    }
    
    /**
     * get-Methode fuer Artikelbestand
     * 
     * @return      Die Artikelbestand wird ausgegeben
     */
    public int getArtikelbestand()
    {
        // Artikelbestand ausgeben
        return bestand;
    }
    
    /**
     * set-Methode fuer Artikelbestand
     * 
     * @param           Artikelbestand
     */
    public void setArtikelbestand(int bestand)
    {
        //Ueberpruefen ob etwas eingegeben wurde > 0
        check(bestand >= 0, "Der Bestand darf nicht kleiner als 0 sein");        
        //Attribut Artikelbezeichnung fuellen mit einem String
        this.bestand = bestand;        
    }

    /**
     * Konstruktor fuer Objekte der Klasse Artikel
     */
    public Artikel(int artikelnr, String bezeichnung, int bestand)
    {
        //Ueberpruefen ob alle Werte das "Korrekte Format" haben
        check(artikelnr >= 1000 && artikelnr <=9999, "Artikelnummer muss 4-stellig und positiv sein");
        check(bezeichnung != null, "Die Bezeichnung darf nicht leer stehen");  
        //check(bezeichnung.isEmpty(), "Die Bezeichnung darf nicht leer stehen");
        //Atribute mit Werten fuellen
        this.artikelnr = artikelnr;
        this.bezeichnung = bezeichnung;
        setArtikelbestand(bestand);
    }
    
    /**
     * Konstruktor fuer Objekte der Klasse Artikel
     */
    public Artikel(int artikelnr, String bezeichnung)
    {
        //Attribute werden gefuellt ohne die Angabe eines Bestands(Bestand bleibt 0)
        this(artikelnr, bezeichnung, 0);
    }
    
    /**
    * Ein Standardkonstruktor macht keinen Sinn, da das anlegen von Artikeln eine uebergabe von Parametern erfordert.
    */
    
    /**
     * Check Methode
     * 
     * @param  bedingung    (Bedingung kann wahr oder falsch sein)
     */
    private static void check(boolean bedingung, String msg)
    {
        //Check Methode mit Ausgabe des Problems in msg
        if (!bedingung)
            throw new IllegalArgumentException(msg);
    }
}
