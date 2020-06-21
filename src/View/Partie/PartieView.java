package View.Partie;

import Controller.Partie.NextTurnController;
import Models.Constants;
import Models.Joueur.Humain;
import Models.Joueur.Ordinateur;
import Models.Mode.Partie;
import Models.PlacementBateau;
import Models.Plateau;
import View.Partie.PlateauView.LegendeView;
import View.Partie.PlateauView.PlacementBateau.PlacementBateauView;
import View.Partie.PlateauView.PlateauxView;
import View.Partie.PlateauView.Transition.AttentePlacementBateauOrdinateur;
import View.Partie.PlateauView.Transition.AttenteTirOrdinateur;
import View.Partie.PlateauView.Transition.SwitchView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Vue d'une partie entière
 */
public class PartieView extends JPanel implements Observer {

    private Partie partie;

    public PartieView(Partie partie) {
        this.partie = partie;
        partie.addObserver(this);
        setLayout(new BorderLayout());

        // Les deux premiers tour sont consacrés au placement des bateaux
        JLabel jLabelTir = new JLabel("Placement des bateaux");
        jLabelTir.setFont(Constants.MAIN_TITLE_FONT);
        jLabelTir.setHorizontalAlignment(SwingConstants.CENTER);
        add(jLabelTir, BorderLayout.NORTH);

        Plateau plateauAllie = partie.getPlateaux().get(0);
        PlacementBateau placementBateau = new PlacementBateau();
        PlacementBateauView placementBateauView = new PlacementBateauView(plateauAllie, placementBateau);
        add(placementBateauView, BorderLayout.CENTER);
        add(new NextTurnController(partie), BorderLayout.SOUTH);

        // Dans le cas où les deux ia se battent, rien à cacher
        if (partie.getPlateaux().get(0).getControlledBy() instanceof Ordinateur) {
            ((Ordinateur) plateauAllie.getControlledBy()).placerBateaux(plateauAllie);
            partie.nextTour();
        }
    }

