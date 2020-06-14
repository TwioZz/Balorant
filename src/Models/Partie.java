package Models;

import java.util.ArrayList;
import java.util.Observable;

public class Partie extends Observable {
    private ArrayList<Plateau> plateaux;

    public Partie() {
        Plateau plateau1 = new Plateau();
        Plateau plateau2 = new Plateau();
        this.plateaux = new ArrayList<>();
        this.plateaux.add(plateau1);
        this.plateaux.add(plateau2);
    }

    public ArrayList<Plateau> getPlateaux() {
        return plateaux;
    }

    public void setPlateaux(ArrayList<Plateau> plateaux) {
        this.plateaux = plateaux;
    }
}
