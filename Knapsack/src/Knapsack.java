import java.io.*;
import java.util.*;

public class Knapsack {
    static int i, j;

    static int GreedyKnapSack(int n, int w[], int p[], int W) {
        int c = W; // remaining weight
        int max_profit = 0;
        // call sort
        sort(n, w, p);
        for (i = 0; i < n; i++) {
            if (w[i] > c)
                continue;
            System.out.println("\tAdd Item  with Weight = " + w[i] + " and Value = " + p[i]);
            c = c - w[i];
            max_profit = max_profit + p[i];
        }
        return max_profit;
    }

    static void swap(int[] a) {
        int temp;
        temp = a[j];
        a[j] = a[j + 1];
        a[j + 1] = temp;
    }

    // sort the items based on (profit/weight) ratio
    static void sort(int n, int w[], int p[]) {
        for (i = 0; i < n - 1; i++)
            for (j = 0; j < n - i - 1; j++)
                if (((double) p[j] / w[j]) < ((double) p[j + 1] / w[j + 1])) {
                    swap(p);
                    swap(w);
                }
    }

    // Returns maximum of two integers a and b
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Returns the maximum value that can be put in knapsack of max capacity W
    static int DynamicKnapSack(int n, int wt[], int val[], int W) {
        int T[][] = new int[n + 1][W + 1];

        // Build Dynamic Knapsack table T
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= W; j++) {
                if (i == 0 || j == 0)
                    T[i][j] = 0;
                else if (wt[i - 1] <= j) {
                    /*
                     * int max;
                     * if(T[i-1][j] > (T[i-1][j-wt[i-1]] + val[i-1]))
                     * max = T[i-1][j];
                     * else
                     * max = (T[i-1][j-wt[i-1]] + val[i-1]);
                     */
                    T[i][j] = max(T[i - 1][j], T[i - 1][j - wt[i - 1]] + val[i - 1]);
                } else
                    T[i][j] = T[i - 1][j];
            }
        }

        System.out.println("Dynamic Knapsack Solution Table : \n");
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= W; j++)
                System.out.print(T[i][j] + "\t");
            System.out.println("\n");
        }

        i = n;
        j = W;
        while (i != 0) {
            if (T[i][j] != T[i - 1][j]) {
                System.out.println("\tAdd Item with Weight = " + wt[i - 1] + " and Value = " + val[i - 1]);
            }
            i--;

        }
        return T[n][W];
    }

    public static void main(String args[]) throws FileNotFoundException {
        int n = 0, W = 0;

        String filename = args[0];
        System.out.println(filename);
        File infile = new File(filename);
        Scanner in1 = new Scanner(infile);
        n = Integer.parseInt(in1.nextLine());
        W = Integer.parseInt(in1.nextLine());
        int val[] = new int[n];
        int wt[] = new int[n];

        for (int i = 0; i < n; i++)
            wt[i] = Integer.parseInt(in1.nextLine());
        for (int i = 0; i < n; i++)
            val[i] = Integer.parseInt(in1.nextLine());

        System.out.println("DYNAMIC KNAPSACK");
        System.out.println("Optimal Solution for Dynamic Knapsack: " + DynamicKnapSack(n, wt, val, W));
        System.out.println("--------------------------------------------------\n");

        System.out.println("GREEDY KNAPSACK");
        System.out.println("Optimal solution for Greedy Knapsack : " + GreedyKnapSack(n, wt, val, W));
        System.out.println("--------------------------------------------------\n");
    }
}