package enumeration;

import model.*;

public enum EnumCase {
    CASE_VIDE,
    CASE_LETTRE,
    CASE_DEFINITION,
    CASE_DEFINITION_MULTIPLE;

    public static EnumCase getClassEnum(Case uneCase) {
        if (uneCase instanceof CaseLettre) return EnumCase.CASE_LETTRE;
        else if (uneCase instanceof CaseDefinition) return EnumCase.CASE_DEFINITION;
        else if (uneCase instanceof CaseDefinitionMultiple) return EnumCase.CASE_DEFINITION_MULTIPLE;
        else return EnumCase.CASE_VIDE;
    }

}
