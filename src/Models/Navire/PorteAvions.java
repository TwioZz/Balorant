package Models.Navire;

import Models.Array.LimitedArrayList;
import Models.Case.CaseBateau;
/**
 * Classe du Porte-avion, hérite de la classe Navire
 */
public class PorteAvions extends Navire {
    /**
     * Constructuer de la classe Porte-avion
     * @param nom
     */
    public PorteAvions(String nom) {
        super(nom);
        this.structure = new LimitedArrayList<>(5);

        for (int i=0; i < 5; i++) {
            this.structure.add(new CaseBateau());
        }
    }
}
