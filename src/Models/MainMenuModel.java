package Models;

import java.util.Observable;

/**
 *  Model du menu pricipal
 */
public class MainMenuModel extends Observable {
    private int nombreDeJoueurHumain;

    public MainMenuModel() {}

    /**
     * Attribue la nouvelle valeur et notifie la vue
     *
     * @param nombreDeJoueurHumain Le nombre de joueur humain
     */
    public void setNombreDeJoueurHumain(int nombreDeJoueurHumain) {
        this.nombreDeJoueurHumain = nombreDeJoueurHumain;
        setChanged();
        notifyObservers();
    }

    /**
     * Getter du nombre de joueur hors IA
     * @return le nombre de joueur humain
     */
    public int getNombreDeJoueurHumain() {
        return nombreDeJoueurHumain;
    }
}
