package model;

import enumeration.Dir;

import java.awt.*;

public class CaseDefinition extends Case {

    Dir direction;
    Coordonnee coordonneeDef;
    String definition;

    public CaseDefinition() {}
    public CaseDefinition(Coordonnee coordonneeDef, String definition) {
        this.coordonneeDef = coordonneeDef;
        this.definition = definition;
    }

    public CaseDefinition(Coordonnee coordonneeDef, String definition, Dir direction) {
        this.coordonneeDef = coordonneeDef;
        this.definition = definition;
        this.direction = direction;
    }


}
