package Models.Joueur;

public class Joueur {
    private String nom;
    private boolean alreadyShot;

    public Joueur(String nom) {
        this.alreadyShot = false;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public boolean isAlreadyShot() {
        return alreadyShot;
    }

    public void setAlreadyShot(boolean alreadyShot) {
        this.alreadyShot = alreadyShot;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
