package Models.Array;

import java.util.ArrayList;

/**
 *
 * @param <T>
 */
public class LimitedArrayList<T> extends ArrayList<T> {
    private int limit;

    public LimitedArrayList(int limit) {
        this.limit = limit;
    }

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
