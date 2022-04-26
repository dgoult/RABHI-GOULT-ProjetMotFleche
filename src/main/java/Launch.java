import model.Grille;
import view.GrilleGraphique;

public class Launch {
    public static void main(String args[]) {
        Grille grille = new Grille(9, 9);
        grille.ajouterMotHorizontal("totem", 0,2);
        grille.ajouterMotVertical("obtute", 0, 0);
        grille.ajouterMotVertical("membres", 4, 2);

        GrilleGraphique grilleGraphiqueObj = new GrilleGraphique(grille, 9, 9);
        grilleGraphiqueObj.setVisible(true);

    }
}
