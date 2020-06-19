package Controller.MainMenu;

import Launcher.Balorant;
import Models.Constants;
import Models.MainMenuModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controleur de gestion pour les bouttons du choix du mode de jeu
 *
 */
public class ChoiceModeController extends JPanel {
    private MainMenuModel mainMenuModel;

    /**
     *  Instanciation des jButton et de leur ActionListener pour le choix du mode de jeu
     * @param mainMenuModel coix du mode de jeu
     */
    public ChoiceModeController(MainMenuModel mainMenuModel) {
        this.mainMenuModel = mainMenuModel;
        /**
         * jButton pour le mode : Bataille Navale
         */
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
        /**
         *  jButton pour le mode : Alerte Rouge
         */
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
        /**
         *  jButton pour le mode : Opération Artillerie
         */
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
        /**
         *  jButton pour le mode : Mission Radar
         */
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
