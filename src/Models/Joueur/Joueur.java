package Models.Joueur;

/**
 * Joueur qui joue actuellement
 */

public abstract class Joueur {
    private String nom;
    private boolean alreadyShot;

    /**
     * Defini le nom du joueur par
     * @param nom Le nom du joueur
     */
    public Joueur(String nom) {
        this.alreadyShot = false;
        this.nom = nom;
    }

    /**
     * @return le nom du joueur
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return si le joueur s'est déjà fait tirer dessus
     */
    public boolean isAlreadyGotShot() {
        return alreadyShot;
    }

    /**
     * Informe si le joueur s'est déjà fait tirer dessus
     * @param alreadyShoted si le joueur s'est déjà fait tirer dessus
     */
    public void setAlreadyGotShot(boolean alreadyShoted) {
        this.alreadyShot = alreadyShoted;
    }
}
