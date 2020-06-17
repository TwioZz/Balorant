package Controller.Partie.Plateau;

import Models.Constants;
import Models.PlacementBateau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlacementBateauController extends JPanel {
    private PlacementBateau placementBateau;

    public PlacementBateauController(PlacementBateau placementBateau) {
        this.placementBateau = placementBateau;

        setLayout(new GridLayout(1, 2));

        ButtonGroup buttonGroup = new ButtonGroup();

        JRadioButton jRadioButtonVertical = new JRadioButton(Constants.PLACEMENT_VERTICAL);
        jRadioButtonVertical.setHorizontalAlignment(SwingConstants.CENTER);
        jRadioButtonVertical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                placementBateau.setPlacement(jRadioButtonVertical.getText());
            }
        });

        JRadioButton jRadioButtonHorizontal = new JRadioButton(Constants.PLACEMENT_HORIZONTAL);
        jRadioButtonHorizontal.setHorizontalAlignment(SwingConstants.CENTER);
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