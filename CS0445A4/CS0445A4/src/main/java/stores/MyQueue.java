package stores;

import interfaces.IQueue;

public class MyQueue<E> implements IQueue<E> {

    private ListElement<E> head;
    private ListElement<E> tail;

    public MyQueue() {
        head = null;
        tail = null;
    }
    
    public boolean isEmpty() {
        return (head == null);
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }

        ListElement<E> tmp = head;
        head = tmp.getNext();

        if (head == null) {
            tail = null;
        }

        return tmp.getValue();
    }

    public void enqueue(E value) {
        ListElement<E> tmp = new ListElement<>(value);

        if (isEmpty()) {
            tail = head = tmp;
        } else {
            tail.setNext(tmp);
            tail = tmp;
        }
    }

    //INCOMPLETE
    public E modifyHead(E value) {
        if (isEmpty()) {
            head = new ListElement<>(value);
            tail = head;
            return null;
        }
        E oldHeadValue = head.getValue();
        ListElement<E> newHead = new ListElement<>(value);
        newHead.setNext(head.getNext());
        head = newHead;
        return oldHeadValue;
    }

    //INCOMPLETE
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListElement<E> current = head;
        while (current != null) {
            sb.append(current.getValue());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
