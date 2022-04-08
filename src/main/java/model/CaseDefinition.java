package model;

import enumeration.Dir;

public class CaseDefinition implements Case {

    Dir direction;
    Coordonnee coordonnee;
    String definition;
    int nbMot = 1;

    public CaseDefinition(Coordonnee coordonnee, int nbMot) {
        this.coordonnee = coordonnee;
        this.nbMot = nbMot;
    }

    @Override
    public Coordonnee getCoordonnee() {
        return this.coordonnee;
    }

    @Override
    public void setCoordonnee(Coordonnee nouvelleCoordonnee) {
        this.coordonnee = nouvelleCoordonnee;
    }




}
