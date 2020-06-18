package Models.Mode;

import Models.Array.LimitedArrayList;
import Models.Joueur.Joueur;
import Models.Plateau;

import java.util.ArrayList;
import java.util.Observable;

public class Partie extends Observable {
    private LimitedArrayList<Plateau> plateaux;
    private int tour;

    public Partie() {
        this.tour = 1;
        this.plateaux = new LimitedArrayList<>(2);
        Plateau plateau1 = new Plateau(new Joueur("Joueur 1"));
        Plateau plateau2 = new Plateau(new Joueur("Joueur 2"));
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

    public boolean isPartieTerminee() {
        return this.plateaux.get(0).isAllBateauCoule() || this.plateaux.get(1).isAllBateauCoule();
    }

    public Joueur getJoueurGagnant() {
        if (this.plateaux.get(0).isAllBateauCoule()) {
            return this.plateaux.get(1).getControlledBy();
        } else if (this.plateaux.get(1).isAllBateauCoule()) {
            return this.plateaux.get(0).getControlledBy();
        }
        return null;
    }
}
