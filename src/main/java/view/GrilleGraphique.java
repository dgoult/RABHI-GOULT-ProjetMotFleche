package view;

import model.Case;
import model.CaseDefinition;
import model.CaseLettre;
import model.Grille;

import javax.swing.*;
import java.awt.*;

public class GrilleGraphique extends JFrame {

    protected JLabel[][] grilleDeLabel;
    private Grille grille;

    public GrilleGraphique(Grille grille, int hauteur, int largeur) {

        this.grille = grille;
        this.grilleDeLabel = new JLabel[hauteur][largeur];

        this.setSize(1000, 700);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Placement des Jlabels

        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                String sLabel = "";
                if (this.grille.getTableauDeCases()[hauteur][largeur] instanceof CaseLettre) {
                    sLabel = ((CaseLettre) this.grille.getTableauDeCases()[hauteur][largeur]).getLettreString();
                }
                if (this.grille.getTableauDeCases()[hauteur][largeur] instanceof CaseDefinition) {
                    sLabel = "Definition";
                }

                JLabel label = GrilleGraphique.newLabel(sLabel, i * 80, j * 80);
                this.add(label);
            }
        }

        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Fichier");
        menu.add("Nouveau");
        menuBar.add(menu);
        this.setMenuBar(menuBar);


    }

    public void displayGrille() {

    }


    private static JLabel newLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setAlignmentX(SwingConstants.CENTER);
        label.setAlignmentY(SwingConstants.CENTER);
        label.setBounds(x, y, 75, 75);
        label.setFocusable(true);
        return label;
    }


}
