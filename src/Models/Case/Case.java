package Models.Case;

import java.util.Observable;

public class Case extends Observable {
    private boolean touchee;
    private int x;
    private int y;

    public Case(boolean touchee, int x, int y) {
        this.touchee = touchee;
        this.x = x;
        this.y = y;
    }

    public boolean isTouchee() {
        return touchee;
    }

    public void setTouchee(boolean touchee) {
        this.touchee = touchee;
        setChanged();
        notifyObservers();
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
