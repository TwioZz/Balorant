package Models;

import java.awt.*;

/**
 * Clase pour stocker l'ensemble des constantes du jeu
 */
public class Constants {
    public static final String BATAILLE_NAVALE = "Bataille Navale";
    public static final String ALERTE_ROUGE = "Alerte Rouge";
    public static final String OPERATION_ARTILLERIE = "Operation Artillerie";
    public static final String MISSION_RADAR = "Mission Radar";

    public static final Font MAIN_TIMER_FONT = new Font("Serif", Font.BOLD, 96);
    public static final Font MAIN_TITLE_FONT = new Font("Serif", Font.BOLD, 48);
    public static final Font MAIN_FONT = new Font("Serif", Font.BOLD, 24);

    public static final String PLACEMENT_HORIZONTAL = "Horizontal";
    public static final String PLACEMENT_VERTICAL = "Vertical";

    public static final Color CASE_COLOR_BATEAU_PLACABLE = new Color(2, 29, 121);
    public static final Color CASE_COLOR_BATEAU_NON_PLACABLE = new Color(118, 6, 6);

    public static final Color CASE_COLOR_PAS_TOUCHEE = new Color(2, 29, 121);
    public static final Color CASE_COLOR_TOUCHEE = new Color(4, 2, 52);
    public static final Color CASE_COLOR_BATEAU_ALLIE = new Color(69, 69, 69);
    public static final Color CASE_COLOR_BATEAU_TOUCHEE = new Color(2, 73, 13);
    public static final Color CASE_COLOR_BATEAU_COULE = new Color(118, 6, 6);
}
