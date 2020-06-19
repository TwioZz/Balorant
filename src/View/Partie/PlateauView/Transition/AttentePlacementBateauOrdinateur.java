package View.Partie.PlateauView.Transition;

import Models.Constants;

import javax.swing.*;
import java.awt.*;

/**
 * Ecran d'attente lorsque que l'ordinateur place ses bateaux
 */
public class AttentePlacementBateauOrdinateur extends JPanel{

    public AttentePlacementBateauOrdinateur() {
        setLayout(new BorderLayout());

        JLabel jPanelWainting = new JLabel("L'ordinateur est en train de placer ses bateaux...");
        jPanelWainting.setHorizontalAlignment(SwingConstants.CENTER);
        jPanelWainting.setFont(Constants.MAIN_TITLE_FONT);

        add(jPanelWainting, BorderLayout.CENTER);
    }
}
