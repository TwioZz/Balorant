package Launcher;

import Models.Constants;
import Models.MainMenuModel;
import Models.Mode.*;
import View.MainMenu.MainMenuView;
import View.Partie.PartieView;

import javax.swing.*;
import java.awt.*;


/**
 * Classe de gestion de la Jframe
 *
 */
public class Balorant extends JFrame {

    private static Balorant mainMenuJframe;
    private static Balorant inGameJframe;

    /**
     * Lance le menu principal de l'application
     */
    public static void launchMainMenu() {
        if (inGameJframe != null) {
            inGameJframe.dispose();
        }

        Balorant balorantMainMenu = new Balorant();
        MainMenuModel mainMenuModel = new MainMenuModel();
        MainMenuView mainMenuView = new MainMenuView(mainMenuModel);

        balorantMainMenu.add(mainMenuView);
        balorantMainMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        balorantMainMenu.setVisible(true);
        balorantMainMenu.pack();

        mainMenuJframe = balorantMainMenu;
    }


    /**
     * Ferme le menu et lance une partie de bataille navale
     *
     * @param nombreDejoueur Nombre de joueur humain afin de créer une instance de plateau en fonction
     */
    public static void lauchPartie(int nombreDejoueur, String parameterMode) {
        mainMenuJframe.dispose();

        Balorant balorantBatailleNavale = new Balorant();

        Partie partie = null;
        if (parameterMode.equals(Constants.MISSION_RADAR)) {
            partie = new MissionRadar();
        } else if (parameterMode.equals(Constants.OPERATION_ARTILLERIE)) {
            partie = new OperationArtillerie();
        } else if (parameterMode.equals(Constants.ALERTE_ROUGE)) {
            partie = new AlerteRouge();
        } else {
            partie = new BatailleNavale();
        }

        PartieView partieView = new PartieView(partie);
        balorantBatailleNavale.add(partieView);
        balorantBatailleNavale.setDefaultCloseOperation(EXIT_ON_CLOSE);
        balorantBatailleNavale.setVisible(true);
        balorantBatailleNavale.setSize(new Dimension(1920, 1080));

        inGameJframe = balorantBatailleNavale;
    }
}
