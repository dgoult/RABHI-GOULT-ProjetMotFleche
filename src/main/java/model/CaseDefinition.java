package model;

import enumeration.Dir;

import java.awt.*;

public class CaseDefinition extends Case {

    Dir direction;
    Coordonnee coordonnee;
    String definition;
    Mot mot;

    public CaseDefinition() {}
    public CaseDefinition(String definition) {
        this.definition = definition;
    }
    public CaseDefinition(Coordonnee coordonnee, String definition) {
        this.coordonnee = coordonnee;
        this.definition = definition;
    }

    public CaseDefinition(Coordonnee coordonnee, String definition, Dir direction) {
        this.coordonnee = coordonnee;
        this.definition = definition;
        this.direction = direction;
    }

    public CaseDefinition(Coordonnee coordonnee, String definition, Dir direction, Mot mot) {
        this.coordonnee = coordonnee;
        this.definition = definition;
        this.direction = direction;
        this.mot = mot;
    }


}
