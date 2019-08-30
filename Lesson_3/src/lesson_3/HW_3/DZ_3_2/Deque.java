package lesson_3.HW_3.DZ_3_2;

public interface Deque<T> extends Queue<T> {
    void insertFirst(T value);

    T removeLast();

    T peekLast();

}
