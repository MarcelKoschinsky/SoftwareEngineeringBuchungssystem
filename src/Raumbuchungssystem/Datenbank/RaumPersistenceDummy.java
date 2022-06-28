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

    /**
     * Generiert 3 Räume und gibt diese als HashSet zurück
     *
     * @return 3 Platzhalter-Räume
     */
    public static Set<Raum> ladeRaeume() {
        Set<Raum> raumset = new HashSet<>();

        Raum raum101 = new Raum(101, "Seminarraum");
        Raum raum102 = new Raum(102, "Seminarraum");
        Raum raum103 = new Raum(103, "Seminarraum");
        raum103.setBuchung(0, 0, "Janik");

        raumset.add(raum101);
        raumset.add(raum102);
        raumset.add(raum103);

        return raumset;
    }
}
