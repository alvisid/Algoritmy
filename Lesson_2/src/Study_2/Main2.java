package Study_2;

import Study_2.array.Array;
import Study_2.array.ArrayImpl;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {

//        testArray();

        Array<Integer> array = new ArrayImpl<>(5);

//        Array<Integer> array = new SortedArrayImpl<>();

        array.add(2);
        array.add(3);
        array.add(4);
        array.add(1);
        array.add(6);
        array.add(5);

        array.display();
//        array.sortBubble();
//        array.sortSelect();
        array.sortInsert();
        array.display();

        System.out.println("Find 6: " + array.indexOf(6));
        System.out.println("Find 666: " + array.indexOf(666));

        array.remove(6);
        System.out.println("Find 6: " + array.indexOf(6));
        array.display();

    }


    private static void testArray() {
//        int[] a = new int[] {1,2,3};
        int[] a = {1, 2, 3};

//        int[] a = new int[5];
//        a[0] = 1;
//        a[1] = 1;
//        a[2] = 1;


        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println("-------");
        for (int value : a) {
            System.out.println(value);
        }
        System.out.println("-------");
        Arrays.stream(a).forEach(System.out::println);
//        Arrays.stream(a).forEach(value -> System.out.println(value));
    }
}
