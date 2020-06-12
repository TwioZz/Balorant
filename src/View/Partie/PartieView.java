package View.Partie;

import Models.Partie;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class PartieView extends JPanel implements Observer {

    private Partie partie;

    private PartieView(Partie partie) {
        this.partie = partie;
        partie.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
