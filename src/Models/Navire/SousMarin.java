package Models.Navire;

import Models.Array.LimitedArrayList;
import Models.Case.CaseBateau;

public class SousMarin extends Navire {
    public SousMarin(String nom) {
        super(nom);
        this.structure = new LimitedArrayList<>(4);

        for (int i=0; i < 4; i++) {
            this.structure.add(new CaseBateau());
        }
    }
}
