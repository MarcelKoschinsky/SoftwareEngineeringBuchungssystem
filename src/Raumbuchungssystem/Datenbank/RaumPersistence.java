package src.Raumbuchungssystem.Datenbank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import src.Raumbuchungssystem.Objekte.Raum;

/**
 * Eine Persistenz für die Räume
 * @author Marcel
 */

public class RaumPersistence implements IRaumPersistence{

    private final String file;

    public RaumPersistence() {this("raeume.txt"); }

    public RaumPersistence(String file) {
        this.file = file;
    }

    @Override
    public Set<Raum> ladeRaeume() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.openFile()))) {
            Set<Raum> set = new HashSet<>();
            Raum raum;
            while((raum = this.ladeRaum(reader)) != null)
                set.add(raum);
            return set;
        }  catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Raum ladeRaum(BufferedReader reader) throws IOException{
        //Versuche einen Raum zu laden
        //wenn die Zeile leer ist, gibt es keine weiteren Räume
        String line = reader.readLine();
        if(line.isBlank())
            return null;

        //Lade RaumNr und RaumArt
        //werden in einer Zeile getrennt und durch ";" gespeichert
        String [] split = line.split(";");
        int raumNr = Integer.parseInt(split[0]);
        String raumArt = split[1];
        Raum raum = new Raum(raumNr, raumArt);

        //Diese Zeilen enthalten alle Buchungen
        //Format: Name; Uhrzeit; Wochentag
        while ((line = reader.readLine()) != null && !line.isBlank()) {
             //Fängt Zeile mit "-" an, bedeutet das, dass der Eintrag beendet ist
            if (line.startsWith("-"))
                break;

            split = line.split(";");
            String name = split[0];
            int uhrzeit = Integer.parseInt(split[1]);
            int wochentag = Integer.parseInt(split[2]);
            raum.setBuchung(uhrzeit, wochentag, name);
        }

        return raum;
    }

    @Override
    public void speichereRaeume(Set<Raum> raeume) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.openFile()))){
            for (Raum raum : raeume) {
                this.speichereRaum(raum, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void speichereRaum(Raum raum, BufferedWriter writer) throws IOException {
        // speichere RaumNr und RaumArt
        writer.write(String.format("%d;%s\n", raum.getRaumNr(), raum.getRaumArt()));

        // speichere buchungen des raumes
        for (int uhrzeit = 0; uhrzeit < 18; uhrzeit++) {
            for (int wochentag = 0; wochentag < 7; wochentag++) {
                String name = raum.kalender[uhrzeit][wochentag];
                // wenn zu diesem zeitpunk keine buchung vermerkt wurde
                // wird auch nichts in die datei geschrieben
                if (name != null) {
                    writer.write(String.format("%s;%d;%d", name, uhrzeit, wochentag));
                }
            }
        }

        writer.write("-\n");
    }

    private File openFile() {
        File file = new File(this.file);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return file;
    }

}
