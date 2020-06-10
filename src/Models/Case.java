package Models;

public class Case {
    private boolean etat;
    private int x;
    private int y;

    public Case(boolean etat, int x, int y) {
        this.etat = etat;
        this.x = x;
        this.y = y;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
