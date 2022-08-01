package src.Raumbuchungssystem.Logik;

import org.junit.jupiter.api.Test;
import src.Raumbuchungssystem.Objekte.Raum;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse für den Raummanager
 *
 * @author Janik Lüttringhaus
 */
public class RaumManagerTest {

        RaumManager raumManager = new RaumManager();

        @Test
        public void getRaumTest() {
            Raum expectedR101 = new Raum(101,"Seminarraum"); //Raum mit erwarteten Attributen
            Raum actualR101 = raumManager.getRaum(101); //Geladener Raum
            assertEquals(expectedR101.getRaumNr(),actualR101.getRaumNr()); //Vergleich der Raumnummern
            assertEquals(expectedR101.getRaumArt(),actualR101.getRaumArt()); //Vergleich der Raumart

            Raum expectedR110 = new Raum(110,"Labor"); //Raum mit erwarteten Attributen
            Raum actualR110 = raumManager.getRaum(110); //Geladener Raum
            assertEquals(expectedR101.getRaumNr(),actualR101.getRaumNr()); //Vergleich der Raumnummern
            assertEquals(expectedR101.getRaumArt(),actualR101.getRaumArt()); //Vergleich der Raumart

            assertNull(raumManager.getRaum(200)); //Raum existiert nicht im System
        }

        @Test
        public void bucheRaumTest(){
            String buchungMessage = raumManager.bucheRaum(101, 3, 4, "ABC"); //Raum wird gebucht, Rückgabe zwischengespeichert
            String buchungMessage2 = raumManager.bucheRaum(101, 3, 4, "ABC"); //Doppelbuchung
            String expectedMessage = "Gebucht: Raum: 101, Art: Seminarraum, Wochentag: 4, Uhrzeit: 3"; //Erwartete Rückgabe
            String expectedMessage2 = "Der gewünschte Termin ist bereits vergeben."; //Erwartete Rückgabe für Doppelbuchung
            assertEquals(expectedMessage,buchungMessage); //Rückgabe wird geprüft
            assertEquals(expectedMessage2,buchungMessage2); //Rückgabe wird geprüft
            String expectedBuchung="ABC"; //Erwarteter Buchungstext im Kalender
            Raum r101=raumManager.getRaum(101); //Der betreffende Raum, um die Buchung abzufragen
            String actualBuchung=r101.getBuchung(3,4); //Die tatsächliche Buchung
            assertEquals(expectedBuchung,actualBuchung);

            buchungMessage = raumManager.bucheRaum(201, 3, 4, "ABC"); //Versuch nicht-existierenden Raum zu buchen
            expectedMessage = "Der gewünschte Raum (201) existiert nicht."; //Erwartete Rückgabe
            assertEquals(expectedMessage,buchungMessage); //Rückgabe wird geprüft
        }

        @Test
        public void storniereRaumTest(){
            String stornierungMessage = raumManager.storniereRaum(101, 3, 4); //Keine Buchung, Versuch zu stornieren. Rückgabe zwischengespeichert
            String expectedMessage = "Keine Buchung für Raum 101 zum Zeitpunkt 3 am Tag 4"; //Erwartete Rückgabe
            assertEquals(expectedMessage,stornierungMessage); //Rückgabe wird geprüft

            raumManager.bucheRaum(101, 3, 4, "ABC"); //Raum wird gebucht

            stornierungMessage = raumManager.storniereRaum(101, 3, 4); //Buchung wird storniert, Rückgabe zwischengespeichert
            expectedMessage = "Raumbuchung storniert. Raumnr.: 101 Tag: 4 Uhrzeit: 3"; //Erwartete Rückgabe
            assertEquals(expectedMessage,stornierungMessage); //Rückgabe wird geprüft
            Raum r101=raumManager.getRaum(101); //Der betreffende Raum, um die Buchung abzufragen
            assertNull(r101.kalender[3][4]); //Ist der betreffende Kalendereintrag leer, also null?

            stornierungMessage = raumManager.storniereRaum(201, 3, 4); //Versuch nicht-existierenden Raum zu stornieren
            expectedMessage = "Der gewünschte Raum (201) existiert nicht."; //Erwartete Rückgabe
            assertEquals(expectedMessage,stornierungMessage); //Rückgabe wird geprüft
        }
}
