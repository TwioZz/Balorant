package View.Partie.PlateauView;

import Models.Case.Case;
import Models.Constants;
import Models.Mode.OperationArtillerie;
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

        coord.setText("Veuillez selectionner une ligne");
        coord.setFont(Constants.MAIN_FONT);
        coord.setHorizontalAlignment(SwingConstants.CENTER);
        add(coord, BorderLayout.CENTER);

        jButtonTirer.setText("FEU !");
        jButtonTirer.setEnabled(false);
        jButtonTirer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (Timer timer: timers) {
                    timer.stop();
                }
                operationArtillerieModel.getCaseSelected().setTouchee(true);
                partie.nextTour();
                plateau.getControlledBy().setAlreadyShot(true);
                jButtonTirer.setEnabled(false);
            }
        });
        add(jButtonTirer, BorderLayout.SOUTH);
    }

    @Override
    public void update(Observable observable, Object o) {
        this.casesInLine = plateau.getAllCaseInLine(this.operationArtillerieModel.getCoordYSelected());
        for (Timer timer: timers) {
            timer.stop();
        }
        this.timers = new ArrayList<>();
        this.jButtonTirer.setEnabled(true);

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

        // Relance tous les timer quand le dernier arrive à bout
        timers.get(timers.size() - 1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (Timer timer : timers) {
                    timer.start();
                }
            }
        });

        for (Timer timer: timers) {
            timer.start();
        }
    }
}
