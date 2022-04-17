package model;

import enumeration.Dir;

public class CaseLettre extends Case {
    Coordonnee coordonneeLettre;
    String definition;
    char lettre;

    public CaseLettre(Coordonnee coordonneeLettre, char lettre) {
        this.coordonneeLettre = coordonneeLettre;
        this.lettre = lettre;
    }

    public void setLettre(char lettre) {
        this.lettre = lettre;
    }

    public char getLettre() {
        return this.lettre;
    }

    public String getLettreString() {
        return String.valueOf(this.lettre);
    }

}
