import Controller.MainMenu.MainMenuController;
import Models.MainMenuModel;

import javax.swing.*;
import java.awt.*;

/**
 * Classe principale, qui va exécuter l'application.
 *
 *
 * @version 1.1
 * @author Aurélien le lémurien, Valentin le chevrotin, Louis le pingui & Yoyo le motmot
 */

public class Balorant extends JFrame {

    public Balorant() {
        super();
        MainMenuModel mainMenuModel = new MainMenuModel();

        this.add(new MainMenuController(mainMenuModel));
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
