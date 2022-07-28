package src.Raumbuchungssystem.GUI;

import src.Raumbuchungssystem.Logik.IRaumManager;
import src.Raumbuchungssystem.Logik.RaumManager;
import src.Raumbuchungssystem.Objekte.Raum;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Set;
/**
 * UI des Raumbuchungssystems
 * Nimmt Nutzereingaben und gibt sie an bucheRaum weiter
 * @author Murat Dursun
 */
public class Main implements ActionListener {

    IRaumManager raumManager = new RaumManager();   //neuen RaumManager erstellt

    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwortLabel;
    private static JTextField passwortText;
    private static JLabel raumNrLabel;
    private static JTextField raumNrText;
    private static JLabel uhrzeitLabel;
    private static JTextField uhrzeitText;
    private static JLabel wochentagLabel;
    private static JTextField wochentagText;
    private static JButton button1;
    private static JButton button2;
    private static JLabel ergebnisLabel;
    private static int raumNr, uhrzeit, wochentag;
    private static String passwort;


    //Storniere Knopf – von Janik
    private static JButton button3;

    public static void main(String[] args) {

        IRaumManager raumManager = new RaumManager();   //neuen RaumManager erstellt

        Set<Raum> raeume = raumManager.listeAlleRaeume();//erstelle eine liste aller Raeume

        System.out.println(raeume);     //gib die Raeume auf der Konsole aus

        //Eingabefenster
        JPanel panel = new JPanel(new GridLayout(1, 2));
        JFrame frame = new JFrame("Raumbuchungssystem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 800);
        frame.add(panel);

        panel.setLayout(null);

        //Benutzereingabe
        userLabel = new JLabel("Benutzer");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        //Passworteingabe
        passwortLabel = new JLabel("Passwort");
        passwortLabel.setBounds(10, 50, 80, 25);
        panel.add(passwortLabel);

        passwortText = new JPasswordField();
        passwortText.setBounds(100, 50, 165, 25);
        panel.add(passwortText);

        //Eingabe der RaumNr
        raumNrLabel = new JLabel("Raum Nr.");
        raumNrLabel.setBounds(10, 80, 80, 25);
        panel.add(raumNrLabel);

        raumNrText = new JTextField(20);
        raumNrText.setBounds(100, 80, 165, 25);
        panel.add(raumNrText);


        //Eingabe der Uhrzeit
        uhrzeitLabel = new JLabel("Uhrzeit");
        uhrzeitLabel.setBounds(10, 110, 80, 25);
        panel.add(uhrzeitLabel);

        uhrzeitText = new JTextField(20);
        uhrzeitText.setBounds(100, 110, 165, 25);
        panel.add(uhrzeitText);


        //Eingabe des Wochentages
        wochentagLabel = new JLabel("Wochentag");
        wochentagLabel.setBounds(10, 140, 80, 25);
        panel.add(wochentagLabel);

        wochentagText = new JTextField(20);
        wochentagText.setBounds(100, 140, 165, 25);
        panel.add(wochentagText);


        //Anmelden Knopf
        button1 = new JButton("Buchen");
        button1.setBounds(10, 170, 100, 25);
        panel.add(button1);
        button1.addActionListener(new Main());

        //Abbrechen Knopf
        button2 = new JButton("Abbrechen");
        button2.setBounds(230, 170, 100, 25);
        panel.add(button2);
        button2.addActionListener(e -> {frame.dispose();});

        //Stornieren Knopf – von Janik
        button3 = new JButton("Stornieren");
        button3.setBounds(120, 170, 100, 25);
        panel.add(button3);
        button3.addActionListener(new Main());

        //Ergebnis Label
        ergebnisLabel = new JLabel("");
        ergebnisLabel.setBounds(10, 210, 500, 25);
        panel.add(ergebnisLabel);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Funktion des "Anmelden"-Knopfes
        if (e.getSource() == button1) {

            //Die Parse-Operationen mussten hierher verschoben werden, weil es sonst NullPointerExceptions gab.   \Janik
            raumNr = Integer.parseInt(raumNrText.getText());
            uhrzeit = Integer.parseInt(uhrzeitText.getText());
            wochentag = Integer.parseInt(wochentagText.getText());

            if (passwortText.getText().equals("1234")) {
                ergebnisLabel.setText(raumManager.bucheRaum(raumNr, uhrzeit, wochentag, userText.getText()));
            }else{
                ergebnisLabel.setText("Passwort inkorrekt");
            }
        }

        //Funktion des "Stornieren"-Knopfes
        if (e.getSource() == button3) {
            raumNr = Integer.parseInt(raumNrText.getText());
            uhrzeit = Integer.parseInt(uhrzeitText.getText());
            wochentag = Integer.parseInt(wochentagText.getText());

            if (passwortText.getText().equals("1234")) {
                ergebnisLabel.setText(raumManager.storniereRaum(raumNr, uhrzeit, wochentag));
            }else{
                ergebnisLabel.setText("Passwort inkorrekt");
            }
        }
    }

}
