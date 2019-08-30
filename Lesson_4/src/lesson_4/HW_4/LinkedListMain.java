package lesson_4.HW_4;

import java.util.Iterator;

public class LinkedListMain {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedListImpl();
        Person anna = new Person(7, "Anna");
        Person pavel = new Person(15, "Pavel");
        Person oleg = new Person(10, "Oleg");

        linkedList.insert(anna);
        linkedList.insert(pavel);
        linkedList.insert(oleg);

        linkedList.delete(oleg);
        linkedList.delete();

        System.out.println("Contains Anna: " + linkedList.contains(anna));
        linkedList.display();

        Iterator<Person> iterator = linkedList.iterator();
        Iterator<Person> iterator2 = linkedList.iterator();

        System.out.println("Removing...");


        //Итератор с урока
//        while ( iterator.hasNext() ) {
//            iterator.next();
//            iterator.remove();
//        }


        java.util.LinkedList<String> list = new java.util.LinkedList<>();
        list.add("s1");
        list.add("s2");
        list.add("s3");

        //Итератор java для LinkedList
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            iter.next();
            iter.remove();
        }
//

        System.out.println("After remove:");
        linkedList.display();
        System.out.println(list);
    }
}

