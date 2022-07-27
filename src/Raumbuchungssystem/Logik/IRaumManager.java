
package src.Raumbuchungssystem.Logik;

import src.Raumbuchungssystem.Objekte.Raum;

import java.util.Set;

/**
 * Das Interface für den RaumManager
 *
 * @author Janik Lüttringhaus
 */
public interface IRaumManager {
    Set<Raum> listeAlleRaeume();

    Set<Raum> listeFreieRaeume(int uhrzeit, int wochentag);

    String bucheRaum(int raumNr, int uhrzeit, int wochentag, String name);

    void storniereRaum(int raumNr, int uhrzeit, int wochentag);
}

