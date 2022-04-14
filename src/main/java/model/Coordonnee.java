package model;

public class Coordonnee {

    private int posX;
    private int posY;

    public Coordonnee(int x, int y) {
        posX = x;
        posY = y;
    }

    public int getPosY() {
        return posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int x) {
        this.posX = x;
    }

    public void setPosY(int y) {
        this.posY = y;
    }

}
