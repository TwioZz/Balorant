package View.Partie.PlateauView.PlacementBateau;

import Controller.Partie.Plateau.PlacementBateauController;
import Models.Case.Case;
import Models.Constants;
import Models.PlacementBateau;
import Models.Plateau;
import View.Partie.PlateauView.CaseView.CasePlacementBateau;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Vue pour placer les bateaux
 */
public class PlacementBateauView extends JPanel implements Observer {

    private Plateau plateau;
    private PlacementBateau placementBateau;
    private JPanel jPanelGridPlacementBateau;
    private JLabel jLabelProchainBateau;

    public PlacementBateauView(Plateau plateau, PlacementBateau placementBateau) {
        this.plateau = plateau;
        this.plateau.addObserver(this);
        this.placementBateau = placementBateau;
        this.placementBateau.addObserver(this);

        setLayout(new BorderLayout());

        // Grille de placement
        jPanelGridPlacementBateau = new JPanel();
        jPanelGridPlacementBateau.setLayout(new GridLayout(10,10));
        for (Case aCase: this.plateau.getCases()) {
            CasePlacementBateau casePlacementBateau = new CasePlacementBateau(aCase, plateau, placementBateau);
            jPanelGridPlacementBateau.add(casePlacementBateau);
        }

        // Volet droit d'information
        JPanel voletDroit = new JPanel();
        voletDroit.setLayout(new BorderLayout());
        voletDroit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel jLabelNextBateauLabel = new JLabel("Prochain Bateau à placer :");
        jLabelNextBateauLabel.setFont(Constants.MAIN_FONT);
        jLabelNextBateauLabel.setHorizontalAlignment(SwingConstants.CENTER);
        voletDroit.add(jLabelNextBateauLabel, BorderLayout.NORTH);

        // Center du volet droit
        JPanel midleVoletDroit = new JPanel();
        midleVoletDroit.setLayout(new BorderLayout());
        jLabelProchainBateau = new JLabel(plateau.getProchainBateauAPlacer().toString() + " (Taille : " + plateau.getProchainBateauAPlacer().getStructure().size() + ")");
        jLabelNextBateauLabel.setFont(Constants.MAIN_FONT);
        jLabelProchainBateau.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelProchainBateau.setFont(Constants.MAIN_FONT);
        midleVoletDroit.add(jLabelProchainBateau, BorderLayout.CENTER);
        PlacementBateauController placementBateauController = new PlacementBateauController(this.placementBateau);
        midleVoletDroit.add(placementBateauController, BorderLayout.SOUTH);

        voletDroit.add(midleVoletDroit, BorderLayout.CENTER);
        voletDroit.add(new LegendePlacementBateau(), BorderLayout.SOUTH);

        add(jPanelGridPlacementBateau, BorderLayout.CENTER);
        add(voletDroit, BorderLayout.EAST);
    }

    @Override
    public void update(Observable observable, Object o) {
        jPanelGridPlacementBateau.removeAll();
        for (Case aCase: this.plateau.getCases()) {
            CasePlacementBateau casePlacementBateau = new CasePlacementBateau(aCase, plateau, placementBateau);
            jPanelGridPlacementBateau.add(casePlacementBateau);
        }
        jPanelGridPlacementBateau.updateUI();

        try {
            jLabelProchainBateau.setText(plateau.getProchainBateauAPlacer().toString() + " (Taille : " + plateau.getProchainBateauAPlacer().getStructure().size() + ")");
        } catch (NullPointerException e) {
            jLabelProchainBateau.setText("Vous avez placé tous les bateaux");
        }
    }
}
