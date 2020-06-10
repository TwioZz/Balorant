package Controller.Menu;

import Controller.MainController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBatailleNavale implements ActionListener {

    private JButton jButtonBatailleNavale;

    public ControllerBatailleNavale(JButton jButtonBatailleNavale) {
        super();
        this.jButtonBatailleNavale = jButtonBatailleNavale;
    };

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("ok");
    }
}
