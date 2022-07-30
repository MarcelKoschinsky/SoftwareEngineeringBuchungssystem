package src.Raumbuchungssystem.Datenbank;

import src.Raumbuchungssystem.Objekte.Raum;
import java.util.Set;

/**
 * @author Marcel Koschinsky
 */
public interface IRaumPersistence {
    Set<Raum> ladeRaeume();
    void speichereRaeume(Set<Raum> raeume);

}
