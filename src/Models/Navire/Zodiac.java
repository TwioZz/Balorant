package Models.Navire;

import Models.Array.LimitedArrayList;
import Models.Case.CaseBateau;

/**
 * Classe du Zodiac, hérite de la classe Navire
 */
public class Zodiac extends Navire {
    /**
     * Constructeur de la classe Zodiac
     * @param nom
     */
    public Zodiac(String nom) {
        super(nom);
        //Créé une ArrayList de taille 2 qui correspond à la taille du bateau
        this.structure = new LimitedArrayList<>(2);

        for (int i=0; i < 2; i++) {
            this.structure.add(new CaseBateau());
        }
    }
}
