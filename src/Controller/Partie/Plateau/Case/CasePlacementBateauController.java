package Controller.Partie.Plateau.Case;

import Models.Case;
import Models.CaseBateau;
import Models.Navire.Navire;
import Models.Plateau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CasePlacementBateauController extends JPanel {
    private Case aCase;
    private Plateau plateau;

    public CasePlacementBateauController(Case aCase, Plateau plateau) {
        this.aCase = aCase;
        this.plateau = plateau;

        setLayout(new BorderLayout());
        JButton jButtonCase = new JButton();
        jButtonCase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                plateau.placementDuNavire(plateau.prochainBateauAPlacer(), aCase);
            }
        });

        jButtonCase.setPreferredSize(new Dimension(25, 25));

        // Désactivation du boutton quand tous les bateaux sont placés
        if (plateau.prochainBateauAPlacer() == null) {
            jButtonCase.setEnabled(false);
        }

        if (aCase instanceof CaseBateau) {
            jButtonCase.setBackground(Color.GRAY);
        } else {
            jButtonCase.setBackground(Color.BLUE);
        }

        add(jButtonCase, BorderLayout.CENTER);
    }
}
