package Models.Array;

import java.util.ArrayList;

/**
 *
 * Ajoute @param <T>, le bateau dans une arraylist
 */
public class LimitedArrayList<T> extends ArrayList<T> {
    private int limit;

    /**
     *
     *  Nombre @param limit de bateaux
     */
    public LimitedArrayList(int limit) {
        this.limit = limit;
    }

    /**
     * ajoute
     * @param item, le bateau
     * @return si il l'a bien retourné ou non
     * */

    @Override
    public boolean add(T item) {
        if (this.size() > limit) {
            try {
                throw new ListTooLargeException();
            } catch (ListTooLargeException e) {
                e.printStackTrace();
            }
        }
        return super.add(item);
    }
}
