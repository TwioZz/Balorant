package View.Partie.PlateauView;

import Models.Constants;

import javax.swing.*;
import java.awt.*;

public class SwitchView extends JPanel {

    public SwitchView(String nomDuJoueur) {
        JLabel jLabelInfo = new JLabel("Tour de : " + nomDuJoueur);
        jLabelInfo.setFont(Constants.MAIN_TITLE_FONT);
        add(jLabelInfo, BorderLayout.CENTER);
    }
}
