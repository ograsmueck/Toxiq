package Artikel;


/**
 * Beschreiben Sie hier die Klasse ArtikelDialog.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class ArtikelDialog
{
    private Artikel artikel1;
    private Artikel artikelMinBestand;
    private Scanner input = new Scanner(System.in);

    private static final int ANLEGEN = 1;
    private static final int ANLEGEN_MIN_BESTAND = 2;
    private static final int ZUBUCHEN = 3;
    private static final int ABBUCHEN = 4;
    private static final int SET_BESTAND = 5;
    private static final int ENDE = 0;
   
    /**
     * Hauptschleife des Testprogramms
     */
    public void start() 
    {
        artikel1 = null;
        artikelMinBestand = null;
        int funktion = -1;

        while (funktion != ENDE) 
        {
            try 
            {
                funktion = einlesenFunktion();
                ausfuehrenFunktion(funktion);
            } 
            
            catch (IllegalArgumentException e) 
            {
                System.out.println(e);
            } 
            
            catch (InputMismatchException e) 
            {
                System.out.println(e);
                input.nextLine();
                
            } 
            
            catch (Exception e) 
            {
                System.out.println("Es wurde eine Ausnahme eingefangen und zwar: " + e);
                e.printStackTrace(System.out);
            }

        }
    }
    
    /**
     * Menü ausgeben und Funktion einlesen.
     * 
     * @return eingelesene Funktion als ganzzahliger Wert
     */
    private int einlesenFunktion() {
        System.out.print
            (
            ANLEGEN                 + ": Artikel anlegen; " +
            ANLEGEN_MIN_BESTAND     + ": einzahlen; " + 
            ZUBUCHEN                + ": abheben; " + 
            ABBUCHEN                + ": überweisen; " +
            SET_BESTAND             + ": setInhaber; " + 
            ENDE                    + ": beenden "
            );

        return input.nextInt();
    }
    
    /**
     * Ausführen der ausgewählten Funktion
     * 
     * @param die auszuführende Funktion als ganze Zahl
     */
    private void ausfuehrenFunktion(int funktion) {

        if (funktion == ANLEGEN) 
        {
            artikel1 = artikelAnlegen();

        }
        
        else if (funktion == ANLEGEN_MIN_BESTAND) 
        {
           artikelMinBestand.artikelAnlegenMinBestand();

        } 
        
        else if (funktion == ZUBUCHEN) 
        {
            artikel1.zubuchen(zuMenge());

        } 
        
        else if (funktion == ABBUCHEN) 
        {
            artikel1.abbuchen(abMenge());

        } 
        
        else if (funktion == SET_BESTAND) 
        {  
            konto1.setInhaber(einleseInhaber());

        } 
        
        else if (funktion == ENDE) 
        {
            System.out.println("Das Programm wird beendet.");

        } 
        
        else 
        {
            System.out.println("Fehlerhafte Auswahl einer Funktion!");
        }
        System.out.println(artikelAnlegen);
        System.out.println(artikelAnlegenX);
    }
    
    private double einleseBetrag() {
        System.out.print("Betrag: ");
        return input.nextDouble();
    }

    private String einleseInhaber() 
    {   
	String inhaber;
	System.out.println("Neuer Inhaber: ");
	input.nextLine();
	inhaber = input.nextLine();
	return inhaber;
}  

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}