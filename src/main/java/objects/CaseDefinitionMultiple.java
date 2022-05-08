package objects;

import enumeration.Dir;

public class CaseDefinitionMultiple extends Case {

    public Dir direction_1;
    public Dir direction_2;
    public Coordonnee coordonneeDef;
    public String definition_1;
    public String definition_2;
    public Mot mot_1;
    public Mot mot_2;

    public CaseDefinitionMultiple() {}
    public CaseDefinitionMultiple(Coordonnee coordonneeDef) {
        this.coordonneeDef = coordonneeDef;
    }

    public CaseDefinitionMultiple(Coordonnee coordonneeDef, String definition_1, String definition_2) {
        this.coordonneeDef = coordonneeDef;
        this.definition_1 = definition_1;
        this.definition_2 = definition_2;

    }
    public CaseDefinitionMultiple(Coordonnee coordonneeDef, String definition_1, String definition_2, Dir direction_1, Dir direction_2) {
        this.coordonneeDef = coordonneeDef;
        this.definition_1 = definition_1;
        this.definition_2 = definition_2;
        this.direction_1 = direction_1;
        this.direction_2 = direction_2;
    }


}
