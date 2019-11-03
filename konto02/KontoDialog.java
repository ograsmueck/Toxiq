package konto02;

import java.util.*;

/**
 * Interaktive Testklasse für die Klasse Konto
 *
 * @author Folz
 * @version 1.0
 */
public class KontoDialog {
    private Konto konto1;
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
        int funktion;
        System.out.print(ANLEGEN     + ": anlegen; "    + 
            EINZAHLEN   + ": einzahlen; "  + 
            ABHEBEN     + ": abheben; "    + 
            UEBERWEISEN + ": überweisen; " +
            SET_INHABER + ": setInhaber; " + 
            ENDE        + ": beenden -> ");

        funktion = input.nextInt();
        input.nextLine();
        return funktion;
    }

    /**
     * Ausführen der ausgewählten Funktion
     * 
     * @param die auszuführende Funktion als ganze Zahl
     */
    private void ausfuehrenFunktion(int funktion) {
        int kontonr;
        String inhaber;
        double kontostand;
        double betrag;

        if (funktion == ANLEGEN) {
            System.out.print("Kontonummer: ");
            kontonr = input.nextInt();
            inhaber = input.nextLine();
            System.out.print("Inhaber    : ");
            inhaber = input.nextLine();
            System.out.print("Kontostand : ");
            kontostand = input.nextDouble();          
            konto1 = new Konto(kontonr, inhaber, kontostand);

        } else if (funktion == EINZAHLEN) {
            System.out.print("Betrag: ");
            betrag = input.nextDouble();
            konto1.einzahlen(betrag);

        } else if (funktion == ABHEBEN) {
            System.out.print("Betrag: ");
            betrag = input.nextDouble();
            konto1.abheben(betrag);

        } else if (funktion == UEBERWEISEN) {

        } else if (funktion == SET_INHABER) {
            System.out.println("Neuer Inhaber: ");
            inhaber = input.nextLine();
            konto1.setInhaber(inhaber);

        } else if (funktion == ENDE) {
            System.out.println("Programmende");

        } else {
            System.out.println("Falsche Funktion!");
        }
        System.out.println(konto1);
    }

    /**
     * Main-Methode zum Erzeugen des KontoDialog-Objektes und zum Anstarten der
     * Testschleife
     */
    public static void main(String[] args) {
        new KontoDialog().start();
    }
}
