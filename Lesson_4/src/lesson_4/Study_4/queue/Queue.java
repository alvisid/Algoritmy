package lesson_4.Study_4.queue;

import lesson_4.Study_4.ICollection;

public interface Queue<E> extends ICollection {

    boolean insert(E value);

    E remove();

    E peek();
}
