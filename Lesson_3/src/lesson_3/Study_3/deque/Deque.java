package lesson_3.Study_3.deque;

import lesson_3.Study_3.queue.Queue;

public interface Deque<E> extends Queue<E> {

    boolean insertLeft(E value);

    boolean insertRight(E value);

    E removeLeft();

    E removeRight();
}
