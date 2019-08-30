package lesson_5.Study_5;

import Study_2.array.Array;
import Study_2.array.ArrayImpl;

public class SortedArrayImpl<E extends Object & Comparable<? super E>> extends ArrayImpl<E> {

    public static void main(String[] args) {
        Array<Integer> array = new SortedArrayImpl<>();
        array.add(2);
        array.add(7);
        array.add(3);
        array.add(1);
        array.add(6);
        array.add(5);
        array.add(4);

        array.display();

        System.out.println("Find 6: " + array.indexOf(6));
        System.out.println("Find 666: " + array.indexOf(666));

        array.remove(6);
        System.out.println("Find 6: " + array.indexOf(6));
    }

    @Override
    public void add(E value) {
        checkGrow();
        int index;

        for (index = 0; index < size; index++) {
            if (data[index].compareTo(value) > 0) {
                break;
            }

            for (int i = size; i > index; i--) {
                data[i] = data[i - 1];
            }

            data[index] = value;
            size++;
        }
    }

    @Override
    public int indexOf(E value) {
        return recBinaryFind(value, 0, size - 1);
    }

    private int recBinaryFind(E value, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (data[mid].equals(value)) {
            return mid;
        } else if (data[mid].compareTo(value) > 0) {
            return recBinaryFind(value, low, mid - 1);
        } else {
            return recBinaryFind(value, mid + 1, high);
        }
    }
}
