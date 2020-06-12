package Controller.MainMenu;

import Models.MainMenuModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainMenuController extends JPanel {
    private MainMenuModel mainMenuModel;

    public MainMenuController(MainMenuModel mainMenuModel) {
        this.mainMenuModel = mainMenuModel;

        JButton jButton = new JButton("Change Color");
        jButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        Random random = new Random();
                        mainMenuModel.setBackgroundColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                    }
                }
        );

        this.add(jButton);
    }
}
