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
     * @return Alle Räume
     */
    @Override
    public Set<Raum> listeAlleRaeume() {
        return RaumPersistenceDummy.ladeRaeume();
    }

    /**
     * Gibt alle freien Räume als HashSet zurück.
     *
     * @param uhrzeit   Uhrzeit im Format 0-17 (siehe ReadMe)
     * @param wochentag Wochentag im Format 0-6 (siehe ReadMe)
     * @return Alle freien Räume als HashSet
     */
    @Override
    public Set<Raum> listeFreieRaeume(int uhrzeit, int wochentag) {
        Set<Raum> temp = RaumPersistenceDummy.ladeRaeume();
        Set<Raum> ausgabe = new HashSet<>();

        for (Raum x : temp) {
            if (x.kalender[uhrzeit][wochentag] == null) {
                ausgabe.add(x);
            }
        }


        return ausgabe;
    }

    /**
     * Ein Raum wird zu einem bestimmten Zeitpunkt gebucht.
     * Über die Konsole wird dieser Buchungsvorgang bestätigt, oder mit einer Fehlermeldung abgebrochen.
     *
     * @param raumNr    Die Raumnummer
     * @param uhrzeit   Uhrzeit im Format 0-17 (siehe ReadMe)
     * @param wochentag Wochentag im Format 0-6 (siehe ReadMe)
     * @param name      Name der buchenden Person
     */
    @Override
    public void bucheRaum(int raumNr, int uhrzeit, int wochentag, String name) {
        Set<Raum> temp = RaumPersistenceDummy.ladeRaeume();

        for (Raum x : temp) {
            if (x.getRaumNr() == raumNr) {
                if (x.kalender[uhrzeit][wochentag] == null) {
                    x.setBuchung(uhrzeit, wochentag, name);
                    System.out.println("Der gewünschte Termin wurde von dir gebucht.");
                } else {
                    System.out.println("Der gewünschte Termin ist bereits vergeben.");
                }
            }
        }
    }

    /**
     * Eine Raumbuchung wird storniert.
     * Über die Konsole wird diese Stornierung bestätigt, oder mit einer Fehlermeldung abgebrochen.
     *
     * @param raumNr Die Raumnummer
     * @param uhrzeit   Uhrzeit im Format 0-17 (siehe ReadMe)
     * @param wochentag Wochentag im Format 0-6 (siehe ReadMe)
     */
    @Override
    public void storniereRaum(int raumNr, int uhrzeit, int wochentag) {
        Set<Raum> temp = RaumPersistenceDummy.ladeRaeume();

        for (Raum x : temp) {
            if (x.getRaumNr() == raumNr) {
                if (x.kalender[uhrzeit][wochentag] != null) {
                    x.kalender[uhrzeit][wochentag] = null;
                    System.out.println("Die Raumbuchung wurde storniert.");
                } else {
                    System.out.println("Für diesem Raum gibt es zu diesem Zeitpunkt keine Buchung.");
                }
            }
        }

    }
}
