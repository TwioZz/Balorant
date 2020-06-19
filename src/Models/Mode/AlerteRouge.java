package Models.Mode;

import Models.Joueur.Joueur;

public class AlerteRouge extends Partie {
    /**
     * Commence la partie en créeant les 2 plateaux des joueurs
     *
     * @param joueur1 Le joueur 1
     * @param joueur2 Le joueur 2
     */
    public AlerteRouge(Joueur joueur1, Joueur joueur2) {
        super(joueur1, joueur2);
    }
}
