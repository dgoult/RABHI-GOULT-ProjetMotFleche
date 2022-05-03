package model;

import exception.GrilleException;

import java.util.ArrayList;

public class Grille implements I_modeleGrille {
    private int hauteur;
    private int largeur;
    private Case[][] grilleDeCases;
    private Mot[] tableauDeMots;
    static final int MAX_HAUTEUR = 10;
    static final int MAX_LARGEUR = 10;

    public Grille(int hauteur, int largeur) throws GrilleException {
        if (hauteur > MAX_HAUTEUR || largeur > MAX_LARGEUR || hauteur <= 0 || largeur <= 0) {
            throw new GrilleException();
        }
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.grilleDeCases = new Case[largeur][hauteur];
        initTableau();
    }

    private void initTableau() {
        for (int h = 0; h < hauteur; h++) {
            for (int l = 0; l < largeur; l++) {
                grilleDeCases[l][h] = new CaseVide(new Coordonnee(h, l));
            }
        }
    }

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
        if (unMot.length()+x>hauteur) {
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
