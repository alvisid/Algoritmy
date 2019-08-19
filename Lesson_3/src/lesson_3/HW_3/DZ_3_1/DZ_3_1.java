package lesson_3.HW_3.DZ_3_1;


import java.util.Stack;

public class DZ_3_1 {
    public static void main(String[] args) {
        String str = "TestString";

        Stack stack = new Stack();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
