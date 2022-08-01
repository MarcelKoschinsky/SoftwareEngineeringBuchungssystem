package src.Raumbuchungssystem.Logik;

import src.Raumbuchungssystem.Objekte.User;

/**
 * @author Murat Dursun
 */

public interface IUserManager {

    public void erstelleUser(String name, String passwort); //Methode ohne implementierung erstelleUser

    public void loescheUser(int id);

    public User loginUser(int id, String passwort);

}
