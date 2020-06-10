package Models;

import javax.swing.table.DefaultTableModel;

/**
 * @author Aurélien le lémurien
 * Valentin le lamentin
 * Yoyo l'escargot
 *
 */
@SuppressWarnings("serial")
public class Model extends DefaultTableModel {

    public Model() {
        super(Constants.DATA, Constants.TABLE_HEADER);
    }
}


