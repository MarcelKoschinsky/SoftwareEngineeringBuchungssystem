package src.Raumbuchungssystem.Logik;

/**
 * @author Murat Dursun
 */

public interface IUserManager {


    public void erstelleUser(String name, int id, String email); //Methode ohne implementierung erstelleUser

    public void loescheUser(int id);

    public void loginUser(int id, String passwort);

}
