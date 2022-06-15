package src.Raumbuchungssystem.Logik;

import src.Raumbuchungssystem.Objekte.Raum;

import java.util.Set;

//@author Janik Lüttringhaus

public interface IRaumManager {
    Set<Raum> listeAlleRaeume();

    Set<Raum> listeFreieRaeume();

    void bucheRaum(Raum raum, int uhrzeit, int wochentag);

    void storniereRaum(Raum raum, int uhrzeit, int wochentag);
}

