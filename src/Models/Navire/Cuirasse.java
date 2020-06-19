package Models.Navire;

import Models.Array.LimitedArrayList;
import Models.Case.CaseBateau;
/**
 * Classe du Cuirasse, hérite de la classe Navire
 */
public class Cuirasse extends Navire {
    /**
     * Constructuer de la classe Cuirasse
     * @param nom
     */
    public Cuirasse(String nom) {
        super(nom);
        this.structure = new LimitedArrayList<>(3);

        for (int i=0; i < 3; i++) {
            this.structure.add(new CaseBateau());
        }
    }
}
