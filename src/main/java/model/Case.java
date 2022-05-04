package model;

public abstract class Case {

     protected Coordonnee coordonnee;

     public Case() {}
     public Coordonnee getCoordonnee() {
          return this.coordonnee;
     }

     /**
      * Permet de donner des coordonnées à une case sans créer d'objet Coordonnee
      * @param x
      * @param y
      */
     public void setCoordonnee(int x, int y) {
          this.coordonnee = new Coordonnee(x, y);
     }

     public int getx() {
          return this.coordonnee.x;
     }

     public int gety() {
          return this.coordonnee.y;
     }

}
