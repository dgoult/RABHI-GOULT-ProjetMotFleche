import enumeration.Dir;
import model.Grille;
import view.GrilleGraphique;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class MainApp {

    private static JFrame frame;
    private static JTextField field;
    private static JPanel contentPanel;
    private static JPanel displayPanel;
    private static JPanel buttonPanel;
    private static boolean start = true;
    private static double result = 0;
    private static String lastCommand = "=";

    public static void main(String args[]) throws IOException {
        Grille grille;

        grille = new Grille();
        grille.initGrille(6, 6);
        grille.Afficher();
        grille.ajouterMot(grille.ajouterDefinitionSimple("truc", 1, 0, Dir.VERTICALDIRECT), "totem", 1, 0, true);
        grille.ajouterMot(grille.ajouterDefinitionSimple("truc", 4, 0, Dir.VERTICALDIRECT), "totem", 4, 0, true);
        grille.ajouterMot(grille.ajouterDefinitionSimple("truc", 0, 2, Dir.HORIZONTALDIRECT), "oral", 0, 2, false);
        grille.Afficher();
        ArrayList<String> mots = grille.findWord(0, 1, Dir.HORIZONTALDIRECT);

        for (String unMot : mots) {
            System.out.println(unMot);
        }

        frame = new JFrame("Simple Calculator");
        field = new JTextField();
        contentPanel = new JPanel();
        displayPanel = new JPanel();
        buttonPanel = new JPanel();
        // Set the content panel
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanel.setLayout(new BorderLayout(0, 0));
        contentPanel.add(displayPanel, BorderLayout.NORTH);
        contentPanel.add(buttonPanel, BorderLayout.CENTER);
        // Set the result field
        field.setText("0");
        field.setHorizontalAlignment(SwingConstants.RIGHT);
        field.setEditable(false);
        field.setColumns(13);
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));


        frame.setLayout(new GridLayout(2, 1));
        frame.add(field);
        frame.add(contentPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

//        GrilleGraphique grilleGraphiqueObj = new GrilleGraphique(grille, 6, 6);
//        grilleGraphiqueObj.setVisible(true);


    }
}
