package Models;

public class MainModel {
    private boolean inMainMenu;
    private boolean inPlateau;

    public MainModel() {
        this.inMainMenu = false;
        this.inPlateau = false;
    }

    public boolean isInMainMenu() {
        return inMainMenu;
    }

    public void setInMainMenu(boolean inMainMenu) {
        this.inMainMenu = inMainMenu;
    }

    public boolean isInPlateau() {
        return inPlateau;
    }

    public void setInPlateau(boolean inPlateau) {
        this.inPlateau = inPlateau;
    }
}
