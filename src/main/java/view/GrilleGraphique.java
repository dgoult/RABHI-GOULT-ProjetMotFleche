package view;

import model.Grille;

import javax.swing.*;
import java.awt.*;

public class GrilleGraphique extends JFrame {

    private JLabel[][] grilleDeLabel;

    public GrilleGraphique(int hauteur, int largeur) {
        this.setSize(500, 200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Placement des Jlabels
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                JLabel label = new JLabel();
                label.setAlignmentX(hauteur * 20);
                label.setAlignmentY(largeur * 20);
                grilleDeLabel[hauteur][largeur] = label;
                this.add(label);
            }
        }

        this.createRootPane();


        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Fichier");
        menu.add("Nouveau");
        menuBar.add(menu);
        this.setMenuBar(menuBar);


    }

    public void displayGrille() {

    }


}
