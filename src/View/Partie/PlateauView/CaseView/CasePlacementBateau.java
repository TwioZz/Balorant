package View.Partie.PlateauView.CaseView;

import Controller.Partie.Plateau.Case.CasePlacementBateauController;
import Models.Case.Case;
import Models.PlacementBateau;
import Models.Plateau;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Vue représentant une case lors du placement des bateaux
 */
public class CasePlacementBateau extends JPanel {
    public CasePlacementBateau(Case aCase, Plateau plateau, PlacementBateau placementBateau) {
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new BorderLayout());

        CasePlacementBateauController casePlacementBateauController = new CasePlacementBateauController(aCase, plateau, placementBateau);
        add(casePlacementBateauController, BorderLayout.CENTER);
    }
}
