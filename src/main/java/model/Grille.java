package model;

import enumeration.Dir;
import enumeration.EnumCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Grille implements I_modeleGrille {
    private int hauteur;
    private int largeur;
    private Case[][] grilleDeCases;
    private ArrayList<Mot> motArrayList = new ArrayList<>();
    static final int MAX_HAUTEUR = 10;
    static final int MAX_LARGEUR = 10;

    public Grille() {}

    /**
     * Permet d'initialiser la grille avec une hauteur et une largeur
     * @param hauteur
     * @param largeur
     * @return
     */
    public boolean initGrille(int hauteur, int largeur) {
        if (hauteur > MAX_HAUTEUR || largeur > MAX_LARGEUR || hauteur <= 0 || largeur <= 0) {
            return false;
        }
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.grilleDeCases = new Case[largeur][hauteur];
        initTableau();
        return true;
    }

    /**
     * Initialise le tableau de case, en le remplissant d'objet CaseVide
     */
    private void initTableau() {
        for (int h = 0; h < hauteur; h++) {
            for (int l = 0; l < largeur; l++) {
                grilleDeCases[l][h] = new CaseVide(new Coordonnee(h, l));
            }
        }
    }

    /**
     * Affiche la grille en mode console
     */
    public void Afficher() {
        for (int i = 0; i < largeur; i++) {
            System.out.print(i + " ");
        }
        System.out.print("#\n");

        for (int h = 0; h < hauteur; h++) {
            for (int l = 0; l < largeur; l++) {
                if (grilleDeCases[l][h] instanceof CaseVide) {
                    System.out.print(". ");
                } else if (grilleDeCases[l][h] instanceof CaseLettre caseTemp) {
                    System.out.print(Character.toUpperCase(caseTemp.getLettre()) + " ");
                } else if (grilleDeCases[l][h] instanceof CaseDefinition caseTemp) {
                    System.out.print("1 ");
                }  else if (grilleDeCases[l][h] instanceof CaseDefinitionMultiple caseTemp) {
                    System.out.print("2 ");
                }
            }
            System.out.println(h);
        }
        System.out.print("\n");
    }

    public boolean isLettrePartOfTwoWords(Coordonnee coordonnee) {

        for (Mot singleMot : this.motArrayList) {

        }
        return true;
        //TODO
    }

    public boolean ajouterMot(Case caseDefinition, String mot, int x, int y, boolean isVertical) {

        if (caseDefinition instanceof CaseDefinition uneCase) {

            Coordonnee coordonneeMot = getCoordonneeByDirection(uneCase.direction ,uneCase.getCoordonnee().x, uneCase.getCoordonnee().y);

            if (coordonneeMot.x >= largeur || coordonneeMot.x < 0 || coordonneeMot.y >= hauteur || coordonneeMot.y < 0) {
                System.out.println("Le mot dépasse");
                return false;
            }

            if (canWordBePlaced(mot, coordonneeMot.x, coordonneeMot.y, isVertical)) {


                Mot unMot = new Mot(mot, coordonneeMot, isVertical);

                System.out.println(unMot.getCoordonneeDepartMot().x + ":" + unMot.getCoordonneeDepartMot().y);

                this.motArrayList.add(unMot);
                uneCase.mot = unMot;

                if (isVertical) {
                    if (this.ajouterMotVertical(mot, coordonneeMot.x, coordonneeMot.y)) {
                        System.out.println("Le mot a été ajouté en vertical");
                    } else {
                        System.out.println("Le mot n'a pas été ajouté en vertical");
                    }
                } else {
                    if (this.ajouterMotHorizontal(mot, coordonneeMot.x, coordonneeMot.y)) {
                        System.out.println("Le mot a été ajouté en horizontal");
                    }else {
                        System.out.println("Le mot n'a pas été ajouté en horizontal");
                    }
                }
                return true;
            }
            System.out.println("Le mot ne peut être placé");

        }
        return false;
    }

    public Coordonnee getCoordonneeByDirection(Dir direction, int x, int y) {

        Coordonnee coordonnee = new Coordonnee();

        GetWordCoordonneeFromDir(x, y, direction, coordonnee);

        return coordonnee;

    }

    public boolean checkAvailableDirectionForDefinition(int x, int y, Dir direction) {

        switch (direction) {
            case VERTICALINDIRECT, HORIZONTALDIRECT -> {
                // On vérifie que le mot de cette définition ne dépassera pas la grille
                if (y + 1 >= this.hauteur) {
                    return false;
                }
                // On vérifie que la case où le mot commencera n'est pas une définition simple ou double
                if (grilleDeCases[x][y+1] instanceof CaseDefinition || grilleDeCases[x+1][y] instanceof CaseDefinitionMultiple) {
                    return false;
                }
            }
            case VERTICALDIRECT, HORIZONTALINDIRECT -> {
                // On vérifie que le mot de cette définition ne dépassera pas la grille
                if (x + 1 >= this.largeur) {
                    return false;
                }
                // On vérifie que la case où le mot commencera n'est pas une définition simple ou double
                if (grilleDeCases[x+1][y] instanceof CaseDefinition || grilleDeCases[x+1][y] instanceof CaseDefinitionMultiple) {
                    return false;
                }
            }
        }
        return true;
    }

    public Case ajouterDefinitionSimple(String definition, int x, int y, Dir direction) {
        try {
            if (isCaseVide(x, y)) {
                if (checkAvailableDirectionForDefinition(x, y, direction)) {
                    Coordonnee coordonneeCase = new Coordonnee(x, y);

                    CaseDefinition caseDefTemp = new CaseDefinition(coordonneeCase, definition);
                    caseDefTemp.setCoordonnee(x, y);
                    caseDefTemp.direction = direction;

                    setCaseAt(caseDefTemp, coordonneeCase);
                    System.out.println("La définition \"" + definition + "\" aux coordonnées " + x + ":" + y + " en direction " + direction.toString());
                    return caseDefTemp;
                } else {
                    System.out.println("La définition \"" + definition + "\" en " + x + ":" + y + " dans la direction " + direction.toString() + " n'est pas possible");
                    return null;
                }

            }
            return null;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public boolean isCaseVide(int x, int y) {
        return this.grilleDeCases[x][y] instanceof CaseVide;
    }

    public boolean canWordBePlaced(String unMot, int x , int y, boolean isVertical) {

        unMot = unMot.toLowerCase();

        if (unMot.length()+x>largeur) {
            System.out.println("le mot : "+unMot+" est trop long");
        } else {
            if (isVertical) {
                for (int i=0;i < unMot.length();i++) {
                    if (!(grilleDeCases[x][i+y] instanceof CaseVide)) {
                        if (grilleDeCases[x][i+y] instanceof CaseLettre) {
                            if (((CaseLettre) grilleDeCases[x][i+y]).getLettre() != unMot.charAt(i)) {
                                System.out.println("Le mot rencontre un autre mot, et n'a pas de lettre en commun là où ils ce croisent");
                                return false;
                            }
                        } else {
                            System.out.println("Il y a une case de type " + grilleDeCases[x][i+y].getClass().toString() + " ici");
                            return false;
                        }
                    }
                }

            } else {
                for (int i=0;i < unMot.length();i++) {
                    if (!(grilleDeCases[i+x][y] instanceof CaseVide)) {
                        if (grilleDeCases[i+x][y] instanceof CaseLettre) {
                            if (((CaseLettre) grilleDeCases[i + x][y]).getLettre() != unMot.charAt(i)) {
                                System.out.println("Le mot rencontre un autre mot, et n'a pas de lettre en commun là où ils ce croisent");
                                return false;
                            }
                        } else {
                            System.out.println("Il y a une case de type " + grilleDeCases[x][i+y].getClass().toString() + " ici");
                            return false;
                        }

                    }
                }
            }
        }

        System.out.println("Le mot peut être placé");
        return true;

    }

    public boolean ajouterMotHorizontal(String unMot, int x , int y) {

        unMot = unMot.toLowerCase();

        if (unMot.length()+x>largeur) {
            System.out.println("le mot : "+unMot+" est trop long");
        } else {
            if(canWordBePlaced(unMot, x, y, false)) {

                for (int i=0;i < unMot.length();i++) {
                    grilleDeCases[i+x][y] = new CaseLettre(new Coordonnee(i+x, y), unMot.charAt(i)) ;
                }
                return true;
            }
        }
        return false;
    }

    public boolean ajouterMotVertical(String unMot, int x , int y) {

        unMot = unMot.toLowerCase();

        if (unMot.length()+y>hauteur) {
            System.out.println("le mot : "+unMot+" est trop long");
        } else {
            if(canWordBePlaced(unMot, x, y, true)) {
                for (int i = 0; i < unMot.length(); i++) {
                    grilleDeCases[x][i + y] = new CaseLettre(new Coordonnee(x, i + y), unMot.charAt(i));
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Permet de placer une case aux coordonnées fournies
     * @param uneCase
     * @return
     */
    public boolean setCaseAt(Case uneCase, Coordonnee coordonnee) {
        this.grilleDeCases[coordonnee.x][coordonnee.y] = uneCase;
        return true;
    }

    /**
     * renvoi la classe de la Case aux coordonnées fournies
     * @param coordonnee
     * @return returns "CaseVide", "CaseLettre", "CaseDefinition" or "CaseDefinitionMultiple" depending on the case at the coordinate
     */
    public EnumCase checkCaseAt(Coordonnee coordonnee) {
        Case caseAt = this.grilleDeCases[coordonnee.x][coordonnee.y];
        return EnumCase.getClassEnum(caseAt);
    }

    public EnumCase checkCaseAt(int x, int y) {
        Case caseAt = this.grilleDeCases[x][y];
        return EnumCase.getClassEnum(caseAt);
    }

    public ArrayList<String> findWord(int x, int y, Dir direction) {

        String availableCasesString = checkAvailableCases(x, y, direction);
        int emptyCases = 0;
        StringBuilder regexTemp = new StringBuilder();

        for (char c : availableCasesString.toCharArray()) {
            if (c == '.') {
                emptyCases++;
            }
            else {
                regexTemp.append("[a-zA-Zéèçàù]{").append(emptyCases).append("}").append(c);
                emptyCases = 0;
            }
        }
        regexTemp.append("[a-zA-Zéèçàù]{0,").append(emptyCases).append("}");

        try {
            return AutoCompletion.findWordWithRegex(regexTemp.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
            return new ArrayList<>();
        }


    }

    /**
     * Permet de vérifier le nombre de cases dispo, pour l'auto complétion
     * @param x
     * @param y
     * @param direction de la définition associé
     * @return either the ArrayList<String[]> or null if the word is too long
     */
    public String checkAvailableCases (int x, int y, Dir direction) {

        Coordonnee checkFromCase = new Coordonnee(0,0);

        int nbCaseDispo = 0;

        StringBuilder stringTemp = new StringBuilder();

        GetWordCoordonneeFromDir(x, y, direction, checkFromCase);

        try {
            if (direction == Dir.HORIZONTALDIRECT || direction == Dir.HORIZONTALINDIRECT) {
                // Pour les mots horizontaux

                for (int i = checkFromCase.x; i < this.largeur; i++) {
                    if (this.grilleDeCases[i][checkFromCase.y] instanceof CaseVide) {
                        nbCaseDispo++;
                        stringTemp.append(".");
                    }
                    else if (this.grilleDeCases[i][checkFromCase.y] instanceof CaseLettre caseLettre) {
                        stringTemp.append(caseLettre.getLettreString());
                    } else {
                        break;
                    }
                }

            } else {
                // Pour les mots verticaux
                for (int i = checkFromCase.y; i < this.hauteur; i++) {
                    if (this.grilleDeCases[checkFromCase.x][i] instanceof CaseVide) {
                        nbCaseDispo++;
                        stringTemp.append(".");
                    }
                    else if (this.grilleDeCases[checkFromCase.x][i] instanceof CaseLettre caseLettre) {
                        stringTemp.append(caseLettre.getLettreString());
                    }
                    else {
                        break;
                    }
                }
            }

        } catch (IndexOutOfBoundsException ignored) {

        }
        System.out.println("Fonction check available cases, resultat = " + stringTemp.toString() + "\n");
        return stringTemp.toString();
    }

    private void GetWordCoordonneeFromDir(int x, int y, Dir direction, Coordonnee checkFromCase) {
        switch (direction) {
            case VERTICALDIRECT, HORIZONTALINDIRECT -> {
                checkFromCase.y = y + 1;
                checkFromCase.x = x;
            }
            case VERTICALINDIRECT, HORIZONTALDIRECT -> {
                checkFromCase.y = y;
                checkFromCase.x = x + 1;
            }
        }
    }

    public Case[][] getTableauDeCases() {
        return grilleDeCases;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }
}
