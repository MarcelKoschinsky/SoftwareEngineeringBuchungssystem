package src.Raumbuchungssystem.Datenbank;

import src.Raumbuchungssystem.Objekte.Raum;

import java.io.BufferedWriter;
import java.util.Set;

/**
 * @author Marcel Koschinsky
 */
public interface IRaumPersistence {
    Set<Raum> ladeRaeume();
    void speichereRaeume(Set<Raum> raeume);

    void speichereRaeume(Set<Raum> raeume, BufferedWriter writer);

}
