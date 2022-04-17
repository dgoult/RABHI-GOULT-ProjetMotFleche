import model.Grille;
import view.GrilleGraphique;

public class Launch {
    public static void main(String args[]) {
        Grille grille = new Grille(9, 9);
        grille.Afficher();
        grille.ajouterMotHorizontal("totem", 0,2);
        grille.Afficher();
        grille.ajouterMotVertical("obtute", 0, 0);
        grille.Afficher();

        GrilleGraphique grilleGraphiqueObj = new GrilleGraphique(grille, 9, 9);
        grilleGraphiqueObj.setVisible(true);

    }
}
