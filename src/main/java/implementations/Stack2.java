package implementations;

import interfaces.AbstractStack;

import java.util.ArrayList;
import java.util.Iterator;

public class Stack2<E> implements AbstractStack<E> {
    private int size;
    private final ArrayList<E> arrayList = new ArrayList();

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
            ArrayList<E> tempArrayList = arrayList;

            @Override
            public boolean hasNext() {
                return (tempArrayList.size() - 1 >= 0) && (tempArrayList.get(tempArrayList.size() - 1) != null);
            }

            @Override
            public E next() {
                return tempArrayList.remove(tempArrayList.size() - 1);
            }
        };
    }

    private void ensureNonEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
    }

}