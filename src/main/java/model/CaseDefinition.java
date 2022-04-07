package model;

import java.awt.*;

public class CaseDefinition implements Case {

    Direction direction;
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
    public Coordonnee setCoordonnee(Coordonnee nouvelleCoordonnee) {
        this.coordonnee = nouvelleCoordonnee;
    }




}
