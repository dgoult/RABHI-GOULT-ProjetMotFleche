package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import enumeration.Dir;
import enumeration.EnumCase;
import model.*;
import objects.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Grille Tester.
 *
 * @author <Authors name>
 * @since <pre>mai 4, 2022</pre>
 * @version 1.0
 */
public class GrilleTest {

    private static final Grille grille = new Grille();


    /**
     * Methode s'exécutant avant les autres tests pour initialiser la grille
     */
    @BeforeAll
    private static void testInitialisation() {
        grille.initGrille(10, 10);
    }


    /**
     * Method: initGrille(int hauteur, int largeur)
     */
    @Test
    public void testInitGrille() throws Exception {

        Grille grille1 = new Grille();
        Grille grille2 = new Grille();
        Grille grille3 = new Grille();
        Grille grille4 = new Grille();

        Assertions.assertTrue(grille1.initGrille(8, 8));
        Assertions.assertFalse(grille2.initGrille(0, 0));
        Assertions.assertFalse(grille3.initGrille(-5, -5));
        Assertions.assertFalse(grille4.initGrille(50, 50));


        boolean isGrilleFilled = true;

        //Boucle pour vérifier que chaque instance de Case est CaseVide
        for (Case[] ligneDeCases : grille1.getTableauDeCases()) {
            for (Case cases : ligneDeCases) {
                if (!(cases instanceof CaseVide)) {
                    isGrilleFilled = false;
                    break;
                }
            }
        }
        Assertions.assertTrue(isGrilleFilled);
    }

    /**
     * Method: Afficher()
     */
    @Test
    public void testAfficher() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: ajouterMotHorizontal(String unMot, int x, int y)
     */
    @Test
    public void testAjouterMotHorizontal() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: ajouterMotVertical(String unMot, int x, int y)
     */
    @Test
    public void testAjouterMotVertical() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: checkCaseAt(Coordonnee coordonnee)
     */
    @Test
    public void testCheckCaseAt() throws Exception {
        Grille grille = new Grille();
        grille.initGrille(5, 5);
        grille.setCaseAt(new CaseVide(), new Coordonnee(0, 0));
        grille.setCaseAt(new CaseLettre(), new Coordonnee(0, 1));
        grille.setCaseAt(new CaseDefinition(), new Coordonnee(0, 2));
        grille.setCaseAt(new CaseDefinitionMultiple(), new Coordonnee(0, 3));

        Assertions.assertEquals(EnumCase.CASE_VIDE, grille.checkCaseAt(0, 0));
        Assertions.assertEquals(EnumCase.CASE_LETTRE, grille.checkCaseAt(0, 1));
        Assertions.assertEquals(EnumCase.CASE_DEFINITION, grille.checkCaseAt(0, 2));
        Assertions.assertEquals(EnumCase.CASE_DEFINITION_MULTIPLE, grille.checkCaseAt(0, 3));

    }

    /**
     * Method: checkAvailableCases(Coordonnee coordonnee, Dir direction)
     */
    @Test
    public void testCheckAvailableCases() throws Exception {
        Grille grille = new Grille();
        grille.initGrille(10, 6);

        Assertions.assertEquals(9, grille.checkAvailableCases(0, 0, Dir.HORIZONTALDIRECT));
        Assertions.assertEquals(10, grille.checkAvailableCases(0, 0, Dir.HORIZONTALINDIRECT));
        Assertions.assertEquals(5, grille.checkAvailableCases(0, 0, Dir.VERTICALDIRECT));
        Assertions.assertEquals(6, grille.checkAvailableCases(0, 0, Dir.VERTICALINDIRECT));

    }

    /**
     * Method: getTableauDeCases()
     */
    @Test
    public void testGetTableauDeCases() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: getHauteur()
     */
    @Test
    public void testGetHauteur() throws Exception {
        Assertions.assertEquals(10 ,grille.getHauteur());
    }

    /**
     * Method: getLargeur()
     */
    @Test
    public void testGetLargeur() throws Exception {
        Assertions.assertEquals(10 ,grille.getLargeur());
    }

    /**
     * Method: initTableau()
     */
    @Test
    public void testInitTableau() throws Exception {
        //TODO: Test goes here...
/*
try {
   Method method = Grille.getClass().getMethod("initTableau");
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/


    }
}

