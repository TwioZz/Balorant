package Models.Case;

import java.util.Observable;

/**
 *  Objet Case qui constitue le plateau
 */

public class Case extends Observable {
    private boolean touchee;
    private int x;
    private int y;

    /**
     * Defini une case grâce
     * @param touchee si elle est touchée ou non
     * @param x sa position x
     * @param y sa position y
     */
    public Case(boolean touchee, int x, int y) {
        this.touchee = touchee;
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return Si le bateau est touché ou non
     */
    public boolean isTouchee() {
        return touchee;
    }

    /**
     * Quand on touche le bateau change son état
     * @param touchee
     * et notifie la vue
     */
    public void setTouchee(boolean touchee) {
        this.touchee = touchee;
        setChanged();
        notifyObservers();
    }

    /**
     *
     * @return la valeur de x
     */
    public int getX() {
        return x;
    }

    /**
     * Change la valeur de x
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return la valeur de x
     */
    public int getY() {
        return y;
    }

    /**
     * Change la valeur de y
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }
}
