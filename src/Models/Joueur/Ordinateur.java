package Models.Joueur;

import Models.Case.Case;
import Models.Mode.Partie;
import Models.Plateau;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe du joueur ia
 */
public class Ordinateur extends Joueur {

    private int strategie;

    /**
     * Constructeur de l'ia
     * @param nom nom de l'ia
     * @param strategie strategie utilisee par l'ia
     */
    public Ordinateur(String nom, int strategie) {
        super(nom);
        this.strategie = strategie;
    }

    /**
     * Choisit une case où il veut tirer en fonction de la stratégie
     */
    public void doTir(Plateau plateauEnnemi, Partie partie) {
        if (strategie == 0) {
            doTirStrategie0(plateauEnnemi.getCases());
        } else {
            // getCaseTireeStrategie1(plateaux);
        }

        partie.nextTour();
        this.setAlreadyShooted(true);
    }

    /**
     * La stratégie 0, la plus basique, consite à prendre une case aléatoire
     */
    private void doTirStrategie0(ArrayList<Case> plateau) {
        Random random = new Random();
        plateau.get(random.nextInt(plateau.size()  - 1)).setTouchee(true);
    }

    /**
     * La stratégie 1, case aléatoire, jusqu'à trouver un bateau puis va chercher à le couler
     */
    private Case getCaseTireeStrategie1(ArrayList<Case> plateaux) {
        return null;
    }
}
