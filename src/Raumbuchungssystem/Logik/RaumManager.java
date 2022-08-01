package src.Raumbuchungssystem.Logik;

import src.Raumbuchungssystem.Datenbank.IRaumPersistence;
import src.Raumbuchungssystem.Datenbank.RaumPersistenceDummy;
import src.Raumbuchungssystem.Datenbank.RaumPersistence;
import src.Raumbuchungssystem.Objekte.Raum;

import java.util.HashSet;
import java.util.Set;

/**
 * Der RaumManager verwaltet die Räume inkl. Raumbuchungen
 *
 * @author Janik Lüttringhaus
 */
public class RaumManager implements IRaumManager {

    //IRaumPersistence raumPersistence=new RaumPersistence(); //Nach Bedarf auskommentieren. Echte Persistence ist Stand 1. August 18:47 unzuverlässig
    IRaumPersistence raumPersistence=new RaumPersistenceDummy(); //Nach Bedarf auskommentieren. Echte Persistence ist Stand 1. August 18:47 unzuverlässig

    /**
     * @return Alle Räume
     */
    @Override
    public Set<Raum> listeAlleRaeume() {
        return raumPersistence.ladeRaeume();
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
        Set<Raum> temp = raumPersistence.ladeRaeume();
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
        Set<Raum> temp = raumPersistence.ladeRaeume();

        String rueckgabe="";

        for (Raum x : temp) {
            if (x.getRaumNr() == raumNr) {
                if (x.kalender[uhrzeit][wochentag] == null) {
                    x.setBuchung(uhrzeit, wochentag, name);
                    rueckgabe="Gebucht: Raum: "+x.getRaumNr()+", Art: "+x.getRaumArt()+", Wochentag: "+wochentag+", Uhrzeit: "+uhrzeit;
                } else {
                    rueckgabe="Der gewünschte Termin ist bereits vergeben.";
                }
            }
        }

        if (rueckgabe.equals("")) {
            rueckgabe="Der gewünschte Raum ("+raumNr+") existiert nicht.";
        }

        raumPersistence.speichereRaeume(temp);
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
        Set<Raum> temp = raumPersistence.ladeRaeume();
        String rueckgabe="";

        for (Raum x : temp) {
            if (x.getRaumNr() == raumNr) {
                if (x.kalender[uhrzeit][wochentag] != null) {
                    x.kalender[uhrzeit][wochentag] = null;
                    rueckgabe= "Raumbuchung storniert. Raumnr.: "+raumNr+" Tag: "+wochentag+" Uhrzeit: "+uhrzeit;
                } else {
                    rueckgabe="Keine Buchung für Raum "+raumNr+" zum Zeitpunkt "+uhrzeit+" am Tag "+wochentag;
                }
            }
        }

        if (rueckgabe.equals("")) {
            rueckgabe="Der gewünschte Raum ("+raumNr+") existiert nicht.";
        }

        raumPersistence.speichereRaeume(temp);
        return rueckgabe;
    }

    /**
     *
     * @param raumNr Die gewünschte Raumnummer
     * @return Der Raum mit der gewünschten Raumnummer; Null, wenn der Raum nicht existiert.
     */
    @Override
    public Raum getRaum(int raumNr) {
        Set<Raum> temp = raumPersistence.ladeRaeume();

        for (Raum x : temp) {
            if (x.getRaumNr() == raumNr) {
                return x; //Raum gefunden
            }
        }

        return null; //Raum nicht gefunden
    }
}
