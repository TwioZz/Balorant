package View.Partie.PlateauView;

import Models.Mode.Partie;
import Models.Plateau;

import javax.swing.*;
import java.awt.*;

/**
 * Vue contenant les 2 plateaux
 */
public class PlateauxView extends JPanel {

    public PlateauxView(Plateau plateauEnnemi, Plateau plateauAllie, Partie partie) {
        setLayout(new GridLayout(2, 1));

        PlateauView plateauViewEnnemi = new PlateauView(plateauEnnemi, partie, false);
        plateauViewEnnemi.setPreferredSize(new Dimension(400, 400));
        PlateauView plateauViewAllie = new PlateauView(plateauAllie, partie, true);
        plateauViewAllie.setPreferredSize(new Dimension(400, 400));

        add(plateauViewEnnemi, BorderLayout.CENTER);
        add(plateauViewAllie, BorderLayout.SOUTH);
    }
}
