package Models.Joueur;

/**
 * Joueur qui joue actuellement
 */

public class Joueur {
    private String nom;
    private boolean alreadyShot;

    /**
     * Defini le nom du joueur par
     * @param nom
     */
    public Joueur(String nom) {
        this.alreadyShot = false;
        this.nom = nom;
    }

    /**
     *
     * @return le nom du joueur
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return si le joueur est en train de tirerou non
     */
    public boolean isAlreadyShot() {
        return alreadyShot;
    }

    /**
     * Informe que le joueur est en train de tirer
     * @param alreadyShot
     */
    public void setAlreadyShot(boolean alreadyShot) {

        this.alreadyShot = alreadyShot;
    }

    /**
     * Change le nom du joueur par
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
}
