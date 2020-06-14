package View.Partie;

import Models.Partie;
import View.Partie.PlateauView.PlateauView;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class PartieView extends JPanel implements Observer {

    private Partie partie;

    public PartieView(Partie partie) {
        this.partie = partie;
        partie.addObserver(this);

        add(new PlateauView(partie.getPlateaux().get(0)));
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
