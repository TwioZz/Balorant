package Vue.Menu;

import Controller.Menu.ControllerBatailleNavale;
import Models.MainModel;

import javax.swing.*;

public class MenuVue extends JPanel {

    public MenuVue() {
        super();
        JButton batailleNavale = new JButton("Bataille Navale");
        JButton alerteRouge = new JButton("Alerte Rouge");
        JButton missionRadar = new JButton("Mission Radar");
        JButton operationArtillerie = new JButton("Operation Artillerie");

        ControllerBatailleNavale controllerBatailleNavale = new ControllerBatailleNavale(batailleNavale);
        batailleNavale.addActionListener(controllerBatailleNavale);

        this.add(batailleNavale);
        this.add(alerteRouge);
        this.add(missionRadar);
        this.add(operationArtillerie);
    }
}
