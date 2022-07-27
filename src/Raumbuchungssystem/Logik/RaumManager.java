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
        Set<Raum> rueckgabe = new HashSet<>();

        //Freie Räume zu Uhrzeit und Wochentag suchen
        for (Raum x : temp) {
            if (x.kalender[uhrzeit][wochentag] == null) {
                rueckgabe.add(x);
            }
        }


        return rueckgabe;
    }

    /**
     * Ein Raum wird zu einem bestimmten Zeitpunkt gebucht.
     * Über die Rückgabe wird dieser Buchungsvorgang bestätigt, oder mit einer Fehlermeldung abgebrochen.
     *
     * @param raumNr    Die Raumnummer
     * @param uhrzeit   Uhrzeit im Format 0-17 (siehe ReadMe)
     * @param wochentag Wochentag im Format 0-6 (siehe ReadMe)
     * @param name      Name der buchenden Person
     * @return Eine Bestätigung oder Fehlermeldung
     */
    @Override
    public String bucheRaum(int raumNr, int uhrzeit, int wochentag, String name) {
        Set<Raum> temp = RaumPersistenceDummy.ladeRaeume();
        String rueckgabe="";

        for (Raum x : temp) {
            if (x.getRaumNr() == raumNr) {
                if (x.kalender[uhrzeit][wochentag] == null) {
                    x.setBuchung(uhrzeit, wochentag, name);
                    rueckgabe="Der gewünschte Termin wurde von dir gebucht.\n Raum:"+x.getRaumNr()+" Wochentag: "+wochentag+" Uhrzeit: "+uhrzeit;
                } else {
                    rueckgabe="Der gewünschte Termin ist bereits vergeben.";
                }
            }
        }

        //RaumPersistenceDummy.speichereRaeume(temp)
        return rueckgabe;
    }

    /**
     * Eine Raumbuchung wird storniert.
     * Über die Rückgabe wird diese Stornierung bestätigt, oder mit einer Fehlermeldung abgebrochen.
     *
     * @param raumNr    Die Raumnummer
     * @param uhrzeit   Uhrzeit im Format 0-17 (siehe ReadMe)
     * @param wochentag Wochentag im Format 0-6 (siehe ReadMe)
     * @return Eine Bestätigung oder Fehlermeldung
     */
    @Override
    public String storniereRaum(int raumNr, int uhrzeit, int wochentag) {
        Set<Raum> temp = RaumPersistenceDummy.ladeRaeume();
        String rueckgabe="";

        for (Raum x : temp) {
            if (x.getRaumNr() == raumNr) {
                if (x.kalender[uhrzeit][wochentag] != null) {
                    x.kalender[uhrzeit][wochentag] = null;
                    rueckgabe="Die Raumbuchung wurde storniert. Raumnr.: "+raumNr+" Tag: "+wochentag+" Uhrzeit: "+uhrzeit;
                } else {
                    rueckgabe="Für diesem Raum gibt es zu diesem Zeitpunkt keine Buchung.";
                }
            }
        }
        return rueckgabe;
    }
}
