package Models;

import Models.Array.LimitedArrayList;
import Models.Case.Case;
import Models.Case.CaseBateau;
import Models.Joueur.Joueur;
import Models.Navire.*;

import java.util.ArrayList;
import java.util.Observable;

public class Plateau extends Observable {
    private LimitedArrayList<Case> cases;
    private Joueur controlledBy;
    private LimitedArrayList<Navire> navires;

    public Plateau(Joueur joueur) {
        this.cases = new LimitedArrayList<Case>(100);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.cases.add(new Case(false, j, i));
            }
        }

        this.navires = new LimitedArrayList<Navire>(5);
        this.navires.add(new PorteAvions("Porte-Avions"));
        this.navires.add(new SousMarin("Sous-Marin"));
        this.navires.add(new Cuirasse("Cuirassé 1"));
        this.navires.add(new Cuirasse("Cuirassé 2"));
        this.navires.add(new Zodiac("Zodiac"));

        this.controlledBy = joueur;
    }

    public LimitedArrayList<Case> getCases() {
        return cases;
    }

    /**
     * Récupère le premier navire qui n'est pas placé
     * @return le premier navire qui n'est pas placé
     */
    public Navire prochainBateauAPlacer() {
        for (Navire navire: this.navires) {
            if (!navire.isPlace()) {
                return navire;
            }
        }

        return null;
    }

    /**
     * Retourne la case aux coordonées spécifiées
     */
    public Case getCaseAtCoord(int x, int y) {
        for (Case aCase: this.cases) {
            if (aCase.getX() == x && aCase.getY() == y) {
                return aCase;
            }
        }

        return null;
    }

    /**
     * Récupère la prochaine case horizontale pour le placement du bateau
     * @param aCase un objet de la classe Case
     * @return la prochaine case horizontale
     */
    public Case getNextHorizontallyCase(Case aCase) {
        return getCaseAtCoord(aCase.getX() + 1, aCase.getY());
    }

    /**
     * Récupère la prochaine case verticale pour le placement du bateau
     * @param aCase un objet de la classe Case
     * @return la prochaine case verticale
     */
    public Case getNextVerticallyCase(Case aCase) {
        return getCaseAtCoord(aCase.getX(), aCase.getY() + 1);
    }

    /**
     * Place le bateau horizontalement ou verticalement
     * @param navire un objet de la classe Navire
     * @param firstCaseToRemplace un objet de la classe Case
     * @param alignement une variable contenant "Horizontal" ou "Vertical"
     */
    public void placementDuNavire(Navire navire, Case firstCaseToRemplace, String alignement) {
        Case tempCase = firstCaseToRemplace;
        for (CaseBateau caseBateau: navire.getStructure()) {
            remplacementCasePourCaseBateau(caseBateau, tempCase);
            if (alignement.equals(Constants.PLACEMENT_HORIZONTAL)) {
                tempCase = getNextHorizontallyCase(tempCase);
            }
            else if (alignement.equals(Constants.PLACEMENT_VERTICAL)) {
                tempCase = getNextVerticallyCase(tempCase);
            }
        }
        navire.setPlace(true);

        setChanged();
        notifyObservers();
    }

    /**
     * Remplace une case du plateau par une case de la classe CaseBateau
     * @param caseBateau un objet de la classe CaseBateau
     * @param aCase un objet de la classe Case
     */
    private void remplacementCasePourCaseBateau(CaseBateau caseBateau, Case aCase) {
        int index = this.cases.indexOf(aCase);
        this.cases.remove(index);

        caseBateau.setX(aCase.getX());
        caseBateau.setY(aCase.getY());
        this.cases.add(index, caseBateau);
    }

    /**
     *Parcours le plateau et ajoute chaque case de type CaseBateau rencontrée dans une ArrayList de caseBateau
     * @return l'ArrayList de casesBateau
     */
    public ArrayList<CaseBateau> getCasesBateau() {
        ArrayList<CaseBateau> casesBateau = new ArrayList<>();
        for (Case aCase: this.cases) {
            if (aCase instanceof CaseBateau) {
                casesBateau.add((CaseBateau) aCase);
            }
        }

        return casesBateau;
    }

    /**
     * Récupère le propriétaire du plateau
     * @return le propriétaire du plateau
     */
    public Joueur getControlledBy() {
        return controlledBy;
    }

    /**
     * Permet de savoir si un bateau a été coulé
     * @return l'ArrayList de caseBateau
     */
    public ArrayList<CaseBateau> getBateauCoule() {
        ArrayList<CaseBateau> casesBateauCoule = new ArrayList<>();
        for (Navire navire: this.navires) {
            if (navire.isCoule()) {
                casesBateauCoule.addAll(navire.getStructure());
            }
        }

        return casesBateauCoule;
    }

    /**
     * Permet de savoir si tous les bateaux sont coulés
     * @return le booléen allBateauCoule
     */
    public boolean isAllBateauCoule() {
        boolean allBateauCoule = true;

        for (Navire navire: this.navires) {
            if (!navire.isCoule()) {
                allBateauCoule = false;
            }
        }

        return allBateauCoule;
    }

    /**
     * Calcule en fonction d'une case, la distance du bateau le plus proche
     *
     * @param aCaseInput case référente afin de trouver le bateau le plus proche
     * @return distance La distance du bateau le plus proche
     */
    public int getDistanceBateauLePlusProche(Case aCaseInput) {
        int distance = 99;

        for (Case aCase: this.getCases()) {
            if (aCase instanceof CaseBateau) {
                int distanceTamp = Math.abs(aCase.getX() - aCaseInput.getX()) + Math.abs(aCase.getY() - aCaseInput.getY());
                if (distanceTamp < distance) {
                    distance = distanceTamp;
                }
            }
        }
        return distance;
    }

    /**
     * Retourne toutes les cases dans une ligne
     * @param line La ligne demandée
     * @return Les cases de la ligne
     */
    public ArrayList<Case> getAllCaseInLine(int line) {
        ArrayList<Case> casesInLine = new ArrayList<>();
        for (Case aCase: this.getCases()) {
            if (aCase.getY() == line) {
                casesInLine.add(aCase);
            }
        }

        return casesInLine;
    }
}
