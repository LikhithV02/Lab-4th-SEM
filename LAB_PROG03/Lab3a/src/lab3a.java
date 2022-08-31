import java.util.Scanner;

/**
 * Write a Java program to read two integers a and b. 
 * Compute a/b and print, when b is not zero. 
 * Raise an exception when b is equal to zero.
 */
public class lab3a {
    public static void main(String[] args) {
        int a;
        int b;
        float res;
        Scanner in = new Scanner(System.in);
        while (true) {
            a = in.nextInt();
            b = in.nextInt();

            if (b != 0) {
                res = (float)(a/b);
                System.out.println(res);
            } else {
                break;
            }

        } // while
        try {
            throw new ArithmeticException("Integer divide by zero, error");
        } catch (Exception e) {
            System.out.println("Denominator can't be zero: " + e);
        } // try
    } //main
}//class
