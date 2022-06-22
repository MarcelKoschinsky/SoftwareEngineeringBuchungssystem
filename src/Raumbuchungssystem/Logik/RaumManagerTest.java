package src.Raumbuchungssystem.Logik;

import org.junit.jupiter.api.Test;
import src.Raumbuchungssystem.GUI.Main;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaumManagerTest {

        IRaumManager raumManager = new RaumManager();

        @Test
        public void listeRaeumeTest(){
            assertEquals(null, raumManager.listeAlleRaeume());
        }

        @Test
        public void bucheRaum(){
        assertEquals(null, raumManager.listeAlleRaeume());
    }
}
