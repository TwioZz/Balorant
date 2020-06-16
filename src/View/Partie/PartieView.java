package View.Partie;

import Models.Partie;
import View.Partie.PlateauView.PlacementBateauView;
import View.Partie.PlateauView.PlateauView;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class PartieView extends JPanel implements Observer {

    private Partie partie;

    public PartieView(Partie partie) {
        this.partie = partie;
        partie.addObserver(this);
        setLayout(new BorderLayout());

        JLabel jLabelTir = new JLabel("Placement des bateaux");
        add(jLabelTir, BorderLayout.NORTH);

        PlacementBateauView placementBateauView = new PlacementBateauView(partie.getPlateaux().get(0));
        add(placementBateauView, BorderLayout.CENTER);
    }

    @Override
    public void update(Observable observable, Object o) {
        removeAll();
        if (partie.getTour() < 3) {
            PlacementBateauView placementBateauView = new PlacementBateauView(partie.getPlateaux().get(1));
            add(placementBateauView, BorderLayout.CENTER);
        } else {
            PlateauView plateauViewEnemie = new PlateauView(partie.getPlateaux().get(0), false);
            plateauViewEnemie.setPreferredSize(new Dimension(400, 400));
            PlateauView plateauViewAllie = new PlateauView(partie.getPlateaux().get(1), true);
            plateauViewAllie.setPreferredSize(new Dimension(400, 400));


            add(plateauViewEnemie, BorderLayout.CENTER);
            add(plateauViewAllie, BorderLayout.SOUTH);
        }
    }
}
