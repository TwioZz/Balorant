package View.Partie.PlateauView.CaseView;

import Controller.Partie.Plateau.Case.CaseController;
import Models.Case;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class CaseView extends JPanel implements Observer {

    private Case aCase; // case is a reserved word
    private boolean plateauAllie;

    public CaseView(Case aCase, boolean plateauAllie) {
        this.plateauAllie = plateauAllie;
        this.aCase = aCase;
        this.aCase.addObserver(this);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new BorderLayout());

        CaseController caseController = new CaseController(aCase, plateauAllie);
        add(caseController, BorderLayout.CENTER);
    }

    @Override
    public void update(Observable observable, Object o) {
        removeAll();
        CaseController caseController = new CaseController(aCase, this.plateauAllie);
        add(caseController, BorderLayout.CENTER);
    }
}
