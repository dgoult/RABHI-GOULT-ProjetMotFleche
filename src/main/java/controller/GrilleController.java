package controller;

import model.Grille;
import view.GrilleGraphique;

public class GrilleController {

    private GrilleGraphique grilleGraphique;
    private Grille grille;

    public GrilleController(Grille grille, GrilleGraphique grilleGraphique) {
        this.grille = grille;
        this.grilleGraphique = grilleGraphique;
    }


}
