package Vue;

import Controller.MainController;
import Models.MainModel;
import Vue.Menu.MenuVue;
import Vue.Plateau.PlateauVue;

import javax.swing.*;

public class MainVue {

    private MainModel mainModel;

    public MainVue() {
        MainModel mainModel = new MainModel();
        MainController mainController = new MainController(mainModel);

        JPanel panelToDisplay = null;

        if (mainModel.isInMainMenu()) {
            panelToDisplay = new MenuVue();
        } else if (mainModel.isInPlateau()) {
            panelToDisplay = new PlateauVue();
        }

        JFrame frame = new JFrame("Balorant");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panelToDisplay);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
