import enumeration.Dir;
import exception.GrilleException;
import model.Coordonnee;
import model.Grille;
import view.GrilleGraphique;

public class Launch {
    public static void main(String args[]) {
        Grille grille;

        grille = new Grille();
        grille.initGrille(10, 10);
        grille.Afficher();
        grille.ajouterMotHorizontal("totem", 0,2);
        grille.Afficher();
        grille.ajouterMotVertical("obtute", 0, 0);
        grille.Afficher();

        grille.ajouterDefinitionSimple("Mot", 9, 0);

        grille.Afficher();


//        GrilleGraphique grilleGraphiqueObj = new GrilleGraphique(grille, 9, 9);
//        grilleGraphiqueObj.setVisible(true);


    }
}
