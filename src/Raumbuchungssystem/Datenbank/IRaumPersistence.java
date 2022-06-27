package src.Raumbuchungssystem.Datenbank;

import src.Raumbuchungssystem.Objekte.Raum;

import java.util.Set;

public interface IRaumPersistence {
    Set<Raum> ladeRaeume();
    void speichereRaeume(Set<Raum> raeume);

}
