package View.MainMenu;

import Controller.MainMenu.ChoiceModeController;
import Controller.MainMenu.NombreDeJoueurController;
import Models.Constants;
import Models.MainMenuModel;

import javax.swing.*;
import java.awt.*;


/**
 * Jpanel contenant les options de la partie (IA, Joueur, Mode de jeu)
 *
 */
public class OptionPartie extends JPanel {
    public OptionPartie(MainMenuModel mainMenuModel) {
        this.setLayout(new GridLayout(2, 2));

        // Sélection des joueurs
        JLabel jLabelChoiceJoueur = new JLabel("Qui doit s'affronter : ");
        jLabelChoiceJoueur.setFont(Constants.MAIN_FONT);
        jLabelChoiceJoueur.setHorizontalAlignment(JLabel.CENTER);
        this.add(jLabelChoiceJoueur);
        this.add(new NombreDeJoueurController(mainMenuModel));

        // Mode de jeu
        JLabel jLabelChoiceMode = new JLabel("Choisissez un mode :");
        jLabelChoiceMode.setFont(Constants.MAIN_FONT);
        jLabelChoiceMode.setHorizontalAlignment(JLabel.CENTER);
        this.add(jLabelChoiceMode);
        this.add(new ChoiceModeController(mainMenuModel));

        this.setPreferredSize(new Dimension(400, 400));
    }
}
