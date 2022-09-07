import java.util.*;
import java.io.*;

public class Quicksort {

    /**
     * once you are able to complete quicksort for integers
     * work with other data types e.g. string i.e. generate random text of size 10+
     * characters and then sort it using quicksort
     */

    /**
     * Try working quicksort where all elements are same.
     * Does it give worst case performance.
     * can you work on partition to improve it.
     */

    /**
     * rather than choosing the last element as pivot,
     * choose the middle element as pivot, and use sorted array as input
     * This should give best case analysis
     */
    // SWAP
    static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
     * Positions the pivot element at its correct position in sorted array and
     * returns the pivot element index
     */

    static int partition(int[] arr, int low, int high) {

        // select last element as the pivot
        int pivot = arr[high];
        // index left of which elements are less than pivot
        // and right of which are >= pivot.

        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {

            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        return (i + 1);
    }

    // QUICKSORT
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            swap(arr, pivot, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    static void best_quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = best_partition(arr, low, high);
            swap(arr, pivot, high);
            best_quickSort(arr, low, pivot - 1);
            best_quickSort(arr, pivot + 1, high);
        }
    }

    static int best_partition(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        swap(arr, mid, high);
        // select last element as the pivot
        int pivot = arr[high];
        // index left of which elements are less than pivot
        // and right of which are >= pivot.

        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {

            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        return (i + 1);
    }

    // Print array elements
    static void display(int[] arr, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException {

        Random rand = new Random();
        int n; // $1 number of elements
        int cnt_sort; // $2 - how many cases of different size array for Quicksort
        int cnt_rpt; // $3, number of times quicksort to be done for one size
        long starttime;
        long endtime;
        int[] a; // array for random integers.
        double avg_t;

        // validation of command line arguments
        // and initialization of arguments n, cnt_sort and cnt_rpt

        // ??insert code here
        if (args.length < 3) {
            throw new IllegalArgumentException(" three args required");
        }

        n = Integer.parseInt(args[0]);
        cnt_sort = Integer.parseInt(args[1]);
        cnt_rpt = Integer.parseInt(args[2]);

        // avoiding overhead of first time mem allocation etc.
        // invoke quicksort just to nullify overhead of first time
        // invoation of random init and buffer allcoation/mgmt

        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(n);
        }
        quickSort(a, 0, n - 1);

        // AVERAGE CASE ANALYSIS
        System.out.println("AVERAGE CASE ANALYSIS");
        for (int k = 0; k < cnt_sort; k++) {
            int[] arr = new int[n];
            long sum_t = 0;
            for (int j = 0; j < cnt_rpt; j++) { // repeat given num of times for avg case value
                for (int i = 0; i < n; i++) {
                    arr[i] = rand.nextInt(n);// code to generate random numbers
                }
                starttime = System.nanoTime();
                quickSort(arr, 0, arr.length - 1);
                endtime = System.nanoTime();

                sum_t += (endtime - starttime);

            } // j loop
            avg_t = sum_t / cnt_rpt;

            System.out.println("Time taken for " + n + " elements :" + avg_t + " nsecs");
            n = n * 2; // double the size of numbers for plotting a grpah and
            // analyze the performance by drawing a graph plot
        } // k loop

        // WORST CASE ANALYSIS
        // This happens partition results in one partition being n-1.
        // using sorted input, and choosing pivot as first or last element.
        System.out.println("WORST CASE ANALYSIS");

        // at this time ensure array a[n] is already sorted.
        try {
            starttime = System.nanoTime();
            quickSort(a, 0, a.length - 1);
            endtime = System.nanoTime();
            // ?? insert code here
            // quick sort already sorted array.
            // since pivot is the last element, it should give worst case.
            //
            System.out.println("Time taken for " + a.length + " elements :" + (endtime - starttime) + " nsecs");
        } catch (Exception e) {
            System.out.println(e);
        }

        // Perform best case analysis
        // take sorted array as input, choose the middle element as pivot
        // get the results and display
        System.out.println("BEST CASE ANALYSIS");

        // at this time ensure array a[n] is already sorted.
        try {
            best_quickSort(a, 0, a.length - 1);
            starttime = System.nanoTime();
            best_quickSort(a, 0, a.length - 1);
            endtime = System.nanoTime();
            // ?? insert code here
            // quick sort already sorted array.
            // since pivot is the last element, it should give worst case.
            //
            System.out.println("Time taken for " + a.length + " elements :" + (endtime - starttime) + " nsecs");
        } catch (Exception e) {
            System.out.println(e);
        }
        // ?? insert code here for best case analysis
    }// end main
}