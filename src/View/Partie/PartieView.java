package View.Partie;

import Models.Constants;
import Models.Partie;
import Models.PlacementBateau;
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
        jLabelTir.setFont(Constants.MAIN_TITLE_FONT);
        jLabelTir.setHorizontalAlignment(SwingConstants.CENTER);
        add(jLabelTir, BorderLayout.NORTH);

        PlacementBateau placementBateau = new PlacementBateau();
        PlacementBateauView placementBateauView = new PlacementBateauView(partie.getPlateaux().get(0), placementBateau);
        add(placementBateauView, BorderLayout.CENTER);
    }

    @Override
    public void update(Observable observable, Object o) {
        removeAll();
        if (partie.getTour() < 3) {
            PlacementBateau placementBateau = new PlacementBateau();
            PlacementBateauView placementBateauView = new PlacementBateauView(partie.getPlateaux().get(1), placementBateau);
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
