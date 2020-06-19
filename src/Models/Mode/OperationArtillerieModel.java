package Models.Mode;

import Models.Case.Case;

import java.util.Observable;

/**
 * Modèle spécifique pour l'Opération Artillerie
 */
public class OperationArtillerieModel extends Observable {
    int coordYSelected;
    Case caseSelected;

    /**
     *
     * @return le coordonnée Y sélectionné
     */
    public int getCoordYSelected() {
        return coordYSelected;
    }

    /**
     * Défini la coordonnée Y sélectionné par
     * @param coordYSelected
     * et notifie la vue
     */
    public void setCoordYSelected(int coordYSelected) {
        this.coordYSelected = coordYSelected;
        setChanged();
        notifyObservers();
    }

    /**
     *
     * @return la case sélectionnée
     */
    public Case getCaseSelected() {
        return caseSelected;
    }

    /**
     * Défini la case sélectionné sur
     * @param caseSelected
     */
    public void setCaseSelected(Case caseSelected) {
        this.caseSelected = caseSelected;
    }
}