package src.Raumbuchungssystem.Datenbank;

import src.Raumbuchungssystem.Objekte.User;

import java.util.Set;
import src.Raumbuchungssystem.Objekte.User;



/**
 * Eine User Persistence
 *
 * @author Marcel Koschinsky
 */
public interface IUserPersistence {
    Set<User> ladeUser();
    void speichereUser(Set<User> users);

}
