package model;

import enumeration.Dir;
import enumeration.EnumCase;

import java.util.ArrayList;

public class Grille implements I_modeleGrille {
    private int hauteur;
    private int largeur;
    private Case[][] grilleDeCases;
    private ArrayList<Mot> motArrayList = new ArrayList<>();
    static final int MAX_HAUTEUR = 10;
    static final int MAX_LARGEUR = 10;

    public Grille() {}

    /**
     * Permet d'initialiser la grille avec une hauteur et une largeur
     * @param hauteur
     * @param largeur
     * @return
     */
    public boolean initGrille(int hauteur, int largeur) {
        if (hauteur > MAX_HAUTEUR || largeur > MAX_LARGEUR || hauteur <= 0 || largeur <= 0) {
            return false;
        }
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.grilleDeCases = new Case[largeur][hauteur];
        initTableau();
        return true;
    }

    /**
     * Initialise le tableau de case, en le remplissant d'objet CaseVide
     */
    private void initTableau() {
        for (int h = 0; h < hauteur; h++) {
            for (int l = 0; l < largeur; l++) {
                grilleDeCases[l][h] = new CaseVide(new Coordonnee(h, l));
            }
        }
    }

    /**
     * Affiche la grille en mode console
     */
    public void Afficher() {
        for (int i = 0; i < largeur; i++) {
            System.out.print(i + " ");
        }
        System.out.print("#\n");

        for (int h = 0; h < hauteur; h++) {
            for (int l = 0; l < largeur; l++) {
                if (grilleDeCases[l][h] instanceof CaseVide) {
                    System.out.print(". ");
                } else if (grilleDeCases[l][h] instanceof CaseLettre caseTemp) {
                    System.out.print(caseTemp.getLettre() + " ");
                } else if (grilleDeCases[l][h] instanceof CaseDefinition caseTemp) {
                    System.out.print("1 ");
                }  else if (grilleDeCases[l][h] instanceof CaseDefinitionMultiple caseTemp) {
                    System.out.print("2 ");
                }
            }
            System.out.println(h);
        }
        System.out.print("\n");
    }

    public boolean isLettrePartOfTwoWords(Coordonnee coordonnee) {

        for (Mot singleMot : this.motArrayList) {

        }
        return true;
        //TODO
    }

    public boolean ajouterMot(Case caseDefinition, String mot) {

        if (caseDefinition instanceof CaseDefinition uneCase) {

            int nbCaseDispo = checkAvailableCases(uneCase.getCoordonnee().x, uneCase.getCoordonnee().y, uneCase.direction);

            // Si le mot est trop long
            if (mot.length() > nbCaseDispo) {
                System.out.printf("Le mot \"" + mot + "\" est trop long");
                return false;
            }

            Mot unMot = new Mot(mot, getCoordonneeByDirection(uneCase.direction ,uneCase.getCoordonnee().x, uneCase.getCoordonnee().y));

            this.motArrayList.add(unMot);
            uneCase.mot = unMot;

            return true;

        }
        return false;
    }

    public Coordonnee getCoordonneeByDirection(Dir direction, int x, int y) {

        Coordonnee coordonnee = new Coordonnee();

        switch (direction) {
            case VERTICALDIRECT, HORIZONTALINDIRECT -> {
                coordonnee.y = y + 1;
                coordonnee.x = x;
            }
            case VERTICALINDIRECT, HORIZONTALDIRECT -> {
                coordonnee.y = y;
                coordonnee.x = x + 1;
            }
        }

        return coordonnee;

    }

