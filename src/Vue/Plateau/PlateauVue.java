package Vue.Plateau;

import javax.swing.*;

public class PlateauVue extends JPanel {

    public PlateauVue() {
        super();

        Models.Plateau plateau = new Models.Plateau();

        JButton jButton = new JButton("oh");
        this.add(jButton);
    }
}
