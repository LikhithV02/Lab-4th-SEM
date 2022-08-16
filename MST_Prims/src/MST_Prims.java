import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MST_Prims {

    /**
     * input format.
     * Line 1: <n=num of nddes> <start vertex>
     * n lines, each having n values. 0 means there is no edge between the nodes
     */

    /**
     * Algorithm for Prims_MST
     * i/p: A weighted connected graph G=(V,E)
     * o/p: ET, the set of edges composing an MST of G
     * VT←{v0} # initialize with any vertex
     * ET←Ø
     * for i=1 to |V|-1 do
     * Find a min weight edge e*=(v*,u*) among all edges (v,u) such that v∈VT and
     * u∈|V|-VT
     * Implementation to find min edge
     * For each edge (u,w), update the weight of w
     * weight(w)=min(weight(w),weight(u,w))
     * VT ← VT ∪ {v*}
     * ET ← ET ∪ {e*}
     * return ET
     */

    // Find the vertex with minimum value from the set of vertices not yet included
    // in MST\
    // returns -1 if no such vertex is found, implies graph is disconnected
    static int vertex_mincost_edge(int weight[], Boolean VT[], int V) {
        // Initialize min value
        int minwt = Integer.MAX_VALUE;
        int min_index = -1;

        for (int v = 0; v < V; v++)
            if (!VT[v] && weight[v] < minwt) {
                minwt = weight[v];// insert code here
                min_index = v;// insert code here
            }
        return min_index;
        // insert code here
    }

    // Print the constructed MST

    static void MST_print(int parent[], int graph[][], int V, int start) {
        int MSTcost = 0;
        System.out.println("Edge \tCost");
        for (int i = 0; i < V; i++) {
            if (i != start) {
                System.out.println(parent[i] + " -- " + i + "\t: " + graph[i][parent[i]]);
                // insert code here
                MSTcost += graph[i][parent[i]];// insert code here
            }
        }
        System.out.println("Cost of MST is:" + MSTcost);// insert code here
    }

    // Construct MST
    static Boolean findPrimsMST(int graph[][], int V, int start, int parent[]) {
        Boolean MSTexists = true; // assume there exists MST

        // Values used to pick minimum weight edge
        int weight[] = new int[V];

        // VT[v] is True for vertices included in MST
        Boolean VT[] = new Boolean[V];

        // Initialize all values
        for (int i = 0; i < V; i++) {
            weight[i] = Integer.MAX_VALUE;
            VT[i] = false;
            parent[i] = -1;
        }

        // Include first vertex in MST
        VT[start] = true;// insert code here;
        weight[start] = 0; // Make value 0 to pick first vertex
        // Update value and parent index of the adjacent vertices of the start vertex
        for (int v = 0; v < V; v++) {
            weight[v] = graph[start][v];
            parent[v] = start;
        }

        // in each iteration, pick one vertex corresponding to min cost edge
        for (int count = 0; count < V - 1; count++) {
            // Select the minimum value vertex from the set of vertices not yet included in
            // MST
            int u = vertex_mincost_edge(weight, VT, V);
            if (u == -1) {// graph is disconnected
                MSTexists = false;
                break;
            } else {
                // Add the selected vertex to the MST
                // insert code here
                VT[u] = true;
            }
            // Update value and parent index of the adjacent vertices of the picked vertex
            for (int v = 0; v < V; v++)
                // insert code here
                if (graph[u][v] != 0 && !VT[v] && graph[u][v] < weight[v]) {
                    parent[v] = u;
                    weight[v] = graph[u][v];
                }
        } // end for count

        // insert code here
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int i, j; // index variables
        int V; // num of nodes in the graph
        int startvertex; // start vertex for finding MST in the graph
        long starttime;
        long endtime;

        String filename = args[0];
        File inFile = new File(filename);
        Scanner in = new Scanner(inFile);
        V = in.nextInt();
        startvertex = in.nextInt();

        // read and build the adjacency matrix for the graph
        int graph[][] = new int[V][V];
        int parent[] = new int[V];
        for (i = 0; i < graph.length; i++) {
            for (j = 0; j < graph[i].length; j++) {
                graph[i][j] = in.nextInt();
                if (graph[i][j] == 0) {
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        // Find MST using Prims algo.
        // If no MST found, then it returns False.
        starttime = System.nanoTime();
        if (findPrimsMST(graph, V, startvertex, parent)) {// insert code here to call findPrimsMST) {
            endtime = System.nanoTime();
            // Call MST_print
            // insert code here
            MST_print(parent, graph, V, startvertex);
            System.out.println("Time taken: " + (endtime - starttime) + " nsecs");
        } else {
            System.out.println("Graph is disconnected and does not have a Spanning Tree");
        }
    }
} // end class MST_Prims