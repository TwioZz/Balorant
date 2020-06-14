package View.Partie.PlateauView;

import Models.Plateau;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class PlateauView extends JPanel implements Observer {
    private Plateau plateau;

    public PlateauView(Plateau plateau) {
        this.plateau = plateau;
        this.plateau.addObserver(this);

        setLayout(new GridLayout(10, 10));
        for (int i = 0; i < 100; i++) {
            // A terme une CaseView
            JButton jButton = new JButton();
            add(jButton);
        }
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
