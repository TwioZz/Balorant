package Models.Mode;

import Models.Joueur.Joueur;

/**
 * Pire mode de jeu, sélection des coordonnées en commencant par la colonne
 */
public class OperationArtillerie extends Partie {
    /**
     * Commence la partie en créeant les 2 plateaux des joueurs
     *
     * @param joueur1 Le joueur 1
     * @param joueur2 Le joueur 2
     */
    public OperationArtillerie(Joueur joueur1, Joueur joueur2) {
        super(joueur1, joueur2);
    }
}
