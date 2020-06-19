package View.Partie.PlateauView;

import Models.Case.Case;
import Models.Constants;
import Models.Mode.AlerteRouge;
import Models.Mode.OperationArtillerie;
import Models.Mode.OperationArtillerieModel;
import Models.Mode.Partie;
import Models.Plateau;
import View.Partie.PlateauView.CaseView.CaseView;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Vue contenant un seul plateau
 */
public class PlateauView extends JPanel {

    public PlateauView(Plateau plateau, Partie partie, boolean plateauAllie) {
        setLayout(new BorderLayout());

        OperationArtillerieModel operationArtillerieModel = new OperationArtillerieModel();
        JLabel jLabelPlateauType = new JLabel();
        jLabelPlateauType.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelPlateauType.setFont(Constants.MAIN_TITLE_FONT);
        if (plateauAllie) {
            jLabelPlateauType.setText("Votre plateau :");
        } else {
            jLabelPlateauType.setText("Plateau de votre ennemi :");
            // Ajout de la view d'OperationArtillerie si le mode le requière
            if (partie instanceof OperationArtillerie || partie instanceof AlerteRouge) {
                add(new OperationArtillerieView(operationArtillerieModel, partie, plateau), BorderLayout.EAST);
            }
        }
        add(jLabelPlateauType, BorderLayout.NORTH);

        // Grille
        JPanel jPanelGrid = new JPanel();
        jPanelGrid.setLayout(new GridLayout(10,10));
        Border blackBorder = BorderFactory.createLineBorder(Color.black);
        jPanelGrid.setBorder(blackBorder);

        for (Case aCase: plateau.getCases()) {
            CaseView caseView;
            if (partie instanceof OperationArtillerie || partie instanceof AlerteRouge) {
                caseView = new CaseView(aCase, partie, plateau, plateauAllie, operationArtillerieModel);
            } else {
                caseView = new CaseView(aCase, partie, plateau, plateauAllie);
            }

            jPanelGrid.add(caseView);
        }

        add(jPanelGrid, BorderLayout.CENTER);
    }
}
