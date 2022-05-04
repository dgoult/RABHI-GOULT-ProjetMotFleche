package model;

import enumeration.Dir;

public class Mot {

    private String mot;
    private int longueurMot;
    private Dir directionMot;
    private Coordonnee coordonneeDepartMot;

    public Mot(String mot, Coordonnee coordonneeDepartMot) {
        this.mot = mot;
        this.coordonneeDepartMot = coordonneeDepartMot;
    }

}
