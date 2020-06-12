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
        this.mainMenuModel.setBackgroundColor(new Color(0, 255, 0));
        this.mainMenuModel.addObserver(this);
        this.mainMenuModel.setBackgroundColor(new Color(255, 0, 0));
        add(new JLabel("Balorant !"));
        this.setBackground(this.mainMenuModel.getBackgroundColor());
    }

    @Override
    public void update(Observable observable, Object o) {
        this.setBackground(this.mainMenuModel.getBackgroundColor());
    }
}
