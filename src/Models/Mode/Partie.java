package Models.Mode;

import Models.Array.LimitedArrayList;
import Models.Joueur.Joueur;
import Models.Plateau;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Modèle d'une partie
 */
public abstract class Partie extends Observable {
    private LimitedArrayList<Plateau> plateaux;
    private int tour;

    /**
     * Commence la partie en créeant les 2 plateaux des joueurs
     *
     * @param joueur1 Le joueur 1
     * @param joueur2 Le joueur 2
     */
    public Partie(Joueur joueur1, Joueur joueur2) {
        this.tour = 1;
        this.plateaux = new LimitedArrayList<>(2);
        Plateau plateau1 = new Plateau(joueur1);
        Plateau plateau2 = new Plateau(joueur2);
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
