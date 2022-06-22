/**
 * @author Janik Lüttringhaus
 */

package src.Raumbuchungssystem.Objekte;

public class Raum {

    private String raumNr;
    private String raumArt;
    public boolean[][] kalender=new boolean[20][6];

    public Raum (String raumNr, String raumArt) {
        this.raumNr=raumNr;
        this.raumArt=raumArt;
    }

    public void setRaumNr(String raumNr) { this.raumNr = raumNr; }

    public String getRaumNr() {
        return raumNr;
    }

    public void setRaumArt(String raumArt) {
        this.raumArt = raumArt;
    }

    public String getRaumArt() {
        return raumArt;
    }
}
