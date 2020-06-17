package View.Partie.PlateauView.CaseView;

import Controller.Partie.Plateau.Case.CaseController;
import Models.Case;
import Models.Partie;
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

    public CaseView(Case aCase, Partie partie, Plateau plateau, boolean plateauAllie) {
        this.plateauAllie = plateauAllie;
        this.partie = partie;
        this.aCase = aCase;
        this.aCase.addObserver(this);
        this.plateau = plateau;
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new BorderLayout());

        CaseController caseController = new CaseController(aCase, partie, plateau, plateauAllie);
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
