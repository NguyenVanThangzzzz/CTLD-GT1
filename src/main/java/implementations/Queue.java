package implementations;

import interfaces.AbstractQueue;

import java.util.Iterator;

public class Queue<E> implements AbstractQueue<E> {
    private Node<E> head;
    private int size;

    private void ensureNonEmpty() {
        if (this.head == null) {
            throw new IllegalStateException("Stack is empty");
        }
    }

    private static class Node<E> {
        private E element;
        private Queue.Node<E> next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }

    public Queue() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void offer(E element) {

    }

    @Override
    public E poll() {
        ensureNonEmpty();
        E element = this.head.element;
        if (this.size == 1) {
            this.head = null;
        } else {
            Node<E> next = this.head.next;
            this.head.next = null;
            this.head = next;

        }
        this.size--;
        return element;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
