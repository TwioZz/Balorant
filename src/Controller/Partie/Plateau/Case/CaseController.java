package Controller.Partie.Plateau.Case;

import Models.Case;
import Models.CaseBateau;
import Models.Partie;
import Models.Plateau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CaseController extends JPanel  {
    private Case aCase;

    public CaseController(Case aCase, Partie partie, Plateau plateau, boolean plateauAllie) {
        this.aCase = aCase;

        setLayout(new BorderLayout());
        JButton jButtonCase = new JButton();
        jButtonCase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!plateau.getControlledBy().isAlreadyShot()) {
                    aCase.setTouchee(true);
                    partie.nextTour();
                    plateau.getControlledBy().setAlreadyShot(true);
                }
                jButtonCase.setEnabled(false);
            }
        });

        jButtonCase.setPreferredSize(new Dimension(25, 25));
        jButtonCase.setBackground(Color.BLUE);

        // Affichage des bateaux si c'est le plateau allié & désactivation des cases
        if (plateauAllie) {
            if (aCase instanceof CaseBateau) {
                jButtonCase.setBackground(Color.GRAY);
            }
            jButtonCase.setEnabled(false);
        }

        // Si la case a déjà été touchée
        if (aCase.isTouchee()) {
            if (aCase instanceof CaseBateau) {
                ArrayList<CaseBateau> caseBateausCoule = plateau.getBateauCoule();
                if (caseBateausCoule.contains(aCase)) {
                    jButtonCase.setBackground(Color.RED);
                } else {
                    jButtonCase.setBackground(Color.GREEN);
                }
            } else {
                jButtonCase.setBackground(new Color(4, 2, 52));
            }
            jButtonCase.setEnabled(false);
        }

        add(jButtonCase, BorderLayout.CENTER);
    }

}
