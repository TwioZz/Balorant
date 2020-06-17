package Models.Navire;

import Models.Array.LimitedArrayList;
import Models.CaseBateau;

import java.util.ArrayList;

public abstract class Navire {
    protected LimitedArrayList<CaseBateau> structure;
    private boolean place;
    private String nom;

    public Navire(String nom) {
        this.place = false;
        this.nom = nom;
    }

    /**
     * @return isCoule un boolean qui indique si le bateau est coulé
     */
    public boolean isCoule() {
        boolean isCoule = true;

        // Un bateau non placé est automatiquement coulé
        if (!place) {
            return true;
        }

        // Dès que la boucle croise une case non touchée, le bateau n'est donc pas coulé
        for (CaseBateau caseBateau: structure) {
            if (!caseBateau.isTouchee()) {
                isCoule = false;
                break;
            }
        }

        return isCoule;
    }

    public boolean isPlace() {
        return place;
    }

    public void setPlace(boolean place) {
        this.place = place;
    }

    public ArrayList<CaseBateau> getStructure() {
        return structure;
    }

    @Override
    public String toString() {
        return this.nom;
    }
}
