import enumeration.Dir;
import exception.GrilleException;
import model.CaseDefinition;
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




//        grille.ajouterDefinitionSimple("Qui se lance", 9, 0, Dir.VERTICALINDIRECT);

        if (grille.ajouterDefinitionSimple("Mot", 9, 0, Dir.VERTICALDIRECT)) {
            System.out.println(grille.getTableauDeCases()[9][0].getClass());
            System.out.println("x = " + grille.getTableauDeCases()[9][0].getCoordonnee().x +
                    "y = " + grille.getTableauDeCases()[9][0].getCoordonnee().y);
        }



//
//        CaseDefinition definition = (CaseDefinition) grille.getTableauDeCases()[9][0];
//        grille.ajouterMot(definition, "Salut");

        grille.Afficher();


//        GrilleGraphique grilleGraphiqueObj = new GrilleGraphique(grille, 9, 9);
//        grilleGraphiqueObj.setVisible(true);


    }
}
