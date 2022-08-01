package src.Raumbuchungssystem.Logik;


import src.Raumbuchungssystem.Datenbank.RaumPersistence;
import src.Raumbuchungssystem.Objekte.Raum;

import java.util.HashSet;
import java.util.Set;

/**
 * Generiert Räume für die RaumPersistence für das erstmalige Setup. Ist bereits eine raeume.txt mit Einträgen vorhanden kann diese Klasse ignoriert werden.
 * Kann außerdem verwendet werden, um ein bestehendes Datenset der Persistence zu überschreiben
 * @author Janik Lüttringhaus
 */
public class RaumGenerator {
    static RaumPersistence raumPersistence=new RaumPersistence();

    static Set<Raum> generierteRaeume = new HashSet<>();

    public static void main(String[]args) {
        for (int i = 0; i < 20; i++) {
            generierteRaeume.add(new Raum(101+i, "Seminarraum"));
        }
        raumPersistence.speichereRaeume(generierteRaeume);
    }
}
