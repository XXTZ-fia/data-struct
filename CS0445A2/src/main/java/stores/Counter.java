package stores;

import interfaces.ICounter;

/**
 * A generic implementation of the ICounter iterface.
 */
public class Counter<E> implements ICounter<E> {

    MyArrayList<Count<E>> counts = new MyArrayList<>();

    // INCOMPLETE.
    public int getCount(E element) {
        // Returns the count of an item (the number of times it was added to the list).
        Count<E> count = find(element);
        return count == null ? 0 : count.getCount();
    }

    // INCOMPLETE.
    public boolean add(E element) {
        Count<E> count = find(element);
        if (count == null) {
            counts.add(new Count<>(element, 1));
        } else {
            count.incrementCount();
        }
        return true;
    }

    // INCOMPLETE.
    public int size() {
        int total = 0;
        for (int i = 0; i < counts.size(); i++) {
            total += counts.get(i).getCount();
        }
        return total;
    }

    // Returns the count object related to element.
    // Returns null if the element does not exist.
    private Count<E> find(E element) {
        for (int i = 0; i < counts.size(); i++) {
            if (counts.get(i).getObj().equals(element)) {
                return counts.get(i);
            }
        }
        return null;
    }

    public void clear() {
        counts.clear();
    }

    public boolean contains(E element) {
        return find(element) != null;
    }

    public boolean isEmpty() {
        return counts.isEmpty();
    }

    public boolean remove(E element) {
        Count<E> count = find(element);
        if (count == null)
            return false;
        else
            return counts.remove(count);
    }

}