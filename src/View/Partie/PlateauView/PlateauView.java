package View.Partie.PlateauView;

import Models.Case;
import Models.Plateau;
import View.Partie.PlateauView.CaseView.CaseView;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class PlateauView extends JPanel implements Observer {
    private Plateau plateau;

    public PlateauView(Plateau plateau, boolean plateauAllie) {
        this.plateau = plateau;
        this.plateau.addObserver(this);
        Border blackBorder = BorderFactory.createLineBorder(Color.black);
        setBorder(blackBorder);


        setLayout(new GridLayout(10, 10));

        for (Case aCase: this.plateau.getCases()) {
            CaseView caseView = new CaseView(aCase, plateauAllie);
            add(caseView);
        }
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
