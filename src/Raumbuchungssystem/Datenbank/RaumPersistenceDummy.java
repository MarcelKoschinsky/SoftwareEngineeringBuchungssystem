package src.Raumbuchungssystem.Datenbank;

import src.Raumbuchungssystem.Objekte.Raum;

import java.util.HashSet;
import java.util.Set;

/**
 * Eine Dummy-RaumPersistence zu Testzwecken
 *
 * @author Janik Lüttringhaus
 */
public class RaumPersistenceDummy {

    //static Set<Raum> raumset = new HashSet<>();


    public static Set<Raum> ladeRaeume() {
        Set<Raum> raumset = new HashSet<>();

        Raum raum101=new Raum(101,"Seminarraum");
        Raum raum102=new Raum(102,"Seminarraum");
        Raum raum103=new Raum(103,"Seminarraum");

        raumset.add(raum101);
        raumset.add(raum102);
        raumset.add(raum103);

        return raumset;
    }

/*
    public static void speichereRaeume(Set<Raum> raeume) {
        raumset=raeume;
    }*/

}

/*

    int uhrzeit = ;
    int tag;

    int[][] kalender = {
            {0, 2, 2, 4, 4, 2, 2, 4, 2, 2, 2, 2, 4, 2, 4, 2, 2, 2},
            {1, 2, 2, 4, 4, 2, 2, 4, 2, 2, 2, 2, 4, 2, 4, 2, 2, 2},
            {2, 2, 2, 4, 4, 2, 2, 4, 2, 2, 2, 2, 4, 2, 4, 2, 2, 2},
            {3, 2, 2, 4, 4, 2, 2, 4, 2, 2, 2, 2, 4, 2, 4, 2, 2, 2},
            {4, 2, 2, 4, 4, 2, 2, 4, 2, 2, 2, 2, 4, 2, 4, 2, 2, 2},
            {5, 2, 2, 4, 4, 2, 2, 4, 2, 2, 2, 2, 4, 2, 4, 2, 2, 2},
            {6, 2, 2, 4, 4, 2, 2, 4, 2, 2, 2, 2, 4, 2, 4, 2, 2, 2},


    };

 if (kalender [tag][uhrzeit] = 2) {
         System.out.println("Der Termin ist frei!");
         } else {
         System.out.println("Der Termin ist leider besetzt");
         }

*/