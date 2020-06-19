package Controller.Partie.Plateau;

import Models.Constants;
import Models.PlacementBateau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlleur de gestion du placement (HORIZONTAL ou VERTICAL) des bateaux
 */
public class PlacementBateauController extends JPanel {
    public PlacementBateauController(PlacementBateau placementBateau) {
        setLayout(new GridLayout(1, 2));

        ButtonGroup buttonGroup = new ButtonGroup();

        JRadioButton jRadioButtonVertical = new JRadioButton(Constants.PLACEMENT_VERTICAL);
        jRadioButtonVertical.setHorizontalAlignment(SwingConstants.CENTER);
        jRadioButtonVertical.setFont(Constants.MAIN_FONT);
        jRadioButtonVertical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                placementBateau.setPlacement(jRadioButtonVertical.getText());
            }
        });

        JRadioButton jRadioButtonHorizontal = new JRadioButton(Constants.PLACEMENT_HORIZONTAL);
        jRadioButtonHorizontal.setHorizontalAlignment(SwingConstants.CENTER);
        jRadioButtonHorizontal.setFont(Constants.MAIN_FONT);
        jRadioButtonHorizontal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                placementBateau.setPlacement(jRadioButtonHorizontal.getText());
            }
        });
        jRadioButtonHorizontal.setSelected(true);

        buttonGroup.add(jRadioButtonVertical);
        buttonGroup.add(jRadioButtonHorizontal);

        add(jRadioButtonVertical);
        add(jRadioButtonHorizontal);
    }
}
