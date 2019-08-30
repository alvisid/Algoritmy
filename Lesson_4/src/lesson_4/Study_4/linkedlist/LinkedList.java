package lesson_4.Study_4.linkedlist;

import lesson_4.Study_4.ICollection;

import java.util.Iterator;

public interface LinkedList<E> extends ICollection, Iterator<E> {

    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    void display();

    E getFirstValue();

    Node<E> getFirst();

    @Override
    default boolean isFull() {
        return false;
    }

    Iterator<E> iterator();

    class Node<T> {
        public final T value;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
