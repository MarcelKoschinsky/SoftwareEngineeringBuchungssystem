package src.Raumbuchungssystem.Logik;

import org.junit.jupiter.api.Test;
import src.Raumbuchungssystem.Datenbank.RaumPersistenceDummy;
import src.Raumbuchungssystem.Objekte.Raum;
//import src.Raumbuchungssystem.GUI.Main;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse für den Raummanager
 *
 * @author Murat Dursun, Janik Lüttringhaus
 */
public class RaumManagerTest {

        IRaumManager raumManager = new RaumManager();

        @Test
        public void listeRaeumeTest(){
            assertNull(raumManager.listeAlleRaeume());
        }

        @Test
        public void bucheRaumTest(){
        raumManager.bucheRaum(101, 0, 0, "ABC");
        raumManager.bucheRaum(101, 0, 0, "ABC");
        String[][] expected = new String[18][7];
        expected[0][0] = "ABC";
    }
}
