package Controller.Partie.Plateau.Case;

import Models.*;
import Models.Case.Case;
import Models.Case.CaseBateau;

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
                plateau.placementDuNavire(plateau.prochainBateauAPlacer(), aCase, placementBateau.getPlacement());
            }
        });

        jButtonCase.setPreferredSize(new Dimension(25, 25));

        // Désactivation du jbutton quand tous les bateaux sont placés
        if (plateau.prochainBateauAPlacer() == null) {
            jButtonCase.setEnabled(false);
        }

        // Désactivation du boutton quand le bateau ne peut pas etre placé à cause de la bordure ou d'un autre bateau
        if (plateau.prochainBateauAPlacer() != null) {
            int tailleBateauAPlacer = plateau.prochainBateauAPlacer().getStructure().size();
            if (this.placementBateau.getPlacement().equals(Constants.PLACEMENT_HORIZONTAL)) {
                if (aCase.getX() > 10 - tailleBateauAPlacer) {
                    jButtonCase.setEnabled(false);
                }
            } else if (this.placementBateau.getPlacement().equals(Constants.PLACEMENT_VERTICAL)) {
                if (aCase.getY() > 10 - tailleBateauAPlacer) {
                    jButtonCase.setEnabled(false);
                }
            }

            for (CaseBateau caseBateau: plateau.getCasesBateau()) {
                if (this.placementBateau.getPlacement().equals(Constants.PLACEMENT_HORIZONTAL)) {
                    if (aCase.getX() > caseBateau.getX() - tailleBateauAPlacer && aCase.getX() < caseBateau.getX() && aCase.getY() == caseBateau.getY()) {
                        jButtonCase.setEnabled(false);
                    }
                } else if (this.placementBateau.getPlacement().equals(Constants.PLACEMENT_VERTICAL)) {
                    if (aCase.getY() > caseBateau.getY() - tailleBateauAPlacer && aCase.getY() < caseBateau.getY() && aCase.getX() == caseBateau.getX()) {
                        jButtonCase.setEnabled(false);
                    }
                }
            }
        }

        // Choix de la couleur en fonction de l'etat de la case
        if (aCase instanceof CaseBateau) {
            jButtonCase.setBackground(Constants.CASE_COLOR_BATEAU_ALLIE);
            jButtonCase.setEnabled(false);
        } else if (!jButtonCase.isEnabled()) {
            jButtonCase.setBackground(Constants.CASE_COLOR_BATEAU_COULE);
        } else {
            jButtonCase.setBackground(Constants.CASE_COLOR_PAS_TOUCHEE);
        }

        add(jButtonCase, BorderLayout.CENTER);
    }
}
