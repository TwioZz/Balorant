package Models.Array;

/**
 * Message d'erreur quand la liste atteint son max
 */
public class ListTooLargeException extends Exception {
    public ListTooLargeException() {
        super("Capacité maximum de la liste atteinte");
    }
}
