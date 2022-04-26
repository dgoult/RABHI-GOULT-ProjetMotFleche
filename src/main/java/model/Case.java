package model;

public abstract class Case {

     protected Coordonnee coordonneeDef;

     public Coordonnee getCoordonnee() {
          return this.coordonneeDef;
     }

     /**
      * Permet de donner des coordonnées à une case sans créer d'objet Coordonnee
      * @param x
      * @param y
      */
     public void setCoordonnee(int x, int y) {
          this.coordonneeDef = new Coordonnee(x, y);
     }
}
