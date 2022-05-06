package objects;

public class Mot {

    private String mot;
    private boolean isVertical;
    private Coordonnee coordonneeDepartMot;



    /**
     *
     * @param mot
     * @param coordonneeDepartMot
     */
    public Mot(String mot, Coordonnee coordonneeDepartMot, boolean isVertical) {
        this.mot = mot;
        this.coordonneeDepartMot = coordonneeDepartMot;
        this.isVertical = isVertical;
    }

    public Coordonnee getCoordonneeDepartMot() { return this.coordonneeDepartMot; }

}