    @Override
    public void update(Observable observable, Object o) {
        // Les deux premiers tour sont consacrés au placement des bateaux
        if (partie.getTour() < 3) {
            remove(1); // Suppression du BorderLayout.center
            // Ecran d'attente quand l'ordinateur place ses bateaux
            if (partie.getPlateaux().get(1).getControlledBy() instanceof Ordinateur) {
                AttentePlacementBateauOrdinateur attentePlacementBateauOrdinateur = new AttentePlacementBateauOrdinateur();
                add(attentePlacementBateauOrdinateur, BorderLayout.CENTER);
                Plateau plateauAllie = partie.getPlateaux().get(1);
                ((Ordinateur) plateauAllie.getControlledBy()).placerBateaux(plateauAllie);
                partie.nextTour();
            } else {
                PlacementBateau placementBateau = new PlacementBateau();
                PlacementBateauView placementBateauView = new PlacementBateauView(partie.getPlateaux().get(1), placementBateau);
                add(placementBateauView, BorderLayout.CENTER);
            }
        }
        // Condition de fin de la partie
        else if (partie.isPartieTerminee()) {
            removeAll();
            PartieTermineeView partieTermineeView = new PartieTermineeView(partie);
            add(partieTermineeView, BorderLayout.CENTER);
        }
        // Pour tous les autres tours
        else {
            // Timer afin de voir où on a tiré
            Timer timerSeeTir = new Timer(750, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    removeAll();
                    if (partie.getTour() % 2 == 0) {
                        changePlayerView(partie.getPlateaux().get(1), partie.getPlateaux().get(0));
                    } else {
                        changePlayerView(partie.getPlateaux().get(0), partie.getPlateaux().get(1));
                    }
                    updateUI();
                }
            });
            timerSeeTir.setRepeats(false);
            timerSeeTir.start();
        }
        updateUI();
    }

    /**
     * Méthode de changement des view lors d'un début de tour
     * @param plateauAllie Le plateau Allié
     * @param plateauEnnemi Le plateau Ennemi
     */
    private void changePlayerView(Plateau plateauAllie, Plateau plateauEnnemi) {
        // Reset du plateau afin d'autoriser le tir
        plateauEnnemi.getControlledBy().setAlreadyGotShot(false);

        // Cas Humain contre humain, Il faut cacher le plateau, le temps qu'un joueur détourne le regard
        if (plateauAllie.getControlledBy() instanceof Humain && plateauEnnemi.getControlledBy() instanceof Humain) {
            // Panneau de swith afin de cacher le plateau
            SwitchView switchView = new SwitchView(plateauAllie.getControlledBy().getNom());
            JLabel jLabelTimer = new JLabel("3");
            jLabelTimer.setHorizontalAlignment(SwingConstants.CENTER);
            jLabelTimer.setFont(Constants.MAIN_BIG_TITLE_FONT);
            add(switchView, BorderLayout.NORTH);
            add(jLabelTimer, BorderLayout.CENTER);
            updateUI();

            // 1 seconde
            Timer timer1 = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    jLabelTimer.setText("2");
                }
            });
            timer1.setRepeats(false);

            // 2 secondes
            Timer timer2 = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    jLabelTimer.setText("1");
                }
            });
            timer2.setRepeats(false);

            // 3 secondes
            Timer timer3 = new Timer(3000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    jLabelTimer.setText("0");
                }
            });
            timer3.setRepeats(false);

            // Au bout de 4 secondes, le plateau de l'autre joueur s'affiche
            Timer timer4 = new Timer(4000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    affichageDesPlateaux(plateauEnnemi, plateauAllie);
                }
            });
            timer4.setRepeats(false);

            timer1.start();
            timer2.start();
            timer3.start();
            timer4.start();
        }
        // Cas d'un ordinateur contre ordinateur, affichage des plateaux, rien à cacher
        else if (plateauAllie.getControlledBy() instanceof Ordinateur && plateauEnnemi.getControlledBy() instanceof Ordinateur){
            affichageDesPlateaux(plateauEnnemi, plateauAllie);

            Ordinateur ordinateur = (Ordinateur) plateauAllie.getControlledBy();
            ordinateur.doTir(plateauEnnemi);
            plateauEnnemi.getControlledBy().setAlreadyGotShot(true);
            partie.nextTour();
        }
        // Cas d'un ordinateur qui tire sur un humain, affichage d'un écran d'attente et tir de l'ordinateur
        else if (plateauAllie.getControlledBy() instanceof Ordinateur && plateauEnnemi.getControlledBy() instanceof Humain){
            removeAll();
            add(new AttenteTirOrdinateur(), BorderLayout.CENTER);
            updateUI();

            Ordinateur ordinateur = (Ordinateur) plateauAllie.getControlledBy();
            ordinateur.doTir(plateauEnnemi);
            plateauEnnemi.getControlledBy().setAlreadyGotShot(true);
            partie.nextTour();
        }
        // Cas Humain qui doit tirer sur un ordinateur, pas d'affichage de décompte (Rien à cacher)
        else {
            affichageDesPlateaux(plateauEnnemi, plateauAllie);
        }
    }

    /**
     * Méthode d'affichage des plateaux
     * @param plateauEnnemi Le plateau Ennemi
     * @param plateauAllie Le plateau Allié
     */
    private void affichageDesPlateaux(Plateau plateauEnnemi, Plateau plateauAllie) {
        removeAll();

        PlateauxView lesPlateauxView = new PlateauxView(plateauEnnemi, plateauAllie, partie);

        JLabel jLabelTourDe = new JLabel("Au tour de " + plateauAllie.getControlledBy().getNom());
        jLabelTourDe.setFont(Constants.MAIN_TITLE_FONT);
        jLabelTourDe.setHorizontalAlignment(SwingConstants.CENTER);

        add(jLabelTourDe, BorderLayout.NORTH);
        add(lesPlateauxView, BorderLayout.CENTER);
        add(new LegendeView(), BorderLayout.EAST);
        updateUI();
    }
}
