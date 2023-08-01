package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {
    private Node<E> head, tail;
    private int size;

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    private void ensureNonEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
    }

    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (this.head != null) {
            newNode.next = this.head;
        }
        this.head = newNode;
        if (this.tail == null) {
            this.tail = newNode;
        }
        this.size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> newNode = new Node<>(element);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    @Override
    public E removeFirst() {
        ensureNonEmpty();
        Node<E> temp = this.head;
        this.head = this.head.next;
        temp.next = null;
        this.size--;
        return temp.element;
    }

    @Override
    public E removeLast() {
        ensureNonEmpty();
        Node<E> temp = this.head;
        while (temp.next != this.tail) {
            temp = temp.next;
        }
        this.tail.next = null;
        this.tail = temp;
        this.size--;
        return temp.next.element;
    }

    @Override
    public E getFirst() {
        ensureNonEmpty();
        return this.head.element;
    }

    @Override
    public E getLast() {
        ensureNonEmpty();
        return this.tail.element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

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

