import controller.GrilleController;
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

    public static void main(String args[]) throws IOException {

        Grille grille;
        GrilleController grilleController;
        GrilleGraphique grilleGraphique;

        // Initialisation du model de la grille
        grille = new Grille();
        grille.initGrille(6, 6);
        grilleGraphique = new GrilleGraphique(grille);
        grilleController = new GrilleController(grille, grilleGraphique);
        grilleGraphique.displayGrille();

    }
}
