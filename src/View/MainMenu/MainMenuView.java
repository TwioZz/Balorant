package View.MainMenu;

import Models.Constants;
import Models.MainMenuModel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Menu de l'application Balorant
 */
public class MainMenuView extends JPanel implements Observer {

    protected MainMenuModel mainMenuModel;

    public MainMenuView(MainMenuModel mainMenuModel) {
        super();
        this.mainMenuModel = mainMenuModel;
        this.mainMenuModel.addObserver(this);

        this.setLayout(new BorderLayout());

        JLabel jLabelTitle = new JLabel("Balorant !");
        jLabelTitle.setFont(Constants.MAIN_TITLE_FONT);
        jLabelTitle.setHorizontalAlignment(JLabel.CENTER);
        jLabelTitle.setPreferredSize(new Dimension(600, 200));

        add(jLabelTitle, BorderLayout.NORTH);
        add(new OptionPartie(mainMenuModel), BorderLayout.CENTER);
    }

    @Override
    public void update(Observable observable, Object o) {
    }
}
