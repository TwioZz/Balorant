package View.Partie.PlateauView.PlacementBateau;

import Models.Constants;

import javax.swing.*;
import java.awt.*;

public class LegendePlacementBateau extends JPanel {

    public LegendePlacementBateau() {
        setLayout(new BorderLayout());
        JLabel legendeLabel = new JLabel("Légende :");
        legendeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        legendeLabel.setFont(Constants.MAIN_FONT);
        add(legendeLabel, BorderLayout.NORTH);

        JPanel jPanelLegendeColor = new JPanel();
        jPanelLegendeColor.setLayout(new GridLayout(2, 2));

        JButton jButtonCaseBateauPlacable = new JButton();
        jButtonCaseBateauPlacable.setBackground(Constants.CASE_COLOR_BATEAU_PLACABLE);
        jButtonCaseBateauPlacable.setPreferredSize(new Dimension(25, 25));
        jButtonCaseBateauPlacable.setEnabled(false);
        JLabel jLabelCaseBateauPlacable = new JLabel("Bateau plaçable");
        jLabelCaseBateauPlacable.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelCaseBateauPlacable.setFont(Constants.MAIN_FONT);
        jPanelLegendeColor.add(jButtonCaseBateauPlacable);
        jPanelLegendeColor.add(jLabelCaseBateauPlacable);


        JButton jButtonCaseBateauNonPlacable = new JButton();
        jButtonCaseBateauNonPlacable.setBackground(Constants.CASE_COLOR_BATEAU_NON_PLACABLE);
        jButtonCaseBateauNonPlacable.setPreferredSize(new Dimension(25, 25));
        jButtonCaseBateauNonPlacable.setEnabled(false);
        JLabel jLabelCaseBateauNonPlacable = new JLabel("Bateau non plaçable");
        jLabelCaseBateauNonPlacable.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelCaseBateauNonPlacable.setFont(Constants.MAIN_FONT);
        jPanelLegendeColor.add(jButtonCaseBateauNonPlacable);
        jPanelLegendeColor.add(jLabelCaseBateauNonPlacable);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(jPanelLegendeColor, BorderLayout.CENTER);
    }
}
