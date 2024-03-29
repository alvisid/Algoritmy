package lesson_4.Study_4;

import lesson_4.Study_4.linkedlist.*;
import lesson_4.Study_4.queue.Queue;
import lesson_4.Study_4.stack.Stack;

public class Main4 {
    public static void main(String[] args) {

//        testQueue();
//        testStack();
//        testSimpleLinkedList();
        testTwoSideLinkedList();
    }


    private static void testQueue() {
        Queue<Integer> queue = new LinkedQueue<>();
        queue.insert(3);
        queue.insert(1);
        queue.insert(2);
        queue.insert(6);
        queue.insert(5);
        queue.insert(4);

        System.out.println("Top of queue is " + queue.peek());
        System.out.println("queue size is " + queue.size());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

    private static void testStack() {
        Stack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println("Top of stack is " + stack.peek());
        System.out.println("stack size is " + stack.size());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static void testSimpleLinkedList() {
        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);

        linkedList.display();

        System.out.println("Contains 2: " + linkedList.contains(2));
        System.out.println("Remove 2: " + linkedList.remove(2));
        System.out.println("Contains 2: " + linkedList.contains(2));
        System.out.println("Remove 2: " + linkedList.remove(2));

        System.out.println("Size is " + linkedList.size());
        linkedList.display();

        while (!linkedList.isEmpty()) {
            System.out.println(linkedList.removeFirst());
        }
        System.out.println(linkedList.isFull());
    }

    private static void testTwoSideLinkedList() {

        TwoSideLinkedList<Integer> linkedList = new TwoSideLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertLast(2);
        linkedList.insertFirst(3);
        linkedList.insertLast(4);

        linkedList.display();

        System.out.println("Contains 2: " + linkedList.contains(2));
        System.out.println("Remove 2: " + linkedList.remove(2));
        System.out.println("Contains 2: " + linkedList.contains(2));
        System.out.println("Remove 2: " + linkedList.remove(2));

        System.out.println("Size is " + linkedList.size());
        linkedList.display();

        while (!linkedList.isEmpty()) {
            System.out.println(linkedList.removeFirst());
        }

    }
}
