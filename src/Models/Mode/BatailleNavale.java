package Models.Mode;

import Models.Joueur.Joueur;

/**
 * Mode de partie classique de la bataille navale
 */
public class BatailleNavale extends Partie {
    /**
     * Commence la partie en créeant les 2 plateaux des joueurs
     *
     * @param joueur1 Le joueur 1
     * @param joueur2 Le joueur 2
     */
    public BatailleNavale(Joueur joueur1, Joueur joueur2) {
        super(joueur1, joueur2);
    }
}
