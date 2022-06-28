package src.Raumbuchungssystem.GUI;

//Author Murat Dursun

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
        String raumNr = sc.nextLine();

        System.out.println("Bitte geben Sie Ihren gewuenschten Wochentag ein: ");
        String wochentag = sc.nextLine();

        System.out.println("Bitte geben Sie Ihre gewuenschte Uhrzeit ein: ");
        String uhrzeit = sc.nextLine();

        //System.out.println(name);


    }
}
