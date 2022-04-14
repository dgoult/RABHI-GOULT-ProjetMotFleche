package model;

public class Grille implements I_modeleGrille {
    private int hauteur;
    private int largeur;
    private char[] [] tableauDeCases;

    public Grille(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.tableauDeCases = new char[largeur][hauteur];
        initTableau();
    }

    private void initTableau() {
        for (int h = 0; h < hauteur; h++) {
            for (int l = 0; l < largeur; l++) {
                tableauDeCases[l][h] = '.';
            }
        }
    }

    public void Afficher() {
        System.out.println("012345678");
        for (int h = 0; h < hauteur; h++) {
            for (int l = 0; l < largeur; l++) {
                System.out.print(tableauDeCases[l][h]);
            }
            System.out.println(h);
        }
    }

    public boolean ajouterMotHorizontal(String unMot, int x , int y) {
        if (unMot.length()+x>largeur) {
            System.out.println("le mot : "+unMot+" est trop long");
            return false;
        } else {
            for (int i=0;i < unMot.length();i++) {
                tableauDeCases[i+x][y] = unMot.charAt(i);
            }
            return true;
        }
    }

    public boolean ajouterMotVertical(String unMot, int x , int y) {
        if (unMot.length()+x>hauteur) {
            System.out.println("le mot : "+unMot+" est trop long");
            return false;
        } else {
            for (int i=0;i < unMot.length();i++) {
                tableauDeCases[x][i+y] = unMot.charAt(i);
            }
            return true;
        }
    }

    public char[][] getTableauDeCases() {
        return tableauDeCases;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }
}
