import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
/**
 * Sum of subset problem using backtracking.
 * First all elements are sorted. This helps reducing our search futher.
 * Essentially if including ith element exceeds sum, then
 * it is true for all remaining one as those have higher or equal value
 * Start from root of the tree and keep exploring
 */

/**
 * input file format
 * <n> <sum># first line contains number of elements, and sum
 * v1, v2, ..., vn # n values
 */
public class SubsetSum_Sorted {

  public static void display(int size, int[] elem, int[] x) {
    // display all the elements counted
    for (int i = 0; i < size; i++) {
      if (x[i] != 0) {
        System.out.print(elem[i] + " ");
      }
    }
    System.out.println();
  }

  /**
   * it is assumed that elements are in sorted order.
   * The soring helps in limiting the tree growth to feasible solutions only
   *
   * @param size:    size of element array
   * @param elem:    value of each element
   * @param x:       vector array indicating which elements are present
   * @param index:   index of current element array included in sum
   * @param currsum: current sum including next element
   * @param tgtsum:  target sum to be achieve
   * @return: true or false
   */
  public static void findElements(int size, int[] elem, int[] x,
                                  int index, int currsum, int tgtsum) {
    if (currsum==tgtsum) {// solution found with current index
      display(size, elem, x); // display the current subset.
      x[index] = 0;//insert code here// no need to explore further with this element
      return;
    }
    // if this is the last element, no more exploration
    if (index==size-1) {
      return;
    }
    // explore if next element can be included
    if (currsum+elem[index + 1] <= tgtsum) {
      x[index + 1] = 1;
      findElements(size,elem, x, index+1, currsum, tgt );
    }
    // explore further by excluding current element and considering next elements
    x[index] = 0;
    currsum = //insert code here
    if (//insert code here) {
      x[index + 1] = 1;
      findElements(//insert code here);
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    String filename = args[0];
    File inFile = new File(filename);
    Scanner in = new Scanner(inFile);
    int n = in.nextInt(); // number of elements
    int sum = in.nextInt(); // sum value
    int[] elem = new int[n]; //holds element values
    int[] x = new int[n]; // 1- indicating if element is counted, 0 otherwise
    int total = 0; // total of all elements
    for (int i = 0; i < n; i++) {
      elem[i] = in.nextInt();
      total += elem[i];
    }
    // sort the input array.
    Arrays.sort(elem);
    // check feasibility of solution
    if (total<sum) {
      System.out.println("No solution possible");
      return;
    }
    // start with first element
    x[0] = 1;
    findElements(n, elem, x, 0, elem[0], sum);
  } // end main
} // end class