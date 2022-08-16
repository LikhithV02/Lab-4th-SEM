import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Floyd {
    // update the distance between all pairs w.r.t. shortest path
    static void allpairss(int n, int[][] graph) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] == Integer.MAX_VALUE || graph[k][j] == Integer.MAX_VALUE) {
                        continue;
                    } else if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                    // insert code here
                } // end for j
            } // end for i
        } // end for k
    }// end method allpairss

    // display the shortest distance between all pairs.
    static void displayss(int n, int[][] graph) {
        System.out.println("Shortest Distance between all pairs:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("distance[" + i + "][" + j + "] = " + graph[i][j]);
            } // end for j
        } // end for i
    } // end displayss

    public static void main(String[] args) throws FileNotFoundException {
        int i, j; // index variables
        int V; // num of nodes in the graph

        String filename = args[0];
        File inFile = new File(filename);
        Scanner in = new Scanner(inFile);
        V = in.nextInt();

        // read and build the adjacency matrix for the graph
        int graph[][] = new int[V][V];

        // read the graph
        for (i = 0; i < V; i++) {
            for (j = 0; j < V; j++) {
                graph[i][j] = in.nextInt();
                if (graph[i][j] == 0) {
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
            graph[i][i] = 0; // cost to itself is always zero.
        }
        // compute the shortest distance between all pairs and display
        allpairss(V, graph);
        displayss(V, graph);
    }

}