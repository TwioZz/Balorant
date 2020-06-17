package Controller.Partie.Plateau.Case;

import Models.*;
import Models.Navire.Navire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CasePlacementBateauController extends JPanel {
    private Case aCase;
    private Plateau plateau;
    private PlacementBateau placementBateau;

    public CasePlacementBateauController(Case aCase, Plateau plateau, PlacementBateau placementBateau) {
        this.aCase = aCase;
        this.plateau = plateau;
        this.placementBateau = placementBateau;

        setLayout(new BorderLayout());
        JButton jButtonCase = new JButton();
        jButtonCase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                plateau.placementDuNavire(plateau.prochainBateauAPlacer(), aCase);
            }
        });

        jButtonCase.setPreferredSize(new Dimension(25, 25));

        // Désactivation du jbutton quand tous les bateaux sont placés
        if (plateau.prochainBateauAPlacer() == null) {
            jButtonCase.setEnabled(false);
        }

        // Désactivation du boutton quand le bateau ne peut pas etre placé à cause de la bordure
        int tailleBateauAPlacer = plateau.prochainBateauAPlacer().getStructure().size();
        if (this.placementBateau.getPlacement().equals(Constants.PLACEMENT_HORIZONTAL)) {
            if (!(aCase.getX() <= tailleBateauAPlacer)) {
                jButtonCase.setEnabled(false);
            }
        } else if (this.placementBateau.getPlacement().equals(Constants.PLACEMENT_VERTICAL)) {
            if (!(aCase.getY() <= tailleBateauAPlacer)) {
                jButtonCase.setEnabled(false);
            }
        }

        if (aCase instanceof CaseBateau) {
            jButtonCase.setBackground(Color.GRAY);
        } else {
            jButtonCase.setBackground(Color.BLUE);
        }

        add(jButtonCase, BorderLayout.CENTER);
    }
}
