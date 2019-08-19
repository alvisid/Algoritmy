package lesson_3.HW_3.DZ_3_2;

import java.lang.reflect.Array;


public class ArrayDeque<T> implements Deque<T>, Cloneable {

    private static final int DEFAULT_HEAD = 0;
    private static final int DEFAULT_TAIL = -1;
    int maxSize;
    int itemsCount = 0;
    int head = DEFAULT_HEAD;
    int tail = DEFAULT_TAIL;
    private T[] array;


    public ArrayDeque(Class<T> type, int maxSize) {
        this.maxSize = maxSize;
        this.array = (T[]) Array.newInstance(type, maxSize);

    }

    @Override
    public void insertFirst(T value) {
        if (head - 1 < 0) {
            head = maxSize;
        }
        array[--head] = value;
        itemsCount++;
    }

    @Override
    public T removeLast() {
        if (tail < 0) {
            tail = maxSize - 1;
        }
        T value = array[tail--];
        itemsCount--;

        return value;
    }

    @Override
    public boolean isEmpty() {
        return itemsCount == 0;
    }

    @Override
    public boolean isFull() {
        return itemsCount == maxSize;
    }

    @Override
    public int size() {
        return itemsCount;
    }

    @Override
    public void insertLast(T value) {
        if (tail == maxSize - 1) {
            tail = DEFAULT_TAIL;
        }
        array[++tail] = value;
        itemsCount++;
    }

    @Override
    public T removeFirst() {
        T value = array[head++];

        if (head == maxSize) {
            head = DEFAULT_HEAD;
        }
        itemsCount--;

        return value;
    }

    @Override
    public T peekFirst() {
        return array[head];
    }

    @Override
    public T peekLast() {
        return array[tail];
    }

    @Override
    public Deque clone() {
        try {
            return (Deque) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Failed to copy deque");
        }
    }
}
