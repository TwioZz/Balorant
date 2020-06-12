package Controller.MainMenu;

import Models.MainMenuModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ChoiceModeController extends JPanel {
    private MainMenuModel mainMenuModel;

    public ChoiceModeController(MainMenuModel mainMenuModel) {
        this.mainMenuModel = mainMenuModel;

        JButton batailleNavale = new JButton("Bataille navale");
        batailleNavale.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {

                    }
                }
        );

        JButton codeRouge = new JButton("Code Rouge");
        batailleNavale.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {

                    }
                }
        );

        JButton missionArtillerie = new JButton("Mission artillerie");
        batailleNavale.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {

                    }
                }
        );

        JButton operationRadar = new JButton("0pération Radar");
        batailleNavale.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {

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
