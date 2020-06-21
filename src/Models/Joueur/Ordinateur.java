package Models.Joueur;

import Models.Case.Case;
import Models.Case.CaseBateau;
import Models.Constants;
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
    public void doTir(Plateau plateauEnnemi) {
        if (strategie == 0) {
            doTirStrategie0(plateauEnnemi.getCases());
        } else if (strategie == 2) {
            // getCaseTireeStrategie1(plateaux);
        } else if (strategie == 42) {
            doTirStrategie42(plateauEnnemi.getCases());
        }
    }

    /**
     * La stratégie 0, la plus basique, consite à prendre une case aléatoire
     */
    private void doTirStrategie0(ArrayList<Case> plateau) {
        Random random = new Random();
        Case aCaseChoisie;
        do {
            aCaseChoisie = plateau.get(random.nextInt(plateau.size()));
        } while (aCaseChoisie.isTouchee()); // Choisie une nouvelle case si celle choisie est déjà touchée
        aCaseChoisie.setTouchee(true);
    }

    /**
     * La stratégie 1, case aléatoire, jusqu'à trouver un bateau puis va chercher à le couler
     */
    private Case getCaseTireeStrategie1(ArrayList<Case> plateau) {
        return null;
    }

    /**
     * La stratégie 42, Le cheat, tir parfait
     */
    private void doTirStrategie42(ArrayList<Case> plateau) {
        CaseBateau caseBateau = null;

        for (Case aCase: plateau) {
            if (aCase instanceof CaseBateau && !aCase.isTouchee()) {
                caseBateau = (CaseBateau) aCase;
            }
        }

        caseBateau.setTouchee(true);
    }

    public void placerBateaux(Plateau plateauAllie) {
        while (plateauAllie.getProchainBateauAPlacer() != null) {
            if (strategie == 0) {
                placeBateauStrategie0(plateauAllie);
            } else {
                placeBateauStrategie0(plateauAllie); // A remplacer pour une stratégie ultérieur
            }
        }
    }

    /**
     * La stratégie 0, la plus basique, consite à placer un bateau aléatoirement
     * @param plateau Le plateau allié
     */
    private void placeBateauStrategie0(Plateau plateau) {
        Random random = new Random();
        Case aCaseChoisie;
        String placement;
        boolean caseValide;
        do {
            caseValide = true;
            aCaseChoisie = plateau.getCases().get(random.nextInt(plateau.getCases().size()));
            placement = random.nextBoolean() ? Constants.PLACEMENT_HORIZONTAL : Constants.PLACEMENT_VERTICAL;

            // Les conditions de validitées d'une case par rapport aux bords et aux autres bateaux
            if (plateau.getProchainBateauAPlacer() != null) {
                int tailleBateauAPlacer = plateau.getProchainBateauAPlacer().getStructure().size();
                if (placement.equals(Constants.PLACEMENT_HORIZONTAL)) {
                    if (aCaseChoisie.getX() > 10 - tailleBateauAPlacer) {
                        caseValide = false;
                    }
                } else if (placement.equals(Constants.PLACEMENT_VERTICAL)) {
                    if (aCaseChoisie.getY() > 10 - tailleBateauAPlacer) {
                        caseValide = false;
                    }
                }

                for (CaseBateau caseBateau: plateau.getCasesBateau()) {
                    if (placement.equals(Constants.PLACEMENT_HORIZONTAL)) {
                        if (aCaseChoisie.getX() > caseBateau.getX() - tailleBateauAPlacer && aCaseChoisie.getX() < caseBateau.getX() && aCaseChoisie.getY() == caseBateau.getY()) {
                            caseValide = false;
                        }
                    } else if (placement.equals(Constants.PLACEMENT_VERTICAL)) {
                        if (aCaseChoisie.getY() > caseBateau.getY() - tailleBateauAPlacer && aCaseChoisie.getY() < caseBateau.getY() && aCaseChoisie.getX() == caseBateau.getX()) {
                            caseValide = false;
                        }
                    }
                }
            }
        } while (!caseValide); // Tant que la case n'est pas valide
        plateau.placementDuNavire(plateau.getProchainBateauAPlacer(), aCaseChoisie, placement);
    }
}
