import model.Grille;

public class Launch {
    public static void main(String args[]) {
        Grille grille = new Grille(9, 9);
//        grille.Afficher();
//        grille.ajouterMotHorizontal("totem", 0,2);
        grille.Afficher();
        grille.ajouterMotVertical("vertica", 0, 0);
        grille.Afficher();
    }
}
