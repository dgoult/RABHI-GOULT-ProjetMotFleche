package model;

import enumeration.Dir;

public class CaseDefinitionMultiple extends Case {

    Dir direction_1;
    Dir direction_2;
    Coordonnee coordonneeDef;
    String definition;

    public CaseDefinitionMultiple() {}
    public CaseDefinitionMultiple(Coordonnee coordonneeDef) {
        this.coordonneeDef = coordonneeDef;
    }


}
