package View.Partie.PlateauView.Transition;

import Models.Constants;

import javax.swing.*;
import java.awt.*;

/**
 * Ecran d'attente lorsque que l'ordinateur est en train de tirer
 */
public class AttenteTirOrdinateur extends JPanel {

    public AttenteTirOrdinateur() {
        setLayout(new BorderLayout());

        JLabel jPanelWainting = new JLabel("L'ordinateur est en train de choisir une cible...");
        jPanelWainting.setHorizontalAlignment(SwingConstants.CENTER);
        jPanelWainting.setFont(Constants.MAIN_TITLE_FONT);

        add(jPanelWainting, BorderLayout.CENTER);
    }
}
