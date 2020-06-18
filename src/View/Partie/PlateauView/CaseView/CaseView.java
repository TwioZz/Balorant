package View.Partie.PlateauView.CaseView;

import Controller.Partie.Plateau.Case.CaseController;
import Models.Case.Case;
import Models.Mode.OperationArtillerieModel;
import Models.Mode.Partie;
import Models.Plateau;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class CaseView extends JPanel implements Observer {

    private Case aCase; // case is a reserved word
    private boolean plateauAllie;
    private Plateau plateau;
    private Partie partie;
    private OperationArtillerieModel operationArtillerieModel;

    public CaseView(Case aCase, Partie partie, Plateau plateau, boolean plateauAllie) {
        constructObject(aCase, partie, plateau, plateauAllie);
    }

    public CaseView(Case aCase, Partie partie, Plateau plateau, boolean plateauAllie, OperationArtillerieModel operationArtillerieModel) {
        this.operationArtillerieModel = operationArtillerieModel;
        constructObject(aCase, partie, plateau, plateauAllie);
    }

    private void constructObject(Case aCase, Partie partie, Plateau plateau, boolean plateauAllie) {
        this.plateauAllie = plateauAllie;
        this.partie = partie;
        this.aCase = aCase;
        this.aCase.addObserver(this);
        this.plateau = plateau;
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new BorderLayout());

        CaseController caseController;
        if (this.operationArtillerieModel == null) {
            caseController = new CaseController(aCase, partie, plateau, plateauAllie);
        } else {
            caseController = new CaseController(aCase, partie, plateau, plateauAllie, operationArtillerieModel);
        }

        add(caseController, BorderLayout.CENTER);
    }

    @Override
    public void update(Observable observable, Object o) {
        removeAll();
        CaseController caseController = new CaseController(aCase, this.partie, this.plateau, this.plateauAllie);
        add(caseController, BorderLayout.CENTER);
        updateUI();
    }
}
