/**
 * @author Janik Lüttringhaus
 */
package src.Raumbuchungssystem.Logik;

import src.Raumbuchungssystem.Objekte.Raum;
import src.Raumbuchungssystem.Objekte.User;

import java.util.Set;


public interface IRaumManager {
    public Set<Raum> listeAlleRaeume();

    public Set<Raum> listeFreieRaeume();

    public void bucheRaum(Raum raum, int uhrzeit, int wochentag, User user);

    public void storniereRaum(Raum raum, int uhrzeit, int wochentag);
}

