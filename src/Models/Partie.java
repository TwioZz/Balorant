package Models;

import Models.Array.LimitedArrayList;

import java.util.ArrayList;
import java.util.Observable;

public class Partie extends Observable {
    private LimitedArrayList<Plateau> plateaux;
    private int tour;

    public Partie() {
        this.tour = 1;
        this.plateaux = new LimitedArrayList<>(2);
        Plateau plateau1 = new Plateau();
        Plateau plateau2 = new Plateau();
        this.plateaux.add(plateau1);
        this.plateaux.add(plateau2);
    }

    public ArrayList<Plateau> getPlateaux() {
        return plateaux;
    }

    public int getTour() {
        return tour;
    }

    public void nextTour() {
        this.tour = this.tour + 1;
        setChanged();
        notifyObservers();
    }
}
