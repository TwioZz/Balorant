package Launcher;

import Models.Constants;
import Models.Joueur.Humain;
import Models.Joueur.Joueur;
import Models.Joueur.Ordinateur;
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
     * @param nombreDejoueurHumain Nombre de joueur humain afin de créer une instance de plateau en fonction
     */
    public static void lauchPartie(int nombreDejoueurHumain, String parameterMode) {
        mainMenuJframe.dispose();

        Balorant balorantBatailleNavale = new Balorant();

        Joueur joueur1 = nombreDejoueurHumain > 0 ? new Humain("Joueur 1") : new Ordinateur("Ordinateur 1", 0);
        Joueur joueur2 = nombreDejoueurHumain > 1 ? new Humain("Joueur 2") : new Ordinateur("Ordinateur 2", 0);

        Partie partie;
        switch (parameterMode) {
            case Constants.MISSION_RADAR:
                partie = new MissionRadar(joueur1, joueur2);
                break;
            case Constants.OPERATION_ARTILLERIE:
                partie = new OperationArtillerie(joueur1, joueur2);
                break;
            case Constants.ALERTE_ROUGE:
                partie = new AlerteRouge(joueur1, joueur2);
                break;
            default:
                partie = new BatailleNavale(joueur1, joueur2);
                break;
        }

        PartieView partieView = new PartieView(partie);
        balorantBatailleNavale.add(partieView);
        balorantBatailleNavale.setDefaultCloseOperation(EXIT_ON_CLOSE);
        balorantBatailleNavale.setVisible(true);
        balorantBatailleNavale.setSize(new Dimension(1920, 1080));

        inGameJframe = balorantBatailleNavale;
    }
}
