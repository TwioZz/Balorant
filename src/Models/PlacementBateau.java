package Models;

import java.util.Observable;

/**
 * Gère l'orientation des bateaux
 */
public class PlacementBateau extends Observable {
    private String placement;

    /**
     * Défini l'orientation du bateau en horizontal par défaut
     */
    public PlacementBateau() {
        this.placement = Constants.PLACEMENT_HORIZONTAL;
    }

    /**
     * Getter de la position d'un bateau
     * @return L'orientation du bateau
     */
    public String getPlacement() {
        return placement;
    }

    /**
     * Change l'orientation du bateau
     * @param placement Nouvelle orientation
     */
    public void setPlacement(String placement) {
        this.placement = placement;
        setChanged();
        notifyObservers();
    }
}
