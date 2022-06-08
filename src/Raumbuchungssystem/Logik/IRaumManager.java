package src.Raumbuchungssystem.Logik;

import src.Raumbuchungssystem.Objekte.Raum;

import java.util.Set;

//@author Janik Lüttringhaus

public interface IRaumManager {
    public Set<Raum> listeAlleRaeume();

    public Set<Raum> listeFreieRaeume();

    public void bucheRaum(int raumNr, String uhrzeit, String wochentag);

    public void storniereRaum(int raumNr, String uhrzeit, String wochentag);
}
