package implementations;

import interfaces.AbstractQueue;

import java.util.Iterator;

public class Queue<E> implements AbstractQueue<E> {
    private Node<E> head;
    private int size;
    private static class Node<E> {
        private final E element;
        private Queue.Node<E> next;


        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    } // Node class
    public Queue() {
        this.head = null;
        this.size= 0;
    }

    @Override
    public void offer(E element) {
        Node<E> newNode = new Node<>(element);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node<E> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        this.size++;
    }

    @Override
    public E poll() {
        ensureNonEmpty();
        E element = this.head.element;
        Queue.Node<E> temp = this.head.next;
        this.head.next = null;
        this.head = temp;
        this.size--;
        return element;
    }

    @Override
    public E peek() {
        ensureNonEmpty();
        return this.head.element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.head ==null;
    }
    private void ensureNonEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Queue.Node<E> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.element;
                this.current = this.current.next;
                return element;
            }
        };
    }
}