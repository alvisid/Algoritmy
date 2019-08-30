package lesson_3.HW_3.DZ_3_2;

public interface Queue<T> {

    boolean isEmpty();

    boolean isFull();

    int size();

    void insertLast(T value);

    T removeFirst();

    T peekFirst();


}
