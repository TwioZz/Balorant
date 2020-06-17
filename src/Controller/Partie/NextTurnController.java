package Controller.Partie;

import Models.Partie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextTurnController extends JPanel {
    private Partie partie;

    public NextTurnController(Partie partie) {
        this.partie = partie;

        JButton jButtonNextTurn = new JButton("Tour Suivant");
        jButtonNextTurn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                partie.nextTour();
            }
        });

        add(jButtonNextTurn);
    }
}
