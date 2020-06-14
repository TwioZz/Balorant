package View.MainMenu;

import Controller.MainMenu.ChoiceModeController;
import Controller.MainMenu.NombreDeJoueurController;
import Models.MainMenuModel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;


/**
 * Jpanel contenant les options de la partie (IA, Joueur, Mode de jeu)
 *
 */
public class OptionPartie extends JPanel implements Observer {

    private MainMenuModel mainMenuModel;

    public OptionPartie(MainMenuModel mainMenuModel) {
        this.mainMenuModel = mainMenuModel;
        this.mainMenuModel.addObserver(this);

        this.setLayout(new GridLayout(2, 2));

        JLabel jLabelChoiceJoueur = new JLabel("Qui doit s'affronter : ");
        jLabelChoiceJoueur.setFont(new Font("Serif", Font.PLAIN, 24));
        jLabelChoiceJoueur.setHorizontalAlignment(JLabel.CENTER);
        this.add(jLabelChoiceJoueur);
        this.add(new NombreDeJoueurController(mainMenuModel));

        JLabel jLabelChoiceMode = new JLabel("Choisissez un mode :");
        jLabelChoiceMode.setFont(new Font("Serif", Font.PLAIN, 24));
        jLabelChoiceMode.setHorizontalAlignment(JLabel.CENTER);
        this.add(jLabelChoiceMode);
        this.add(new ChoiceModeController(mainMenuModel));

        this.setPreferredSize(new Dimension(400, 400));
    }


    @Override
    public void update(Observable observable, Object o) {

    }
}
