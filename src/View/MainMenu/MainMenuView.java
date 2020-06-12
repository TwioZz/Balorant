package View.MainMenu;

import Models.MainMenuModel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class MainMenuView extends JPanel implements Observer {

    protected MainMenuModel mainMenuModel;

    public MainMenuView(MainMenuModel mainMenuModel) {
        super();
        this.mainMenuModel = mainMenuModel;
        this.mainMenuModel.addObserver(this);
        add(new JLabel("Balorant !"));
        this.setBackground(this.mainMenuModel.getBackgroundColor());
    }

    @Override
    public void update(Observable observable, Object o) {
        this.setBackground(this.mainMenuModel.getBackgroundColor());
    }
}
