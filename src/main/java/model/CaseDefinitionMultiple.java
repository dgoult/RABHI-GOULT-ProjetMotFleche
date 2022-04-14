package model;

import enumeration.Dir;

public class CaseDefinitionMultiple extends Case {

    Dir direction;
    Coordonnee coordonneeDef;
    String definition;

    public CaseDefinitionMultiple(Coordonnee coordonneeDef) {
        this.coordonneeDef = coordonneeDef;
    }


}
