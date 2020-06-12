import javax.swing.*;

/**
 * Classe principale, qui va exécuter l'application.
 *
 *
 * @version 1.1
 * @author Aurélien le lémurien, Valentin le lamentin & Yoyo l'escargot
 */

public class Balorant extends JFrame {

    public Balorant() {
        super();
    }


    public static void main(String args[]) {
        Balorant balorant = new Balorant();
        balorant.setDefaultCloseOperation(EXIT_ON_CLOSE);
        balorant.setVisible(true);
    }
}
