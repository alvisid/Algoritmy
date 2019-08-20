package lesson_4.Study_4.iterator;

import lesson_4.Study_4.linkedlist.LinkedList;
import lesson_4.Study_4.linkedlist.SimpleLinkedListImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestIterator {

    public static void main(String[] args) {
        int[] array = {1, 2, 3};

//        for (int i = 0; i < array.length; i++) {
//        int value = array[i];
//        doAction(value);
//        }
        int index = 0;
        while (index < array.length) {
            int value = array[index++];
            doAction(value);
        }

        System.out.println("--------");

        LinkedList<Integer> linkedList = createLinkedList();

        /* IDE ругалась на этот код  */
//        for (Integer o: linkedList){
//            doAction(o);
//        }

        for (LinkedList<Integer> it = linkedList; it.hasNext(); ) {
            Integer o = it.next();
            doAction(o);
        }

        LinkedList.Node<Integer> current = linkedList.getFirst();
        while (current != null) {
            Integer value = current.value;
            doAction(value);
            current = current.next;
        }
        System.out.println("-------");

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            doAction(value);
        }
        System.out.println("-------");
        List<Integer> jdkLinkedList = new java.util.LinkedList<>();
        jdkLinkedList.add(1);
        jdkLinkedList.add(2);
        jdkLinkedList.add(3);

        /* IDE ругалась на этот код  */
//        jdkLinkedList.removeIf(value -> value & 2 == 0);
        jdkLinkedList.removeIf(value -> false);

        iterator = jdkLinkedList.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value % 2 == 0) {
                iterator.remove();
            }
//            doAction(value);
        }

        for (Integer value : arrayList) {
            doAction(value);
        }
    }

    private static LinkedList<Integer> createLinkedList() {
        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst(3);
        linkedList.insertFirst(2);
        linkedList.insertFirst(1);
        return linkedList;
    }

    private static void doAction(int value) {
        System.out.println(value);
    }
}
