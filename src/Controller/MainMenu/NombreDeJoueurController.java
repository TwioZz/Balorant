package Controller.MainMenu;

import Models.MainMenuModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controleur de la sélection de joueur humain
 */
public class NombreDeJoueurController extends JPanel {
    public NombreDeJoueurController(MainMenuModel mainMenuModel) {
        this.setLayout(new GridBagLayout());

        String[] modeJoueur = new String[]{
                "IA vs IA",
                "Joueur vs IA",
                "Joueur vs Joueur"
        };


        JComboBox<String> nombreJoueurJComboBox = new JComboBox<>(modeJoueur);
        nombreJoueurJComboBox.addActionListener(new ActionListener() {
            // Modifie le nombre de joueur humain en fonction de la sélection
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainMenuModel.setNombreDeJoueurHumain(nombreJoueurJComboBox.getSelectedIndex());
            }
        });
        nombreJoueurJComboBox.setSelectedIndex(1); // Pré-sélection de la première valeur
        nombreJoueurJComboBox.setPreferredSize(new Dimension(200, 25));
        this.add(nombreJoueurJComboBox);
    }
}