    public boolean checkAvailableDirectionForDefinition(int x, int y, Dir direction) {

        switch (direction) {
            case VERTICALINDIRECT, HORIZONTALDIRECT -> {
                if (checkAvailableCases(x, y, Dir.HORIZONTALDIRECT) == 0) {
                    return false;
                }
            }
            case VERTICALDIRECT, HORIZONTALINDIRECT -> {
                if (checkAvailableCases(x, y, Dir.VERTICALDIRECT) == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean ajouterDefinitionSimple(String definition, int x, int y, Dir direction) {
        try {
            if (isCaseVide(x, y)) {
                if (checkAvailableDirectionForDefinition(x, y, direction)) {
                    Coordonnee coordonneeCase = new Coordonnee(x, y);
                    setCaseAt(new CaseDefinition(coordonneeCase, definition), coordonneeCase);
                    return true;
                } else {
                    System.out.println("La définition \"" + definition + "\" en " + x + ":" + y + " dans la direction " + direction.toString() + " n'est pas possible");
                    return false;
                }

            }
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean isCaseVide(int x, int y) {
        return this.grilleDeCases[x][y] instanceof CaseVide;
    }

    public boolean ajouterMotHorizontal(String unMot, int x , int y) {
        if (unMot.length()+x>largeur) {
            System.out.println("le mot : "+unMot+" est trop long");
            return false;
        } else {

            // On check si toutes les cases sont bien vide
            for (int i=0;i < unMot.length();i++) {
                if (!(grilleDeCases[i+x][y] instanceof CaseVide)) {
                    if (grilleDeCases[i+x][y] instanceof CaseLettre) {
                        if (((CaseLettre) grilleDeCases[i + x][y]).getLettre() != unMot.charAt(i)) {
                            return false;
                        }
                    } else {
                        return false;
                    }

                }
            }

            for (int i=0;i < unMot.length();i++) {
                grilleDeCases[i+x][y] = new CaseLettre(new Coordonnee(i+x, y), unMot.charAt(i)) ;
            }
            return true;
        }
    }

    public boolean ajouterMotVertical(String unMot, int x , int y) {
        if (unMot.length()+y>hauteur) {
            System.out.println("le mot : "+unMot+" est trop long");
            return false;
        } else {

            // On check si toutes les cases sont bien vide
            for (int i=0;i < unMot.length();i++) {
                if (!(grilleDeCases[x][i+y] instanceof CaseVide)) {
                    if (grilleDeCases[x][i+y] instanceof CaseLettre) {
                        if (((CaseLettre) grilleDeCases[x][i+y]).getLettre() != unMot.charAt(i)) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
            for (int i=0;i < unMot.length();i++) {
                grilleDeCases[x][i+y] = new CaseLettre(new Coordonnee(x, i+y), unMot.charAt(i)) ;
            }
            this.motArrayList.add(new Mot(unMot, new Coordonnee(x, y)));
            return true;
        }
    }

    /**
     * Permet de placer une case aux coordonnées fournies
     * @param uneCase
     * @return
     */
    public boolean setCaseAt(Case uneCase, Coordonnee coordonnee) {
        this.grilleDeCases[coordonnee.x][coordonnee.y] = uneCase;
        return true;
    }

    /**
     * renvoi la classe de la Case aux coordonnées fournies
     * @param coordonnee
     * @return returns "CaseVide", "CaseLettre", "CaseDefinition" or "CaseDefinitionMultiple" depending on the case at the coordinate
     */
    public EnumCase checkCaseAt(Coordonnee coordonnee) {
        Case caseAt = this.grilleDeCases[coordonnee.x][coordonnee.y];
        return EnumCase.getClassEnum(caseAt);
    }

    public EnumCase checkCaseAt(int x, int y) {
        Case caseAt = this.grilleDeCases[x][y];
        return EnumCase.getClassEnum(caseAt);
    }

    public int checkAvailableCases (Coordonnee coordonnee, Dir direction) {
        Coordonnee checkFromCase = new Coordonnee(0,0);
        int nbCaseDispo = 0;

        switch (direction) {
            case VERTICALDIRECT, HORIZONTALINDIRECT -> {
                checkFromCase.y = coordonnee.y + 1;
                checkFromCase.x = coordonnee.x;
            }
            case VERTICALINDIRECT, HORIZONTALDIRECT -> {
                checkFromCase.y = coordonnee.y;
                checkFromCase.x = coordonnee.x + 1;
            }
        }

        try {
            if (direction == Dir.HORIZONTALDIRECT || direction == Dir.HORIZONTALINDIRECT) {
                // Pour les mots horizontaux

                for (int i = checkFromCase.x; i < this.hauteur; i++) {
                    if (this.grilleDeCases[checkFromCase.x][checkFromCase.y] instanceof CaseVide) {
                        nbCaseDispo++;
                    } else {
                        break;
                    }
                }

            } else {
                // Pour les mots verticaux
                for (int i = checkFromCase.y; i < this.largeur; i++) {
                    if (this.grilleDeCases[checkFromCase.x][checkFromCase.y] instanceof CaseVide) {
                        nbCaseDispo++;
                    } else {
                        break;
                    }
                }
            }

        } catch (IndexOutOfBoundsException e) {
            return 0;
        }

        return nbCaseDispo;
    }

    public int checkAvailableCases (int x, int y, Dir direction) {
        Coordonnee checkFromCase = new Coordonnee(0,0);
        int nbCaseDispo = 0;

        switch (direction) {
            case VERTICALDIRECT, HORIZONTALINDIRECT -> {
                checkFromCase.y = y + 1;
                checkFromCase.x = x;
            }
            case VERTICALINDIRECT, HORIZONTALDIRECT -> {
                checkFromCase.y = y;
                checkFromCase.x = x + 1;
            }
        }

        try {
            if (direction == Dir.HORIZONTALDIRECT || direction == Dir.HORIZONTALINDIRECT) {
                // Pour les mots horizontaux

                for (int i = checkFromCase.x; i < this.hauteur; i++) {
                    if (this.grilleDeCases[checkFromCase.x][checkFromCase.y] instanceof CaseVide) {
                        nbCaseDispo++;
                    } else {
                        break;
                    }
                }

            } else {
                // Pour les mots verticaux
                for (int i = checkFromCase.y; i < this.largeur; i++) {
                    if (this.grilleDeCases[checkFromCase.x][checkFromCase.y] instanceof CaseVide) {
                        nbCaseDispo++;
                    } else {
                        break;
                    }
                }
            }

        } catch (IndexOutOfBoundsException e) {
            return 0;
        }

        return nbCaseDispo;
    }

    public Case[][] getTableauDeCases() {
        return grilleDeCases;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }
}
