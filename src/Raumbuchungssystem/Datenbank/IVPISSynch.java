package src.Raumbuchungssystem.Datenbank;

import src.Raumbuchungssystem.Objekte.Raum;
import java.util.Set;


//@author Marcel
// Interface für die VPIS Synchronisierung
public interface IVPISSynch {



    public Set<Raum> ladeBelegteRaeume();



}
