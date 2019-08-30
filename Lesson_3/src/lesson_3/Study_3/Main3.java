package lesson_3.Study_3;

import lesson_3.Study_3.queue.PriorityQueue;
import lesson_3.Study_3.queue.Queue;
import lesson_3.Study_3.stack.Stack;
import lesson_3.Study_3.stack.StackImpl;

public class Main3 {
    public static void main(String[] args) {
        testQueue();
    }

    private static void testQueue() {
        Queue<Integer> queue = new PriorityQueue<>(5);
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
        Stack<Integer> stack = new StackImpl<>(5);
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
}
