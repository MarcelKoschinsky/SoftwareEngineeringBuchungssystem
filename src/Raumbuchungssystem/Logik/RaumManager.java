/**
 * @author Janik Lüttringhaus
 */

package src.Raumbuchungssystem.Logik;

import src.Raumbuchungssystem.Objekte.Raum;
import src.Raumbuchungssystem.Objekte.User;

import java.util.Set;

public class RaumManager implements IRaumManager{

/*    Set<Raum>=
    private */


    @Override
    public Set<Raum> listeAlleRaeume() {
        return null;
    }

    @Override
    public Set<Raum> listeFreieRaeume(int uhrzeit, int wochentag) {
        return null;
    }

    @Override
    public void bucheRaum(Raum raum, int uhrzeit, int wochentag, String name) {
       raum.kalender[uhrzeit][wochentag]=name;
    }

    @Override
    public void storniereRaum(Raum raum, int uhrzeit, int wochentag) {
        raum.kalender[uhrzeit][wochentag]=null;
    }

}
