package Models;

import java.util.Observable;

public class PlacementBateau extends Observable {
    private String placement;

    public PlacementBateau() {
        this.placement = Constants.PLACEMENT_HORIZONTAL;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
        setChanged();
        notifyObservers();
    }
}
