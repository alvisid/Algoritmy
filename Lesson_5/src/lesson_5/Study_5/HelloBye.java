package lesson_5.Study_5;

//import static jdk.nashorn.internal.objects.Global.print;

public class HelloBye {

    public static void main(String[] args) {
        hello("VP");
    }

    private static void hello(String name) {
        print("Hello, " + name + "!");
        bye(name);
    }

    private static void bye(String name) {
        print("Good bye, " + name + "!");
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
