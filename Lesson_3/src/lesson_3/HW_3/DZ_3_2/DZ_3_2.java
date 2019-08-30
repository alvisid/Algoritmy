package lesson_3.HW_3.DZ_3_2;

public class DZ_3_2 {
    public static void main(String[] args) {

        Deque deque = new ArrayDeque<Integer>(Integer.class, 6);
        deque.insertLast(1);
        deque.insertLast(2);
        deque.insertLast(3);
        deque.insertLast(4);
        deque.insertFirst(5);
        deque.insertFirst(6);

        deque.removeFirst();
        deque.removeLast();

        displayLeftToRight(deque); /*Queue*/
//        displayRightToLeft(deque); /*Deque*/

    }

    private static <T> void displayRightToLeft(Deque<T> deque) {
        while (!deque.isEmpty()) {
            System.out.println(deque.removeLast());
        }

    }

    private static <T> void displayLeftToRight(Deque<T> deque) {
        while (!deque.isEmpty()) {
            System.out.println(deque.removeFirst());
        }
    }
}
