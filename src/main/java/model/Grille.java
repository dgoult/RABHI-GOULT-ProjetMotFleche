package model;

import enumeration.Dir;

public class Grille implements I_modeleGrille {
    private int hauteur;
    private int largeur;
    private Case[][] grilleDeCases;
    private Mot[] tableauDeMots;
    static final int MAX_HAUTEUR = 10;
    static final int MAX_LARGEUR = 10;

    public Grille() {

    }

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
        System.out.println("012345678");
        for (int h = 0; h < hauteur; h++) {
            for (int l = 0; l < largeur; l++) {
                if (grilleDeCases[l][h] instanceof CaseVide) {
                    System.out.print(".");
                } else if (grilleDeCases[l][h] instanceof CaseLettre) {
                    CaseLettre caseTemp = (CaseLettre) grilleDeCases[l][h];
                    System.out.print(caseTemp.getLettre());
                }
            }
            System.out.println(h);
        }
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
            return true;
        }
    }

    /**
     *
     * @param coordonnee
     * @return returns "CaseVide", "CaseLettre", "CaseDefinition" or "CaseDefinitionMultiple" depending on the case at the coordinate
     */
    public String checkCaseAt(Coordonnee coordonnee) {
        Case caseAt = this.grilleDeCases[coordonnee.x][coordonnee.y];
        return caseAt.getClass().getSimpleName();
    }

    public int checkAvailableCases (Coordonnee coordonnee, Dir direction) {
        Coordonnee checkFromCase = new Coordonnee(0,0);
        int nbCaseDispo = 0;

        switch (direction) {
            case VERTICALDIRECT -> {
                checkFromCase.y = coordonnee.y - 1;
                checkFromCase.x = coordonnee.x;
            }
            case VERTICALINDIRECT, HORIZONTALDIRECT -> {
                checkFromCase.y = coordonnee.y;
                checkFromCase.x = coordonnee.x + 1;
            }
            case HORIZONTALINDIRECT -> {
                checkFromCase.y = coordonnee.y + 1;
                checkFromCase.x = coordonnee.x;
            }
        }

        if (direction == Dir.HORIZONTALDIRECT || direction == Dir.HORIZONTALINDIRECT) {
            // Pour les mots horizontaux
            for (int i = checkFromCase.y; i < this.largeur; i++) {
                if (this.grilleDeCases[checkFromCase.x][checkFromCase.y] instanceof CaseVide) {
                    nbCaseDispo++;
                } else {
                    break;
                }
            }
        } else {
            // Pour les mots verticaux
            for (int i = checkFromCase.x; i < this.hauteur; i++) {
                if (this.grilleDeCases[checkFromCase.x][checkFromCase.y] instanceof CaseVide) {
                    nbCaseDispo++;
                } else {
                    break;
                }
            }
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
