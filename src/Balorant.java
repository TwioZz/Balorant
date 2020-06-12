import Controller.MainMenu.MainMenuController;
import Models.MainMenuModel;
import View.MainMenu.MainMenuView;

import javax.swing.*;
import java.awt.*;

/**
 * Classe principale, qui va exécuter l'application.
 *
 *
 * @version 1.1
 * @author Aurélien le lémurien, Valentin le chevrotin, Louis la truie & Yoyo l'escargot
 */

public class Balorant extends JFrame {

    public Balorant() {
        super();
        MainMenuModel mainMenuModel = new MainMenuModel();
        MainMenuView mainMenuView = new MainMenuView(mainMenuModel);
        mainMenuView.add(new MainMenuController(mainMenuModel));

        this.add(mainMenuView);
    }


    /**
     *  Lance l'application
     *
     * @param args paramètres d'exécutions
     */
    public static void main(String args[]) {
        Balorant balorant = new Balorant();
        balorant.setSize(new Dimension(1920,1080));
        balorant.setDefaultCloseOperation(EXIT_ON_CLOSE);
        balorant.setVisible(true);
    }
}
