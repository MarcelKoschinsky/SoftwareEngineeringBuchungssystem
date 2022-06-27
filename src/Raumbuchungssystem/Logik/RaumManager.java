package src.Raumbuchungssystem.Logik;

import src.Raumbuchungssystem.Datenbank.RaumPersistenceDummy;
import src.Raumbuchungssystem.Objekte.Raum;

import java.util.HashSet;
import java.util.Set;

/**
 * Der RaumManager verwaltet die Räume inkl. Raumbuchungen
 *
 * @author Janik Lüttringhaus
 */
public class RaumManager implements IRaumManager {

        /**
         *
         * @return Alle Räume
         */
    @Override
    public Set<Raum> listeAlleRaeume() {
        return RaumPersistenceDummy.ladeRaeume();
    }

        /**
         * Gibt alle freien Räume als HashSet zurück.
         *
         * @param uhrzeit Uhrzeit im Format 0-17 (siehe ReadMe)
         * @param wochentag Wochentag im Format 0-6 (siehe ReadMe)
         * @return Alle freien Räume als HashSet
         */
    @Override
    public Set<Raum> listeFreieRaeume(int uhrzeit, int wochentag) {
        Set<Raum> temp=RaumPersistenceDummy.ladeRaeume();
        Set<Raum> ausgabe= new HashSet<>();

        for (Raum x:temp) {
            if (x.kalender[uhrzeit][wochentag]==null) {
                ausgabe.add(x);
            }
        }


        return ausgabe;
    }

        /**
         *
         * @param raum
         * @param uhrzeit Uhrzeit im Format 0-17 (siehe ReadMe)
         * @param wochentag Wochentag im Format 0-6 (siehe ReadMe)
         * @param name Name der buchenden Person
         */
    @Override
    public void bucheRaum(Raum raum, int uhrzeit, int wochentag, String name) {
       raum.setBuchung(uhrzeit, wochentag, name);
    }

        /**
         *
         * @param raum
         * @param uhrzeit Uhrzeit im Format 0-17 (siehe ReadMe)
         * @param wochentag Wochentag im Format 0-6 (siehe ReadMe)
         */
    @Override
    public void storniereRaum(Raum raum, int uhrzeit, int wochentag) {
        raum.kalender[uhrzeit][wochentag]=null;
    }

}
