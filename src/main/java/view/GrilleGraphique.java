package view;

import model.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GrilleGraphique extends JFrame {

    protected JLabel[][] grilleDeLabel;
    private Grille grille;

    public GrilleGraphique(Grille grille, int hauteur, int largeur) {

        super("Mot fléché");

        this.grille = grille;
        this.grilleDeLabel = new JLabel[hauteur][largeur];

        this.setSize(1200, 700);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Placement des Jlabels

        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                String sLabel = "";
                if (this.grille.getTableauDeCases()[i][j] instanceof CaseLettre) {
                    sLabel = ((CaseLettre) this.grille.getTableauDeCases()[i][j]).getLettreString();
                }
                else if (this.grille.getTableauDeCases()[i][j] instanceof CaseDefinition) {
                    sLabel = "Definition";
                }
                else if (this.grille.getTableauDeCases()[i][j] instanceof CaseDefinitionMultiple) {
                    sLabel = "Definition Multiple";
                }
                else if (this.grille.getTableauDeCases()[i][j] instanceof CaseVide) {
                    sLabel = "";
                }
                else {
                    sLabel = "XX";
                }

                JLabel label = GrilleGraphique.labelFactory(sLabel, i * 40, j * 40);
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


    private static JLabel labelFactory(String text, int x, int y) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setAlignmentX(SwingConstants.CENTER);
        label.setAlignmentY(SwingConstants.CENTER);
        label.setBounds(x, y, 35, 35);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        label.setFocusable(true);
        return label;
    }



}
