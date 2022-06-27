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
