package Controller.MainMenu;

import Launcher.Balorant;
import Models.Constants;
import Models.MainMenuModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller de gestion pour les bouttons du choix du mode de jeu
 *
 */
public class ChoiceModeController extends JPanel {
    private MainMenuModel mainMenuModel;

    public ChoiceModeController(MainMenuModel mainMenuModel) {
        this.mainMenuModel = mainMenuModel;

        JButton batailleNavale = new JButton(Constants.BATAILLE_NAVALE);
        batailleNavale.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        int nombreDejoueur = mainMenuModel.getNombreDeJoueurHumain();
                        Balorant.lauchPartie(nombreDejoueur, Constants.BATAILLE_NAVALE);
                    }
                }
        );

        JButton alerteRouge = new JButton(Constants.ALERTE_ROUGE);
        alerteRouge.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        int nombreDejoueur = mainMenuModel.getNombreDeJoueurHumain();
                        Balorant.lauchPartie(nombreDejoueur, Constants.ALERTE_ROUGE);
                    }
                }
        );

        JButton operationArtillerie = new JButton(Constants.OPERATION_ARTILLERIE);
        operationArtillerie.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        int nombreDejoueur = mainMenuModel.getNombreDeJoueurHumain();
                        Balorant.lauchPartie(nombreDejoueur, Constants.OPERATION_ARTILLERIE);
                    }
                }
        );

        JButton missionRadar = new JButton(Constants.MISSION_RADAR);
        missionRadar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        int nombreDejoueur = mainMenuModel.getNombreDeJoueurHumain();
                        Balorant.lauchPartie(nombreDejoueur, Constants.MISSION_RADAR);
                    }
                }
        );


        this.setLayout(new GridLayout(2, 2));
        this.add(batailleNavale);
        this.add(alerteRouge);
        this.add(operationArtillerie);
        this.add(missionRadar);
    }
}
