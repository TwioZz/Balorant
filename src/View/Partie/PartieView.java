package View.Partie;

import Controller.Partie.NextTurnController;
import Models.Constants;
import Models.Partie;
import Models.PlacementBateau;
import Models.Plateau;
import View.Partie.PlateauView.PlacementBateauView;
import View.Partie.PlateauView.PlateauView;
import View.Partie.PlateauView.SwitchView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class PartieView extends JPanel implements Observer {

    private Partie partie;

    public PartieView(Partie partie) {
        this.partie = partie;
        partie.addObserver(this);
        setLayout(new BorderLayout());

        JLabel jLabelTir = new JLabel("Placement des bateaux");
        jLabelTir.setFont(Constants.MAIN_TITLE_FONT);
        jLabelTir.setHorizontalAlignment(SwingConstants.CENTER);
        add(jLabelTir, BorderLayout.NORTH);

        PlacementBateau placementBateau = new PlacementBateau();
        PlacementBateauView placementBateauView = new PlacementBateauView(partie.getPlateaux().get(0), placementBateau);
        add(placementBateauView, BorderLayout.CENTER);
        add(new NextTurnController(partie), BorderLayout.SOUTH);
    }

    @Override
    public void update(Observable observable, Object o) {
        if (partie.getTour() < 3 ) {
            remove(1); // Suppression du BorderLayout.center
            PlacementBateau placementBateau = new PlacementBateau();
            PlacementBateauView placementBateauView = new PlacementBateauView(partie.getPlateaux().get(1), placementBateau);
            add(placementBateauView, BorderLayout.CENTER);
        } else if (partie.isPartieTerminee()) {// Check si la partie est terminée
            removeAll();
            PartieTermineeView partieTermineeView = new PartieTermineeView(partie);
            add(partieTermineeView, BorderLayout.CENTER);
        } else {
            Timer timerSeeTir = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    removeAll();
                    if (partie.getTour() % 2 == 0) {
                        changePlayerView(partie.getPlateaux().get(0), partie.getPlateaux().get(1));
                    } else {
                        changePlayerView(partie.getPlateaux().get(1), partie.getPlateaux().get(0));
                    }
                    updateUI();
                }
            });
            timerSeeTir.setRepeats(false);
            timerSeeTir.start();
        }
        updateUI();
    }

    private void changePlayerView(Plateau plateauAllie, Plateau plateauEnnemie) {
        SwitchView switchView = new SwitchView(partie.getTour(), partie.getPlateaux().get(0).getControlledBy().getNom());
        JLabel jLabelTimer = new JLabel("3");
        jLabelTimer.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelTimer.setFont(Constants.MAIN_TIMER_FONT);
        add(switchView, BorderLayout.NORTH);
        add(jLabelTimer, BorderLayout.CENTER);
        updateUI();

        Timer timer1 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                jLabelTimer.setText("2");
            }
        });
        timer1.setRepeats(false);

        Timer timer2 = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                jLabelTimer.setText("1");
            }
        });
        timer2.setRepeats(false);

        Timer timer3 = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                jLabelTimer.setText("0");
            }
        });
        timer3.setRepeats(false);

        Timer timer4 = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                removeAll();
                plateauAllie.getControlledBy().setAlreadyShot(false);
                PlateauView plateauViewEnemie = new PlateauView(plateauEnnemie, partie, false);
                plateauViewEnemie.setPreferredSize(new Dimension(400, 400));
                PlateauView plateauViewAllie = new PlateauView(plateauAllie, partie, true);
                plateauViewAllie.setPreferredSize(new Dimension(400, 400));
                add(plateauViewEnemie, BorderLayout.CENTER);
                add(plateauViewAllie, BorderLayout.SOUTH);
                updateUI();
            }
        });
        timer4.setRepeats(false);

        timer1.start();
        timer2.start();
        timer3.start();
        timer4.start();
    }
}
