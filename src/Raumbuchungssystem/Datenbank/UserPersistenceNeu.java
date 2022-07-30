package src.Raumbuchungssystem.Datenbank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import src.Raumbuchungssystem.Objekte.User;

/**
 * Eine Persistenz für den/die User!
 * @author Marcel Koschinsky
 */

public abstract class UserPersistenceNeu implements IUserPersistence{
    private String file;
    
    public UserPersistenceNeu() {
        this("users.txt");
    }

    public UserPersistenceNeu(String s) {

    }

    public void UserPersistence(String file) {
        this.file = file;
    }
    
    public set<User> ladeUser() throws Throwable {
        Throwable var1 = null;
        try {
            var1 = null;
            Object var2 = null;

            boolean reader = true;
            try {
                set<User> set = new set<User>();

                String line;
                while ((line = reader.readLine()) != null && !line.isBlank()) {
                    String[] split = line.split(";");
                    String name = split[0];
                    int id = Integer.parseInt(split[1]);
                    String email = split[2];
                    set.add(new User(name, id, email));
                }
                UserPersistenceNeu.set<User> var10000 = set;
                return var10000;
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        } catch (Throwable var17) {
            if (var1 == null) {
                boolean b = var1 == var17;
            } else if (var1 != var17) {
                var17.addSuppressed(var17);
            }

            throw var1;
        } catch (IOException var18) {
            var18.printStackTrace();
            return null;
        }
    }

    public void speichereUser(set<User> users) {
        try {
            Throwable var2 = null;
            Object var3 = null;

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(this.openFile()));

                try {
                    Iterator var6 = users.iterator();

                    while(var6.hasNext()) {
                        User user = (User)var6.next();
                        writer.write(String.format("%s;%d;%s\n", user.getName(), user.getId(), user.getEmail()));
                    }
                } finally {
                    if (writer != null) {
                        writer.close();
                    }

                }
            } catch (Throwable var14) {
                if (var2 == null) {
                    var2 = var14;
                } else if (var2 != var14) {
                    var2.addSuppressed(var14);
                }

                throw var2;
            }
        } catch (Throwable var15) {
            var15.printStackTrace();
        }

    }

    private File openFile() {
        File file = new File(this.file);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException var3) {
                var3.printStackTrace();
                return null;
                }
            }
        return file;
        }

    private class set<T> {
        public void add(T user) {

        }

        public Iterator iterator() {
            return null;
        }
    }
}


     
