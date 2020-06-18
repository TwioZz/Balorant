package Models.Navire;

import Models.Array.LimitedArrayList;
import Models.Case.CaseBateau;

public class Cuirasse extends Navire {
    public Cuirasse(String nom) {
        super(nom);
        this.structure = new LimitedArrayList<>(3);

        for (int i=0; i < 3; i++) {
            this.structure.add(new CaseBateau());
        }
    }
}
