package view;

import model.Grille;

import javax.swing.*;
import java.awt.*;

public class GrilleGraphique extends JFrame {

    JFrame grilleEntiere;

    public GrilleGraphique() {
        this.setSize(500, 200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Fichier");
        menu.add("Nouveau");
        menuBar.add(menu);
        this.setMenuBar(menuBar);


    }

    public void displayGrille() {

    }


}
