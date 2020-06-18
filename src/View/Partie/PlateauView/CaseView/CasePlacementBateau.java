package View.Partie.PlateauView.CaseView;

import Controller.Partie.Plateau.Case.CasePlacementBateauController;
import Models.Case.Case;
import Models.PlacementBateau;
import Models.Plateau;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class CasePlacementBateau extends JPanel implements Observer {
    private Case aCase; // case is a reserved word
    private Plateau plateau;

    public CasePlacementBateau(Case aCase, Plateau plateau, PlacementBateau placementBateau) {
        this.plateau = plateau;
        this.aCase = aCase;
        this.aCase.addObserver(this);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new BorderLayout());

        CasePlacementBateauController casePlacementBateauController = new CasePlacementBateauController(aCase, plateau, placementBateau);
        add(casePlacementBateauController, BorderLayout.CENTER);
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
