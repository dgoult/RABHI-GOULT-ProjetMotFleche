import enumeration.Dir;
import exception.GrilleException;
import model.AutoCompletion;
import model.CaseDefinition;
import model.Coordonnee;
import model.Grille;
import view.GrilleGraphique;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class Launch {
    public static void main(String args[]) throws IOException {
        Grille grille;

        grille = new Grille();
        grille.initGrille(6, 6);
        grille.Afficher();

        grille.ajouterMot(grille.ajouterDefinitionSimple("truc", 1, 0, Dir.VERTICALDIRECT), "totem", 1, 0, true);

        grille.ajouterMot(grille.ajouterDefinitionSimple("truc", 4, 0, Dir.VERTICALDIRECT), "totem", 4, 0, true);

        grille.ajouterMot(grille.ajouterDefinitionSimple("truc", 0, 2, Dir.HORIZONTALDIRECT), "oral", 0, 2, false);

        grille.Afficher();

        ArrayList<String> mots = grille.findWord(0, 1, Dir.HORIZONTALDIRECT);

        // AutoCompletion.findWordWithRegex("[a-zA-Z]{4}y[a-zA-Zéèçàù]{0,5}");

        for (String unMot : mots) {
            System.out.println(unMot);
        }



//        GrilleGraphique grilleGraphiqueObj = new GrilleGraphique(grille, 9, 9);
//        grilleGraphiqueObj.setVisible(true);


    }
}
