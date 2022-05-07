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




        /**
         * Le model
         */
        Grille grille;

        /**
         * Le controller
         */
        GrilleController grilleController;

        /**
         * La vue
         */
        GrilleGraphique grilleGraphique;

        // Initialisation du model de la grille
        grille = new Grille();
        grille.initGrille(6, 6);

        grilleGraphique = new GrilleGraphique(grille);
        grilleController = new GrilleController(grille, grilleGraphique);

        grille.Afficher();
        grille.ajouterMot(grille.ajouterDefinitionSimple("truc", 1, 0, Dir.VERTICALDIRECT), "totem", 1, 0, true);
        grille.ajouterMot(grille.ajouterDefinitionSimple("truc", 4, 0, Dir.VERTICALDIRECT), "totem", 4, 0, true);
        grille.ajouterMot(grille.ajouterDefinitionSimple("truc", 0, 2, Dir.HORIZONTALDIRECT), "oral", 0, 2, false);
        grille.Afficher();
        ArrayList<String> mots = grille.findWord(0, 1, Dir.HORIZONTALDIRECT);

        for (String unMot : mots) {
            System.out.println(unMot);
        }


//        GrilleGraphique grilleGraphiqueObj = new GrilleGraphique(grille, 6, 6);
//        grilleGraphiqueObj.setVisible(true);


    }
}
