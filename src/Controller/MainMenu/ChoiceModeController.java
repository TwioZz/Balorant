package Controller.MainMenu;

import Launcher.Balorant;
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

        JButton batailleNavale = new JButton("Bataille navale");
        batailleNavale.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        int nombreDejoueur = mainMenuModel.getNombreDeJoueurHumain();
                        Balorant.lauchBatailleNavale(nombreDejoueur);
                    }
                }
        );

        JButton codeRouge = new JButton("Code Rouge");
        batailleNavale.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
//                        Balorant.lauchCodeRouge();
                    }
                }
        );

        JButton missionArtillerie = new JButton("Mission artillerie");
        batailleNavale.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
//                        Balorant.lauchMissionArtillerie();
                    }
                }
        );

        JButton operationRadar = new JButton("0pération Radar");
        batailleNavale.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
//                        Balorant.lauchOpérationRadar();
                    }
                }
        );


        this.setLayout(new GridLayout(2, 2));
        this.add(batailleNavale);
        this.add(codeRouge);
        this.add(missionArtillerie);
        this.add(operationRadar);
    }
}
