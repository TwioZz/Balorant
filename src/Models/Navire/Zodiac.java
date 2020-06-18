package Models.Navire;

import Models.Array.LimitedArrayList;
import Models.Case.CaseBateau;

public class Zodiac extends Navire {
    public Zodiac(String nom) {
        super(nom);
        this.structure = new LimitedArrayList<>(2);

        for (int i=0; i < 2; i++) {
            this.structure.add(new CaseBateau());
        }
    }
}
