package src.Raumbuchungssystem.Logik;

import src.Raumbuchungssystem.Objekte.Raum;

import java.util.Set;

//@author Janik Lüttringhaus

public interface IRaumManager {
    public Set<Raum> listeAlleRaeume();

    public Set<Raum> listeFreieRaeume();

    public void bucheRaum(Raum raum, int uhrzeit, int wochentag);

    public void storniereRaum(Raum raum, int uhrzeit, int wochentag);
}

