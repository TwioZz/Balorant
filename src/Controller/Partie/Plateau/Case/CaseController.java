package Controller.Partie.Plateau.Case;

import Models.Case;
import Models.CaseBateau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaseController extends JPanel  {
    private Case aCase;

    public CaseController(Case aCase, boolean plateauAllie) {
        this.aCase = aCase;

        setLayout(new BorderLayout());
        JButton jButtonCase = new JButton();
        jButtonCase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                aCase.setTouchee(true);
                jButtonCase.setEnabled(false);
            }
        });

        jButtonCase.setPreferredSize(new Dimension(25, 25));
        jButtonCase.setBackground(Color.BLUE);

        // Si la case a déjà été touchée
        if (aCase.isTouchee()) {
            if (aCase instanceof CaseBateau) {
                jButtonCase.setBackground(Color.GREEN);
            } else {
                jButtonCase.setBackground(Color.GRAY);
            }
        }

        // Désactivation du boutton par default si c'est le plateau allié
        if (plateauAllie) {
            jButtonCase.setEnabled(false);
        }

        add(jButtonCase, BorderLayout.CENTER);
    }

}
