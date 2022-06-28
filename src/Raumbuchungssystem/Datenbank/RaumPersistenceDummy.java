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

    static Set<Raum> raumset = new HashSet<>();


    public static Set<Raum> ladeRaeume() {
        return raumset;
    }


    public static void speichereRaeume(Set<Raum> raeume) {
        raumset=raeume;
    }

}



    int uhrzeit;
    int tag;

    int[][] kalender = {
            {0, 2, 2, 4, 4, 2, 2, 4, 2, 2, 2, 2, 4, 2, 4, 2, 2, 2},
            {0, 2, 2, 4, 4, 2, 2, 4, 2, 2, 2, 2, 4, 2, 4, 2, 2, 2},
            {0, 2, 2, 4, 4, 2, 2, 4, 2, 2, 2, 2, 4, 2, 4, 2, 2, 2},
            {0, 2, 2, 4, 4, 2, 2, 4, 2, 2, 2, 2, 4, 2, 4, 2, 2, 2},
            {0, 2, 2, 4, 4, 2, 2, 4, 2, 2, 2, 2, 4, 2, 4, 2, 2, 2},
            {0, 2, 2, 4, 4, 2, 2, 4, 2, 2, 2, 2, 4, 2, 4, 2, 2, 2},


    };

 if (kalender [tag][uhrzeit] = 5) {
         System.out.println("Der Termin ist frei!");
         } else {

         }

