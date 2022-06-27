/**
 * @author Janik Lüttringhaus
 */

package src.Raumbuchungssystem.Objekte;

public class Raum {

    private int raumNr;
    private String raumArt;
    public String[][] kalender=new String[18][7];

    public Raum (int raumNr, String raumArt) {
        this.raumNr=raumNr;
        this.raumArt=raumArt;
    }

    public void setRaumNr(int raumNr) { this.raumNr = raumNr; }

    public int getRaumNr() {
        return raumNr;
    }

    public void setRaumArt(String raumArt) {
        this.raumArt = raumArt;
    }

    public String getRaumArt() {
        return raumArt;
    }

    public String getReservation() {return null;}
}
