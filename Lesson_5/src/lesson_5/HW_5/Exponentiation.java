package lesson_5.HW_5;

public class Exponentiation {

    public static void main(String[] args) {
        System.out.println(exponentiation(3, 4));
        System.out.println(exponentiation(3, 0));
        System.out.println(exponentiation(0, 0));
        System.out.println(exponentiation(0, 25));
    }

    private static int exponentiation(int digit, int rank) {
        if (rank < 0) {
            throw new IllegalArgumentException("Invalid value rank = " + rank);
        }

        int tmp = 1;
        if (rank >= 1) {
            tmp = digit * exponentiation(digit, rank - 1);
        }
        return tmp;
    }

}
