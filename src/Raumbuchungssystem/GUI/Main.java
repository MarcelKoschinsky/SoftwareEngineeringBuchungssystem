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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Set;

public class Main {

    IRaumManager raumManager = new RaumManager();   //neuen RaumManager erstellt

    public static void main (String[]args) {
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
        frame.setSize(720,800);
        frame.add(panel);

        panel.setLayout(null);

        //Benutzereingabe
        JLabel userLabel = new JLabel("Benutzer");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        //Passworteingabe
        JLabel passwordLabel = new JLabel("Passwort");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JTextField passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        //Eingabe der RaumNr
        JLabel raumNrLabel = new JLabel("Raum Nr.");
        raumNrLabel.setBounds(10, 80, 80, 25);
        panel.add(raumNrLabel);

        JTextField raumNrText = new JTextField(20);
        raumNrText.setBounds(100, 80, 165, 25);
        panel.add(raumNrText);

        //Eingabe der Uhrzeit
        JLabel uhrzeitLabel = new JLabel("Uhrzeit");
        uhrzeitLabel.setBounds(10, 110, 80, 25);
        panel.add(uhrzeitLabel);

        JTextField uhrzeitText = new JTextField(20);
        uhrzeitText.setBounds(100, 110, 165, 25);
        panel.add(uhrzeitText);

        //Eingabe des Wochentages
        JLabel wochentagLabel = new JLabel("Wochentag");
        wochentagLabel.setBounds(10, 140, 80, 25);
        panel.add(wochentagLabel);

        JTextField wochentagText = new JTextField(20);
        wochentagText.setBounds(100, 140, 165, 25);
        panel.add(wochentagText);

        //Anmelden Knopf
        JButton button1 = new JButton("Anmelden");
        button1.setBounds(10, 170, 100, 25);
        panel.add(button1);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button1){
                    //raumManager.bucheRaum(raumNr, uhrzeit, wochentag, name);
                }
            }
        };

        frame.setVisible(true);

        //raumManager.bucheRaum(raumNr, uhrzeit, wochentag, name);

    }
}
