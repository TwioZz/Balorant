package Models.Case;

import Models.Case.Case;

/**
 * Représente chaques points du bateau
 */

public class CaseBateau extends Case {

    /**
     * Instanciation d'une case bateau temporaire lors de la création
     */
    public CaseBateau() {
        super(false, -1, -1);
    }
}
