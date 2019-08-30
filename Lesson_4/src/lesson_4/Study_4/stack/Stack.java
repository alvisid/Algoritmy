package lesson_4.Study_4.stack;

import lesson_4.Study_4.ICollection;

public interface Stack<E> extends ICollection {

    boolean push(E value);

    E pop();

    E peek();
}
