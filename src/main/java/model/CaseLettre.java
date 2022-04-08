package model;

import enumeration.Dir;

public abstract class CaseLettre implements Case {
    Dir direction;
    Coordonnee coordonneeLettre;
    String definition;
    int nbMot = 1;

    public CaseLettre(Coordonnee coordonneeLettre, int nbMot) {
        this.coordonneeLettre = coordonneeLettre;
        this.nbMot = nbMot;
    }

    @Override
    public Coordonnee getCoordonnee() {
        return this.coordonneeLettre;
    }

    @Override
    public Coordonnee setCoordonnee(Coordonnee nouvelleCoordonnee) {
        return this.coordonneeLettre = nouvelleCoordonnee;
    }
}
