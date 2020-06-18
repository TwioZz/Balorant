package Models.Navire;

import Models.Array.LimitedArrayList;
import Models.Case.CaseBateau;

public class PorteAvions extends Navire {
    public PorteAvions(String nom) {
        super(nom);
        this.structure = new LimitedArrayList<>(5);

        for (int i=0; i < 5; i++) {
            this.structure.add(new CaseBateau());
        }
    }
}
