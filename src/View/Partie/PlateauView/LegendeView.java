package View.Partie.PlateauView;

import Models.Constants;

import javax.swing.*;
import java.awt.*;

/**
 * Vue affichant la légende
 */
public class LegendeView extends JPanel {

    public LegendeView() {
        setLayout(new BorderLayout());
        JLabel legendeLabel = new JLabel("Légende :");
        legendeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        legendeLabel.setFont(Constants.MAIN_TITLE_FONT);
        add(legendeLabel, BorderLayout.NORTH);

        JPanel jPanelLegendeColor = new JPanel();
        jPanelLegendeColor.setLayout(new GridLayout(5, 2));

        // Cas Eau non touchée
        JButton jButtonCasePasTouchee = new JButton();
        jButtonCasePasTouchee.setBackground(Constants.CASE_COLOR_PAS_TOUCHEE);
        jButtonCasePasTouchee.setPreferredSize(new Dimension(25, 25));
        jButtonCasePasTouchee.setEnabled(false);
        JLabel jLabelCasePasTouchee = new JLabel("Case d'eau non touchée");
        jLabelCasePasTouchee.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelCasePasTouchee.setFont(Constants.MAIN_FONT);
        jPanelLegendeColor.add(jButtonCasePasTouchee);
        jPanelLegendeColor.add(jLabelCasePasTouchee);

        // Cas Eau touchée
        JButton jButtonCaseTouchee = new JButton();
        jButtonCaseTouchee.setBackground(Constants.CASE_COLOR_TOUCHEE);
        jButtonCaseTouchee.setPreferredSize(new Dimension(25, 25));
        jButtonCaseTouchee.setEnabled(false);
        JLabel jLabelCaseTouchee = new JLabel("Case d'eau touchée");
        jLabelCaseTouchee.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelCaseTouchee.setFont(Constants.MAIN_FONT);
        jPanelLegendeColor.add(jButtonCaseTouchee);
        jPanelLegendeColor.add(jLabelCaseTouchee);

        // Cas bateau allié
        JButton jButtonBateauAllie = new JButton();
        jButtonBateauAllie.setBackground(Constants.CASE_COLOR_BATEAU_ALLIE);
        jButtonBateauAllie.setPreferredSize(new Dimension(25, 25));
        jButtonBateauAllie.setEnabled(false);
        JLabel jLabelBateauAllie = new JLabel("Case bateau alliée");
        jLabelBateauAllie.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelBateauAllie.setFont(Constants.MAIN_FONT);
        jPanelLegendeColor.add(jButtonBateauAllie);
        jPanelLegendeColor.add(jLabelBateauAllie);

        // Cas bateau touché
        JButton jButtonBateauTouchee = new JButton();
        jButtonBateauTouchee.setBackground(Constants.CASE_COLOR_BATEAU_TOUCHEE);
        jButtonBateauTouchee.setPreferredSize(new Dimension(25, 25));
        jButtonBateauTouchee.setEnabled(false);
        JLabel jLabelBateauTouchee = new JLabel("Case bateau touchée");
        jLabelBateauTouchee.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelBateauTouchee.setFont(Constants.MAIN_FONT);
        jPanelLegendeColor.add(jButtonBateauTouchee);
        jPanelLegendeColor.add(jLabelBateauTouchee);

        // Cas bateau coulé
        JButton jButtonBateauCoule = new JButton();
        jButtonBateauCoule.setBackground(Constants.CASE_COLOR_BATEAU_COULE);
        jButtonBateauCoule.setPreferredSize(new Dimension(25, 25));
        jButtonBateauCoule.setEnabled(false);
        JLabel jLabelBateauCoule = new JLabel("Case bateau coulée");
        jLabelBateauCoule.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelBateauCoule.setFont(Constants.MAIN_FONT);
        jPanelLegendeColor.add(jButtonBateauCoule);
        jPanelLegendeColor.add(jLabelBateauCoule);

        add(jPanelLegendeColor, BorderLayout.CENTER);
    }
}
