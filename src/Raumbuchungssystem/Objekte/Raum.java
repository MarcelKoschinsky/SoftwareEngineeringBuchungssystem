package src.Raumbuchungssystem.Objekte;

/**
 * Ein Raum als Objekt
 *
 * @author Janik Lüttringhaus
 */
public class Raum {

    /**
     * Die Raumnummer
     */
    private int raumNr;
    /**
     * Die Art des Raumes, z.B. Hörsaal, Seminarraum, Labor, etc.
     */
    private String raumArt;
    /**
     * Der Kalender speichert die Belegung des Raumes.
     * Zunächst in Form eines Strings.
     * <p>
     * Die erste Dimension des Arrays stellt hierbei einen 30min-Block dar.
     * Bsp.: 0 = 08.00-08.30
     *       7 = 11.30-12.00
     */
    public String[][] kalender=new String[18][7];

    /**
     * Konstruktor
     * @param raumNr Raumnummer
     * @param raumArt Art des Raumes
     */
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

    /**
     * Dem Kalender wird eine Buchung hinzugefügt.
     *
     * @param uhrzeit Uhrzeit im Format 0-17 (siehe ReadMe)
     * @param wochentag Wochentag im Format 0-6 (siehe ReadMe)
     * @param name Name der buchenden Person
     */
    public void setBuchung(int uhrzeit, int wochentag, String name) {
        this.kalender[uhrzeit][wochentag]=name;
    }

    /**
     * Gibt den Buchungsstatus zu einer bestimmten Zeit zurück.
     *
     * @param uhrzeit Uhrzeit im Format 0-17 (siehe ReadMe)
     * @param wochentag Wochentag im Format 0-6 (siehe ReadMe)
     * @return Wenn gebucht: Name der Person, des Moduls, o.ä. <p> Wenn nicht gebucht: Hinweis, noch frei
     */
    public String getBuchung(int uhrzeit, int wochentag) {
        if (kalender[uhrzeit][wochentag] != null) {
            return kalender[uhrzeit][wochentag];
        } else {
            return "Zu dieser Zeit gibt es noch keine Buchung";
        }
    }
}

