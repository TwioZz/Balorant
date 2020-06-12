package Models;

import java.awt.*;
import java.util.Observable;

/**
 *  Model du menu pricipal
 */
public class MainMenuModel extends Observable {
    private Color backgroundColor;

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Attribue la nouvelle
     *
     * @param backgroundColor La nouvelle couleur du fond
     */
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        setChanged();
        notifyObservers();
    }

    public MainMenuModel() {
        this.backgroundColor = new Color(192, 229, 38);
    }
}
