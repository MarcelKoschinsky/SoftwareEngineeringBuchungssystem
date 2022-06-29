package src.Raumbuchungssystem.Logik;

import org.junit.jupiter.api.Test;
//import src.Raumbuchungssystem.GUI.Main;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        public void bucheRaum(){
        //assertEquals(null, raumManager.bucheRaum());
    }
}
