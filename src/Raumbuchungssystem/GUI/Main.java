package src.Raumbuchungssystem.GUI;

/*
UI des Raumbuchungssystems
Nimmt Nutzereingaben und gibt sie an bucheRaum weiter
@Author Murat Dursun
 */

import src.Raumbuchungssystem.Logik.IRaumManager;
import src.Raumbuchungssystem.Logik.RaumManager;
import src.Raumbuchungssystem.Objekte.Raum;

import java.util.Scanner;
import java.util.Set;

public class Main {

    IRaumManager raumManager = new RaumManager();   //neuen RaumManager erstellt

    public static void main (String[]args) {
        IRaumManager raumManager = new RaumManager();   //neuen RaumManager erstellt

        Set<Raum> raeume = raumManager.listeAlleRaeume();//erstelle eine liste aller Raeume

        System.out.println(raeume);     //gib die Raeume auf der Konsole aus

        //Scanner für das GUI
        Scanner sc = new Scanner(System.in);

        System.out.println("Bitte geben Sie Ihren Namen ein: ");
        String name = sc.nextLine();

        System.out.println("Bitte geben Sie Ihre gewuenschte RaumNr ein: ");
        String raumNrString = sc.nextLine();
        int raumNr = Integer.parseInt(raumNrString);

        System.out.println("Bitte geben Sie Ihren gewuenschten Wochentag ein: ");
        String wochentagString = sc.nextLine();
        int wochentag = Integer.parseInt(wochentagString);

        System.out.println("Bitte geben Sie Ihre gewuenschte Uhrzeit ein: ");
        String uhrzeitString = sc.nextLine();
        int uhrzeit = Integer.parseInt(uhrzeitString);

        raumManager.bucheRaum(raumNr, uhrzeit, wochentag, name);

    }
}
