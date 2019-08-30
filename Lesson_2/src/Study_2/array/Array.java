package Study_2.array;


import Study_2.ICollection;

public interface Array<E> extends ICollection {

    int DEFAULT_CAPACITY = 16;

    void add(E value);

    boolean remove(E value);

    E removeByIndex(int index);

    boolean contains(E value);

    void display();

    default void addAll(E... values) {
        for (E value : values) {
            add(value);
        }
    }


    void sortBubble();

    void sortSelect();

    void sortInsert();

    int indexOf(E value);
}
