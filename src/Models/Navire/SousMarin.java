package Models.Navire;

import Models.Array.LimitedArrayList;
import Models.Case.CaseBateau;

/**
 * Classe du Sous-marin, hérite de la classe Navire
 */
public class SousMarin extends Navire {
    /**
     * Constructuer de la classe Sous-marin
     * @param nom
     */
    public SousMarin(String nom) {
        super(nom);
        this.structure = new LimitedArrayList<>(4);

        for (int i=0; i < 4; i++) {
            this.structure.add(new CaseBateau());
        }
    }
}
