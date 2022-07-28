package src.Raumbuchungssystem.Datenbank;

import src.Raumbuchungssystem.Objekte.Raum;

import java.util.HashSet;
import java.util.Set;

/**
 * Eine Dummy-RaumPersistence zu Testzwecken
 *
 * @author Janik Lüttringhaus
 */
public class RaumPersistenceDummy implements IRaumPersistence {

    static Set<Raum> raumset = new HashSet<>();

    /**
     * Der Konstruktor.
     * Generiert 5 Räume und fügt diese dem HashSet hinzu
     */
    public RaumPersistenceDummy() {
        erstelleRaum(101, "Seminarraum");
        erstelleRaum(102, "Seminarraum");
        erstelleRaum(103, "Seminarraum");
        erstelleRaum(104, "Seminarraum");
        erstelleRaum(105, "Labor");
    }

    /**
     * Erstellt einen neuen Raum und fügt diesen dem HashSet des Dummys hinzu.
     * @param raumNr Raumnummer
     * @param raumArt Art des Raumes
     */
    public void erstelleRaum(int raumNr, String raumArt) {
            raumset.add(new Raum(raumNr, raumArt));
    }

    /**
     * @return HashSet mit allen Räumen
     */
    @Override
    public Set<Raum> ladeRaeume() {
        return raumset;
    }

    /**
     * @param raeume Das überarbeitete HashSet mit allen Räumen
     */
    @Override
    public  void speichereRaeume(Set<Raum> raeume) {
        raumset=raeume;
    }
}
