package src.Raumbuchungssystem.GUI;

/*
UI des Raumbuchungssystems
Nimmt Nutzereingaben und gibt sie an bucheRaum weiter
@Author Murat Dursun
 */

import src.Raumbuchungssystem.Logik.IRaumManager;
import src.Raumbuchungssystem.Logik.RaumManager;
import src.Raumbuchungssystem.Objekte.Raum;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Set;

public class Main implements ActionListener {

    IRaumManager raumManager = new RaumManager();   //neuen RaumManager erstellt

    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwortLabel;
    private static JTextField passwordText;
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

    public static void main(String[] args) {

        IRaumManager raumManager = new RaumManager();   //neuen RaumManager erstellt

        Set<Raum> raeume = raumManager.listeAlleRaeume();//erstelle eine liste aller Raeume

        System.out.println(raeume);     //gib die Raeume auf der Konsole aus

        /*
        //Scanner für das GUI
        Scanner sc = new Scanner(System.in);

        System.out.println("Bitte geben Sie Ihren Namen ein: ");
        String name = sc.nextLine();

        System.out.println("Bitte geben Sie Ihre gewuenschte RaumNr ein: ");
        String raumNrString = sc.nextLine();
        int raumNr = Integer.parseInt(raumNrString);

        System.out.println("Bitte geben Sie Ihren gewuenschten Wochentag ein: ");
        String wochentagString = sc.nextLine();
        int wochentag = Integer.parseInt(wochentagString);

        System.out.println("Bitte geben Sie Ihre gewuenschte Uhrzeit ein: ");
        String uhrzeitString = sc.nextLine();
        int uhrzeit = Integer.parseInt(uhrzeitString);
         */

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

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        //Eingabe der RaumNr
        raumNrLabel = new JLabel("Raum Nr.");
        raumNrLabel.setBounds(10, 80, 80, 25);
        panel.add(raumNrLabel);

        raumNrText = new JTextField(20);
        raumNrText.setBounds(100, 80, 165, 25);
        panel.add(raumNrText);
        raumNr = Integer.parseInt(raumNrText.getText());

        //Eingabe der Uhrzeit
        uhrzeitLabel = new JLabel("Uhrzeit");
        uhrzeitLabel.setBounds(10, 110, 80, 25);
        panel.add(uhrzeitLabel);

        uhrzeitText = new JTextField(20);
        uhrzeitText.setBounds(100, 110, 165, 25);
        panel.add(uhrzeitText);
        uhrzeit = Integer.parseInt(uhrzeitText.getText());

        //Eingabe des Wochentages
        wochentagLabel = new JLabel("Wochentag");
        wochentagLabel.setBounds(10, 140, 80, 25);
        panel.add(wochentagLabel);

        wochentagText = new JTextField(20);
        wochentagText.setBounds(100, 140, 165, 25);
        panel.add(wochentagText);
        wochentag = Integer.parseInt(wochentagText.getText());

        //Anmelden Knopf
        button1 = new JButton("Anmelden");
        button1.setBounds(10, 170, 100, 25);
        panel.add(button1);
        button1.addActionListener(new Main());

        //Abbrechen Knopf
        button2 = new JButton("Abbrechen");
        button2.setBounds(120, 170, 100, 25);
        panel.add(button2);
        button2.addActionListener(new Main());

        //Ergebnis Label
        ergebnisLabel = new JLabel("");
        ergebnisLabel.setBounds(10, 210, 200, 25);
        panel.add(ergebnisLabel);

        frame.setVisible(true);

        //raumManager.bucheRaum(raumNr, uhrzeit, wochentag, name);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (!button1.getModel().isPressed()) {
            //ergebnisLabel.setText(userText.getText() + ", " + raumNrText.getText());
            //ergebnisLabel.setText(raumManager.bucheRaum(raumNr, uhrzeit, wochentag, userText.getText()));
        }
    }

}
