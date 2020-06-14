package Models;

import java.util.Observable;

public class Plateau extends Observable {
    private Case[] cases;
    private Joueur controlledBy;
    private Navire[] navires;
}
