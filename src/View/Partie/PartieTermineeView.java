package View.Partie;

import Models.Constants;
import Models.Joueur;
import Models.Partie;

import javax.swing.*;
import java.awt.*;

public class PartieTermineeView extends JPanel {
    private Partie partie;

    public PartieTermineeView(Partie partie) {
        setLayout(new BorderLayout());

        Joueur joueurGagnant = partie.getJoueurGagnant();
        JLabel jLabelGagnant = new JLabel(joueurGagnant.getNom() + " À GAGNÉ ! ☻");
        jLabelGagnant.setFont(Constants.MAIN_TIMER_FONT);
        jLabelGagnant.setHorizontalAlignment(SwingConstants.CENTER);

        add(jLabelGagnant, BorderLayout.CENTER);
    }
}
