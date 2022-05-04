package model;

import enumeration.Dir;

import java.awt.*;

public class CaseDefinition extends Case {

    Dir direction;
    Coordonnee coordonneeDef;
    String definition;

    public CaseDefinition() {}
    public CaseDefinition(Coordonnee coordonneeDef) {
        this.coordonneeDef = coordonneeDef;
    }


}
