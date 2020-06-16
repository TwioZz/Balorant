package Models.Array;

public class ListTooLargeException extends Exception {
    public ListTooLargeException() {
        super("Capacité maximum de la liste atteinte");
    }
}
