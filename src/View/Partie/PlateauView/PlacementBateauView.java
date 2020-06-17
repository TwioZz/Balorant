package View.Partie.PlateauView;

import Controller.Partie.Plateau.PlacementBateauController;
import Models.Case;
import Models.Constants;
import Models.PlacementBateau;
import Models.Plateau;
import View.Partie.PlateauView.CaseView.CasePlacementBateau;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

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

        jPanelGridPlacementBateau = new JPanel();
        jPanelGridPlacementBateau.setLayout(new GridLayout(10,10));
        for (Case aCase: this.plateau.getCases()) {
            CasePlacementBateau casePlacementBateau = new CasePlacementBateau(aCase, plateau, placementBateau);
            jPanelGridPlacementBateau.add(casePlacementBateau);
        }

        JPanel prochainBateauAPlacer = new JPanel();
        prochainBateauAPlacer.setLayout(new BorderLayout());
        JLabel jLabelNextBateauLabel = new JLabel("Prochain Bateau à placer :");
        jLabelNextBateauLabel.setFont(Constants.MAIN_FONT);
        jLabelNextBateauLabel.setHorizontalAlignment(SwingConstants.CENTER);
        prochainBateauAPlacer.add(jLabelNextBateauLabel, BorderLayout.NORTH);
        jLabelProchainBateau = new JLabel(plateau.prochainBateauAPlacer().toString());
        jLabelNextBateauLabel.setFont(Constants.MAIN_FONT);
        jLabelProchainBateau.setHorizontalAlignment(SwingConstants.CENTER);
        prochainBateauAPlacer.add(jLabelProchainBateau, BorderLayout.CENTER);

        PlacementBateauController placementBateauController = new PlacementBateauController(this.placementBateau);
        prochainBateauAPlacer.add(placementBateauController, BorderLayout.SOUTH);


        add(jPanelGridPlacementBateau, BorderLayout.CENTER);
        add(prochainBateauAPlacer, BorderLayout.EAST);
    }

    @Override
    public void update(Observable observable, Object o) {
        jPanelGridPlacementBateau.removeAll();
        for (Case aCase: this.plateau.getCases()) {
            CasePlacementBateau casePlacementBateau = new CasePlacementBateau(aCase, plateau, placementBateau);
            jPanelGridPlacementBateau.add(casePlacementBateau);
        }

        try {
            jLabelProchainBateau.setText(plateau.prochainBateauAPlacer().toString());
        } catch (NullPointerException e) {
            jLabelProchainBateau.setText("Vous avez placé tous les bateaux");
        }
    }
}
