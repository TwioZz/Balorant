package Models;

public class Navire {
    private CaseBateau[] structure;
    private boolean coule;

    public Navire(CaseBateau[] structure) {
        this.structure = structure;
        this.coule = false;
    }

    public CaseBateau[] getStructure() {
        return structure;
    }

    public void setStructure(CaseBateau[] structure) {
        this.structure = structure;
    }

    public boolean isCoule() {
        return coule;
    }

    public void setCoule(boolean coule) {
        this.coule = coule;
    }
}
