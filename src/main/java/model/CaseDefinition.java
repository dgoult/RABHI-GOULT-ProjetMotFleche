package model;

import enumeration.Dir;

import java.awt.*;

public class CaseDefinition implements Case {

    Dir direction;
    Coordonnee coordonneeDef;
    String definition;
    int nbMot = 1;

    public CaseDefinition(Coordonnee coordonneeDef, int nbMot) {
        this.coordonneeDef = coordonneeDef;
        this.nbMot = nbMot;
    }

    @Override
    public Coordonnee getCoordonnee() {
        return this.coordonneeDef;
    }

    @Override
    public Coordonnee setCoordonnee(Coordonnee nouvelleCoordonnee) {
       return this.coordonneeDef = nouvelleCoordonnee;
    }

}
