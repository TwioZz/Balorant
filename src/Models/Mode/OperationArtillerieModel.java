package Models.Mode;

import Models.Case.Case;

import java.util.Observable;

public class OperationArtillerieModel extends Observable {
    int coordYSelected;
    Case caseSelected;

    public int getCoordYSelected() {
        return coordYSelected;
    }

    public void setCoordYSelected(int coordYSelected) {
        this.coordYSelected = coordYSelected;
        setChanged();
        notifyObservers();
    }

    public Case getCaseSelected() {
        return caseSelected;
    }

    public void setCaseSelected(Case caseSelected) {
        this.caseSelected = caseSelected;
    }
}