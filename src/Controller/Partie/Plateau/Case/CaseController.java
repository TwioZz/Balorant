package Controller.Partie.Plateau.Case;

import Models.*;
import Models.Case.Case;
import Models.Case.CaseBateau;
import Models.Mode.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Controleur
 */

public class CaseController extends JPanel  {
    private Case aCase;
    private OperationArtillerieModel operationArtillerieModel;

    public CaseController(Case aCase, Partie partie, Plateau plateau, boolean plateauAllie) {
        contructObjet(aCase, partie, plateau, plateauAllie);
    }

    public CaseController(Case aCase, Partie partie, Plateau plateau, boolean plateauAllie, OperationArtillerieModel operationArtillerieModel) {
        this.operationArtillerieModel = operationArtillerieModel;
        contructObjet(aCase, partie, plateau, plateauAllie);
    }

    private void contructObjet(Case aCase, Partie partie, Plateau plateau, boolean plateauAllie) {
        this.aCase = aCase;

        setLayout(new BorderLayout());
        JButton jButtonCase = new JButton();

        if (this.operationArtillerieModel == null) {
            jButtonCase.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if (!plateau.getControlledBy().isAlreadyShot()) {
                        aCase.setTouchee(true);
                        partie.nextTour();
                        plateau.getControlledBy().setAlreadyShot(true);
                    }
                    jButtonCase.setEnabled(false);
                }
            });
        } else {
            jButtonCase.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if (!plateau.getControlledBy().isAlreadyShot()) {
                        operationArtillerieModel.setCoordYSelected(aCase.getY());
                    }
                    jButtonCase.setEnabled(false);
                }
            });
        }


        jButtonCase.setPreferredSize(new Dimension(25, 25));
        jButtonCase.setBackground(Constants.CASE_COLOR_PAS_TOUCHEE);

        // Affichage des bateaux si c'est le plateau allié & désactivation des cases
        if (plateauAllie) {
            if (aCase instanceof CaseBateau) {
                jButtonCase.setBackground(Constants.CASE_COLOR_BATEAU_ALLIE);
            }
            jButtonCase.setEnabled(false);
        }

        // Si la case a déjà été touchée
        if (aCase.isTouchee()) {
            if (aCase instanceof CaseBateau) {
                ArrayList<CaseBateau> caseBateauxCoule = plateau.getBateauCoule();
                if (caseBateauxCoule.contains(aCase)) {
                    jButtonCase.setBackground(Constants.CASE_COLOR_BATEAU_COULE);
                } else {
                    jButtonCase.setBackground(Constants.CASE_COLOR_BATEAU_TOUCHEE);
                }
            } else {
                jButtonCase.setBackground(Constants.CASE_COLOR_TOUCHEE);
            }
            jButtonCase.setEnabled(false);
        }

        // Affichage du bateau le plus proche si le mode le permet et que la case est touchée
        if ((partie instanceof MissionRadar || partie instanceof AlerteRouge) && aCase.isTouchee()) {
            jButtonCase.setText(Integer.toString(plateau.getDistanceBateauLePlusProche(aCase)));
        }

        add(jButtonCase, BorderLayout.CENTER);
    }
}
