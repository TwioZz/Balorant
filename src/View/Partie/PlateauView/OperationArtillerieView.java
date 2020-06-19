package View.Partie.PlateauView;

import Models.Case.Case;
import Models.Constants;
import Models.Mode.OperationArtillerieModel;
import Models.Mode.Partie;
import Models.Plateau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Vue de l'opération artillerie (Sélection des coordonnées)
 */
public class OperationArtillerieView extends JPanel implements Observer {

    OperationArtillerieModel operationArtillerieModel;
    Plateau plateau;
    JLabel coord = new JLabel();
    JButton jButtonTirer = new JButton();
    ArrayList<Case> casesInLine = new ArrayList<>();
    ArrayList<Timer> timers = new ArrayList<>();

    public OperationArtillerieView(OperationArtillerieModel operationArtillerieModel, Partie partie, Plateau plateau) {
        this.plateau = plateau;
        this.operationArtillerieModel = operationArtillerieModel;
        operationArtillerieModel.addObserver(this);

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel opArtTir = new JLabel("Opération Artillerie tir :");
        opArtTir.setFont(Constants.MAIN_FONT);
        opArtTir.setHorizontalAlignment(SwingConstants.CENTER);
        add(opArtTir, BorderLayout.NORTH);

        // Jlabel d'attente de sélection
        coord.setText("Veuillez selectionner une ligne");
        coord.setFont(Constants.MAIN_FONT);
        coord.setHorizontalAlignment(SwingConstants.CENTER);
        add(coord, BorderLayout.CENTER);

        jButtonTirer.setText("FEU !");
        jButtonTirer.setEnabled(false);
        jButtonTirer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Fin des timers quand le tir est effectué
                for (Timer timer: timers) {
                    timer.stop();
                }
                operationArtillerieModel.getCaseSelected().setTouchee(true);
                partie.nextTour();
                plateau.getControlledBy().setAlreadyShooted(true);
                jButtonTirer.setEnabled(false);
            }
        });
        add(jButtonTirer, BorderLayout.SOUTH);
    }

    /**
     * Quand une ligne est sélectionnée
     */
    @Override
    public void update(Observable observable, Object o) {
        this.casesInLine = plateau.getAllCaseInLine(this.operationArtillerieModel.getCoordYSelected());
        // Arret des timers déjà en cours
        for (Timer timer: timers) {
            timer.stop();
        }
        this.timers = new ArrayList<>();
        this.jButtonTirer.setEnabled(true);

        // Génération des timers sur les cases "tirable" sur la ligne sélectionnée
        int baseDelay = 500;
        for (Case aCase: casesInLine) {
            if (!aCase.isTouchee()) {
                Timer timer = new Timer(baseDelay, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        coord.setText(aCase.getY() + ":" + aCase.getX());
                        operationArtillerieModel.setCaseSelected(aCase);
                    }
                });
                timer.setRepeats(false);
                timers.add(timer);
                baseDelay = baseDelay + 500;
            }
        }

        // Relance tous les timers quand le dernier arrive à bout
        timers.get(timers.size() - 1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (Timer timer : timers) {
                    timer.start();
                }
            }
        });

        // Commencement de tous les timers
        for (Timer timer: timers) {
            timer.start();
        }
    }
}
