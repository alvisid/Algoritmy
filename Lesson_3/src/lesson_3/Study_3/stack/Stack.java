package lesson_3.Study_3.stack;

import lesson_3.Study_3.ICollection;

public interface Stack<E> extends ICollection {

    boolean push(E value);

    E pop();

    E peek();
}
