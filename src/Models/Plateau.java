package Models;

import Models.Array.LimitedArrayList;
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

    public Case getNextHorizontallyCase(Case aCase) {
        return getCaseAtCoord(aCase.getX() + 1, aCase.getY());
    }

    public Case getNextVerticallyCase(Case aCase) {
        return getCaseAtCoord(aCase.getX(), aCase.getY() + 1);
    }

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

    private void remplacementCasePourCaseBateau(CaseBateau caseBateau, Case aCase) {
        int index = this.cases.indexOf(aCase);
        this.cases.remove(index);

        caseBateau.setX(aCase.getX());
        caseBateau.setY(aCase.getY());
        this.cases.add(index, caseBateau);
    }

    public ArrayList<CaseBateau> getCasesBateau() {
        ArrayList<CaseBateau> casesBateau = new ArrayList<>();
        for (Case aCase: this.cases) {
            if (aCase instanceof CaseBateau) {
                casesBateau.add((CaseBateau) aCase);
            }
        }

        return casesBateau;
    }

    public Joueur getControlledBy() {
        return controlledBy;
    }

    public ArrayList<CaseBateau> getBateauCoule() {
        ArrayList<CaseBateau> casesBateauCoule = new ArrayList<>();
        for (Navire navire: this.navires) {
            if (navire.isCoule()) {
                casesBateauCoule.addAll(navire.getStructure());
            }
        }

        return casesBateauCoule;
    }

    public boolean isAllBateauCoule() {
        boolean allBateauCoule = true;

        for (Navire navire: this.navires) {
            if (!navire.isCoule()) {
                allBateauCoule = false;
            }
        }

        return allBateauCoule;
    }
}
