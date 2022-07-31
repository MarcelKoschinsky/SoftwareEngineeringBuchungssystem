package src.Raumbuchungssystem.Objekte;
/**
 *@author Murat Dursun, Janik Lüttringhaus
 */
public class User {

    private String name,email;
    private int id;
    private String passwort; //Sollte in der Zukunft gegen etwas Sichereres getauscht werden

    public User (String name, int passwort, String id) {
        setName(name);
        setPasswort(passwort);
        setId(id);
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getEmail() {
        return email;
    }
}
