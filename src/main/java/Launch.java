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
        grille.ajouterMot(grille.ajouterDefinitionSimple("truc", 0, 2, Dir.HORIZONTALDIRECT), "totem", 0, 2, false);




//        grille.ajouterDefinitionSimple("Qui se lance", 9, 0, Dir.VERTICALINDIRECT);




//
//        CaseDefinition definition = (CaseDefinition) grille.getTableauDeCases()[9][0];
//        grille.ajouterMot(definition, "Salut");

        grille.Afficher();


//        GrilleGraphique grilleGraphiqueObj = new GrilleGraphique(grille, 9, 9);
//        grilleGraphiqueObj.setVisible(true);


    }
}
