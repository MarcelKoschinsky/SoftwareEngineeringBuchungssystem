package src.Raumbuchungssystem.Datenbank;

import src.Raumbuchungssystem.Objekte.User;

import java.util.Set;


/**
 * Eine User Persistence
 *
 * @author Marcel Koschinsky
 */
public interface IUserPersistence {
    Set<User> ladeUser() throws Throwable;
    void speichereUser(Set<User> users);

}
