package stores;

import interfaces.IStack;

public class MyStack<E> implements IStack<E> {
    DoublyLinkedList<E> hh = new DoublyLinkedList<E>();
    private ListElement<E> head;
    private int size;

    public void push(E val) {
        // TODO: implement pushing
        ListElement<E> ee = new ListElement<>(val);
        ee.setNext(head);
        head = ee;
        hh.addToHead(val);
        size++;
    }

    // INCOMPLETE.
    public E pop() {
        if (head == null) {
            return null;
        }
        head = head.getNext();
        size--;
        return hh.removeFromHead();

    }

    // INCOMPLETE
    public boolean isEmpty() {
        // TODO: check whether list is empty
        if (hh.isEmpty()) {
            return true;
        }
        return false;
    }

    // INCOMPLETE
    public String toString() {
        // TODO: produces a String of the contents of the queue
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListElement<E> current = head;
        while (current != null) {
            sb.append(current.getValue());
            current = current.getNext();
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    public int size(){
        return size;
    }
}