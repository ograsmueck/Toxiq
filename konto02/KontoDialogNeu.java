package konto02;

import java.util.*;

/**
 * Interaktive Testklasse für die Klasse Konto
 *
 * @author Folz
 * @version 1.1
 */
public class KontoDialogNeu {
    private Konto konto1;
    private Konto zielkonto;
    private Scanner input = new Scanner(System.in);

    // Klassenkonstanten
    private static final int ANLEGEN = 1;
    private static final int EINZAHLEN = 2;
    private static final int ABHEBEN = 3;
    private static final int UEBERWEISEN = 4;
    private static final int SET_INHABER = 5;
    private static final int ENDE = 0;

    /**
     * Hauptschleife des Testprogramms
     */
    public void start() {
        konto1 = null;
        zielkonto = null;
        int funktion = -1;

        while (funktion != ENDE) {
            try {
                funktion = einlesenFunktion();
                ausfuehrenFunktion(funktion);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            } catch (InputMismatchException e) {
            	System.out.println(e);
            	input.nextLine();
            	
            } catch (Exception e) {
                System.out.println("Irgendeine Ausnahme gefangen: " + e);
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
        System.out.print(ANLEGEN     + ": anlegen; "    +
            EINZAHLEN   + ": einzahlen; "  + 
            ABHEBEN     + ": abheben; "    + 
            UEBERWEISEN + ": überweisen; " +
            SET_INHABER + ": setInhaber; " + 
            ENDE        + ": beenden -> ");

        return input.nextInt();
    }

    /**
     * Ausführen der ausgewählten Funktion
     * 
     * @param die auszuführende Funktion als ganze Zahl
     */
    private void ausfuehrenFunktion(int funktion) {

        if (funktion == ANLEGEN) {
            konto1 = kontoAnlegen();

        } else if (funktion == EINZAHLEN) {
           konto1.einzahlen(einleseBetrag());

        } else if (funktion == ABHEBEN) {
            konto1.abheben(einleseBetrag());

        } else if (funktion == UEBERWEISEN) {
            if (zielkonto == null)
                zielkonto = kontoAnlegen();
            konto1.ueberweisen(zielkonto,einleseBetrag());

        } else if (funktion == SET_INHABER) {  
            konto1.setInhaber(einleseInhaber());

        } else if (funktion == ENDE) {
            System.out.println("Programmende");

        } else {
            System.out.println("Falsche Funktion!");
        }
        System.out.println(konto1);
        System.out.println(zielkonto);
    }

    private Konto kontoAnlegen() {
        int kontonr;
        String inhaber;
        double kontostand;
        System.out.print("Kontonummer: ");
        kontonr = input.nextInt();
        input.nextLine();
        System.out.print("Inhaber    : ");
        inhaber = input.nextLine();
        System.out.print("Kontostand : ");
        kontostand = input.nextDouble();          
        return new Konto(kontonr, inhaber, kontostand);
    }

    private double einleseBetrag() {
        System.out.print("Betrag: ");
        return input.nextDouble();
    }

	private String einleseInhaber() {
		String inhaber;
		System.out.println("Neuer Inhaber: ");
		input.nextLine();
		inhaber = input.nextLine();
		return inhaber;
	}

    /**
     * Main-Methode zum Erzeugen des KontoDialog-Objektes und zum Anstarten der
     * Testschleife
     */
    public static void main(String[] args) {
        new KontoDialogNeu().start();
    }
}
