package lesson_3.Study_3.queue;

import lesson_3.Study_3.ICollection;

public interface Queue<E> extends ICollection {

    boolean insert(E value);

    E remove();

    E peek();

    int size();

    boolean isEmpty();

    boolean isFull();
}
