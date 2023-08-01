package implementations;

import interfaces.AbstractQueue;

import java.util.ArrayList;
import java.util.Iterator;

public class Queue2<E> implements AbstractQueue<E> {
    private int size;
    private final java.util.ArrayList<E> arrayList = new java.util.ArrayList();

    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    public void push(E element) {
        arrayList.add(element);
        this.size++;
    }

    public E pop() {
        ensureNonEmpty();
        E element = arrayList.get(this.size - 1);
        arrayList.remove(size - 1);
        this.size--;
        return element;
    }

    @Override
    public void offer(E element) {

    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        ensureNonEmpty();
        return arrayList.get(this.size - 1);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return arrayList.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return (index < size);
            }

            @Override
            public E next() {
                index++;
                return arrayList.get(index - 1);
            }
        };
    }

    private void ensureNonEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
    }
}
