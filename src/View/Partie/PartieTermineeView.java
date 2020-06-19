package View.Partie;

import Models.Constants;
import Models.Joueur.Joueur;
import Models.Mode.Partie;

import javax.swing.*;
import java.awt.*;

/**
 * Vue quand la partie est terminée, Affichage du vainqueur
 */
public class PartieTermineeView extends JPanel {
    public PartieTermineeView(Partie partie) {
        setLayout(new BorderLayout());

        Joueur joueurGagnant = partie.getJoueurGagnant();
        JLabel jLabelGagnant = new JLabel(joueurGagnant.getNom() + " À GAGNÉ ! ☻");
        jLabelGagnant.setFont(Constants.MAIN_BIG_TITLE_FONT);
        jLabelGagnant.setHorizontalAlignment(SwingConstants.CENTER);

        add(jLabelGagnant, BorderLayout.CENTER);
    }
}
