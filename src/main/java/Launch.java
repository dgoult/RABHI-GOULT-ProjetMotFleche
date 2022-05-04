import enumeration.Dir;
import exception.GrilleException;
import model.Coordonnee;
import model.Grille;
import view.GrilleGraphique;

public class Launch {
    public static void main(String args[]) {
        Grille grille;

        grille = new Grille();
        grille.initGrille(9, 9);
        grille.Afficher();
        grille.ajouterMotHorizontal("totem", 0,2);
        grille.Afficher();
        grille.ajouterMotVertical("obtute", 0, 0);
        grille.Afficher();

        int nb = grille.checkAvailableCases(new Coordonnee(5, 5), Dir.HORIZONTALDIRECT);

        System.out.println("En 5,5 en horizontal indirect, il y a " + nb + " cases dispo");

//        GrilleGraphique grilleGraphiqueObj = new GrilleGraphique(grille, 9, 9);
//        grilleGraphiqueObj.setVisible(true);


    }
}
