import java.util.Scanner;

/**
 * Write a Java program to read two integers a and b. 
 * Compute a/b and print, when b is not zero. 
 * Raise an exception when b is equal to zero.
 */
public class Lab3a {
    public static void main(String[] args) {
        int a;
        int b;
        float res;
        Scanner in = new Scanner(System.in);
        while (true) {
// insert code here to read 2 integer values.

            if (b != 0) {
// insert code here to display the result in floating point
            } else {
                try {
                    throw new ArithmeticException("Integer divide by zero, error");
                } catch (Exception e) {
                    System.out.println("Denominator can't be zero: " + e);
                    System.exit(-1);
                } // try
            } // if else
        } // while
    } //main
}//class
