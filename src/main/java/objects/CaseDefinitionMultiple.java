package objects;

import enumeration.Dir;

public class CaseDefinitionMultiple extends Case {

    Dir direction_1;
    Dir direction_2;
    Coordonnee coordonneeDef;
    String definition;
    Mot mot;

    public CaseDefinitionMultiple() {}
    public CaseDefinitionMultiple(Coordonnee coordonneeDef) {
        this.coordonneeDef = coordonneeDef;
    }

    public CaseDefinitionMultiple(Coordonnee coordonneeDef, Mot mot) {
        this.coordonneeDef = coordonneeDef;
        this.mot = mot;
    }


}
