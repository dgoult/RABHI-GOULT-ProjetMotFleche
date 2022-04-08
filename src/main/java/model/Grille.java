package model;

import java.util.ArrayList;

public class Grille {
    private int hauteur;
    private int largeur;
    private ArrayList<Mot> mots;
    private int[] [] dimentionGrille;

    public Grille(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.dimentionGrille = new int[hauteur] [largeur];
    }

    public void Afficher() {
        System.out.println("    1 2 3 4 5 6 7 8 9");
        for(int i = dimentionGrille.length-1; i >= 0; i--){
            System.out.print((i+1)+" | ");
            for(int j=0; j<dimentionGrille[i].length; j++){
                System.out.print(". ");
            }
            System.out.println();
        }
    }

    public int[][] getDimentionGrille() {
        return dimentionGrille;
    }

    public void setDimentionGrille(int hauteur, int largeur) {
        this.dimentionGrille = new int[hauteur] [largeur];
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }


}
