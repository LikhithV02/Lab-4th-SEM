import java.util.*;

public class MergeSort {
    static void merge(int arr[], int l, int m, int r) {
        // Computing the sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];// insert code here ??
        int R[] = new int[n2];// insert code here ??

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];// insert code here ??
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];// insert code here ??

        // Merge the temp arrays

        // Initial index of first and second subarrays
        int i = 0, j = 0;

        // Set initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                // insert code here ??
                arr[k] = L[i];
                i++;
            } else {
                // insert code here ??
                arr[k] = R[j];
                j++;
            }
            k++;
        } // while

        // Copy remaining elements of L if any
        while (i < n1) {
            // insert code here ??
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R if any
        while (j < n2) {
            // insert code here ??
            arr[k] = R[j];
            j++;
            k++;

        }
    }

    // SORT
    static void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the mid-point
            int m = l + (r - l) / 2; // insert code here ??

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
            // insert code here ??
            // Merge the sorted halves
            // insert code here ??
        }
    }

    // Display array elements
    static void display(int arr[]) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Random rand = new Random();
        int n = 0;
        int cnt_sort;
        long starttime = 0;
        long endtime = 0;
        int[] a;
        if (args.length != 2) {
            System.out.println("Usage: <prog> <num of elements> <num of sort cases");
            System.exit(-1);
        }
        n = Integer.parseInt(args[0]);
        cnt_sort = Integer.parseInt(args[1]); // num of sort cases

        for (int j = 0; j < cnt_sort; j++) {

            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = rand.nextInt(n) + 1;
            }
            // System.out.println("Unsorted Array");
            // display(a);
            starttime = System.nanoTime();
            // insert code here ??
            sort(a, 0, a.length - 1);
            endtime = System.nanoTime();

            System.out.println("Time taken for " + n + " elements :" + (endtime - starttime) + " nsecs");
            // System.out.println("Sorted array");
            // display(a);
            // double the array size
            // insert code here ??

            n = n * 2;
        } // for
    } // main
} // class