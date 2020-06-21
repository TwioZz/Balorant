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
 * Controleur d'une case
 */
public class CaseController extends JPanel  {
    private OperationArtillerieModel operationArtillerieModel;

    /**
     * Constructeur dans le cas d'une opération artillerie
     * @param aCase La case
     * @param partie La partie
     * @param plateau Le plateau
     * @param plateauAllie Si le plateau est un plateau allié
     * @param operationArtillerieModel Le model si le mode est opération artillerie ou alerte rouge
     */
    public CaseController(Case aCase, Partie partie, Plateau plateau, boolean plateauAllie, OperationArtillerieModel operationArtillerieModel) {
        this.operationArtillerieModel = operationArtillerieModel;
        contructObjet(aCase, partie, plateau, plateauAllie);
    }

    public CaseController(Case aCase, Partie partie, Plateau plateau, boolean plateauAllie) {
        contructObjet(aCase, partie, plateau, plateauAllie);
    }

    /**
     * Constructeur afin de diminuer la duplication (Une ligne en plus dans le cas d'une opération artillerie)
     * @param aCase La case
     * @param partie La partie
     * @param plateau Le plateau
     * @param plateauAllie Si le plateau est un plateau allié
     */
    private void contructObjet(Case aCase, Partie partie, Plateau plateau, boolean plateauAllie) {
        setLayout(new BorderLayout());
        JButton jButtonCase = new JButton();

        // Si le mode n'est pas opération artillerie
        if (this.operationArtillerieModel == null) {
            jButtonCase.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if (!plateau.getControlledBy().isAlreadyGotShot()) {
                        aCase.setTouchee(true);
                        partie.nextTour();
                        plateau.getControlledBy().setAlreadyGotShot(true);
                    }
                    jButtonCase.setEnabled(false);
                }
            });
        }
        // Si le mode est opération artillerie. Mise à jour du model pour la vue de l'opération artillerie
        else {
            jButtonCase.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if (!plateau.getControlledBy().isAlreadyGotShot()) {
                        operationArtillerieModel.setCoordYSelected(aCase.getY());
                    }
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
