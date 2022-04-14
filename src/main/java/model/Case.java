package model;

public abstract class Case {

     private Coordonnee coordonneeDef;

     public Coordonnee getCoordonnee() {
          return this.coordonneeDef;
     }
     public void setCoordonnee(Coordonnee nouvelleCoordonnee) { this.coordonneeDef = nouvelleCoordonnee;
     }
}
