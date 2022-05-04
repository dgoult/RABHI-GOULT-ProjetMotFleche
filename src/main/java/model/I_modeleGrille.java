package model;

public interface I_modeleGrille {
    public boolean ajouterMotHorizontal(String string, int x, int y);
    public boolean ajouterMotVertical(String string, int x, int y);
    public int getHauteur();
    public int getLargeur();
    public Case[][] getTableauDeCases();
}
