package View.Partie.PlateauView;

import Models.Case;
import Models.CaseBateau;
import Models.Plateau;
import View.Partie.PlateauView.CaseView.CasePlacementBateau;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class PlacementBateauView extends JPanel implements Observer {

    private Plateau plateau;
    private JPanel jPanelGridPlacementBateau;
    private JLabel jLabelProchainBateau;

    public PlacementBateauView(Plateau plateau) {
        this.plateau = plateau;
        this.plateau.addObserver(this);
        setLayout(new BorderLayout());

        jPanelGridPlacementBateau = new JPanel();
        jPanelGridPlacementBateau.setLayout(new GridLayout(10,10));
        for (Case aCase: this.plateau.getCases()) {
            CasePlacementBateau casePlacementBateau = new CasePlacementBateau(aCase, plateau);
            jPanelGridPlacementBateau.add(casePlacementBateau);
        }

        JPanel prochainBateauAPlacer = new JPanel();
        prochainBateauAPlacer.setLayout(new BorderLayout());
        prochainBateauAPlacer.add(new JLabel("Prochain Bateau à placer :"), BorderLayout.NORTH);
        jLabelProchainBateau = new JLabel(plateau.prochainBateauAPlacer().toString());
        prochainBateauAPlacer.add(jLabelProchainBateau, BorderLayout.CENTER);

        JPanel jPanelGroupButton = new JPanel();
        jPanelGroupButton.setLayout(new GridLayout(1, 2));
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton jRadioButtonVertical = new JRadioButton("Vertical");
        JRadioButton jRadioButtonHorizontal = new JRadioButton("Horizontal");
        buttonGroup.add(jRadioButtonVertical);
        buttonGroup.add(jRadioButtonHorizontal);
        jPanelGroupButton.add(jRadioButtonVertical);
        jPanelGroupButton.add(jRadioButtonHorizontal);
        prochainBateauAPlacer.add(jPanelGroupButton, BorderLayout.SOUTH);


        add(jPanelGridPlacementBateau, BorderLayout.CENTER);
        add(prochainBateauAPlacer, BorderLayout.EAST);
    }

    @Override
    public void update(Observable observable, Object o) {
        jPanelGridPlacementBateau.removeAll();
        for (Case aCase: this.plateau.getCases()) {
            CasePlacementBateau casePlacementBateau = new CasePlacementBateau(aCase, plateau);
            jPanelGridPlacementBateau.add(casePlacementBateau);
        }

        try {
            jLabelProchainBateau.setText(plateau.prochainBateauAPlacer().toString());
        } catch (NullPointerException e) {
            jLabelProchainBateau.setText("Vous avez placé tous les bateaux");
        }
    }
}
