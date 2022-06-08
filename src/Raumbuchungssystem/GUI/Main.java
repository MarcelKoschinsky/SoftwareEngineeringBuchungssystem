package src.Raumbuchungssystem.GUI;

//Author Murat Dursun

import src.Raumbuchungssystem.Logik.IRaumManager;
import src.Raumbuchungssystem.Logik.RaumManager;
import src.Raumbuchungssystem.Objekte.Raum;

import java.util.Set;

public class Main {
    public static void main (String[]args) {
        IRaumManager raumManager = new RaumManager();   //neuen RaumManager erstellt

        Set<Raum> raeume = raumManager.listeAlleRaeume();//erstelle eine liste aller Raeume

        System.out.println(raeume);     //gib die Raeume auf der Konsole aus

    }
}
