import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TSPDP {
    // Memorizing the computed value
    public static int[][] dpmem;

    // compute power 2**p
    public static int power2(int p) {
        int pow = 1;
        for(int i=0; i<p; i++){
            pow *= 2;
        }
        return pow;
    }

    // initialize the TSP DP values
    // initially all values are infinity (Integer.MAX_VALUE)
    // except those corresponding to edge i-->0, i.e.
    // cost from each node to start node 0.
    public static void initDpmem(int V, int setsize, int[][] graph) {
        dpmem = new int[V][setsize];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < setsize; j++) {
                dpmem[i][j] = Integer.MAX_VALUE;
            }
            dpmem[i][0] = graph[i][0];//insert code here;
        }
    }

    // getter and setter functions
    public static int getDpmem(int ii, int jj) {
        return dpmem[ii][jj];
    }

    public static void setDpmem(int ii, int jj, int val) {
        dpmem[ii][jj] = val;
    }

    /**
     * this is the main function that will be called recursively
     * To compute the minimum of cost TSP Tour
     * The function first checks if the value is already computed
     * If yes, returns that value, which is key concept of Dyn.Prog.
     *
     * @param ii     : current node
     * @param V:     number of nodes
     * @param graph  : adj.matrix representing edge costs
     * @param vnodes : current set of nodes from ii to visit
     * @return
     */
    public static int mincosttsp(int ii, int V, int[][] graph, int[] vnodes) {
        /**
         * vnodes are represented using binary representation
         * Consider a 4 node graph, with nodes numbered as 0, 1, 2, 3
         * Since starting node is 0, vnodes set can only be from {1,2,3}
         * thus binary representation for power set of {1,2,3} would be as follows
         * Ø=000, {1}=001, {2}=010, {3}=100, {1,2}=011,
         * {1,3}=101, {2,3} = 110, {1,2,3} = 111
         * Converting binary to decimal gives column  index for dpmem lookup
         */

        // compute the column index for current node set and check
        // mincost from ii-->{curr node set} is already computed
        int col = 0;
        for (int j = 1; j < vnodes.length; j++) {
            col = col + vnodes[j] * power2(j-1);//insert code here;
        }
        int dpval = getDpmem(ii,col);//insert code here;
        if (dpval != Integer.MAX_VALUE) {
            return dpval;
        }

        // Start computing the value
        // g(ii,S)=min of j in S{cost[ii,j]+g(j,S-{j})}
        int[] nodeset = new int[V];
        for (int k = 0; k < V; k++) {
            nodeset[k] = vnodes[k];
        }

        int mincost = Integer.MAX_VALUE;
        for (int j = 1; j < V; j++) {
            if (nodeset[j] == 0) {
                continue; // already explored
            }
            int temp = nodeset[j];
            nodeset[j] = 0; // node j to be explored
            // compute cost[ii,j]+g(j,S-{j})
            int val = graph[ii][j] + mincosttsp(j, V, graph, nodeset);//insert code here;
            if (val < mincost) { // compute the min for all j.
                mincost = val;//insert code here;
            }
            nodeset[j] = temp; // restore it back for other operations
        }
        setDpmem(ii, col, mincost);
        return mincost;//insert code here;
    }




    /**
     * assumes start vertex is always 0.
     * Thus, set {v1,v2,...}-{0} will be considered for power set
     */
    public static void main(String[] args) throws FileNotFoundException {
        int V; // num of nodes in the graph

        String filename = args[0];
        File inFile = new File(filename);
        Scanner in = new Scanner(inFile);
        V = in.nextInt();

        // read and build the adjacency matrix for the graph
        int[][] graph = new int[V][V];
        // set of vertices to explore for TSPDP
        // value 0 means not to explore, value 1 means to explore
        int[] explore = new int[V];

        // read the graph
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = in.nextInt();
                if (graph[i][j] == 0) {
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
            // cost to itself is always zero.
            graph[i][i] = 0;
        }
        initDpmem(V, power2(V - 1), graph);
        // 0 is the start vertex
        // need to find the edge from 0-->k, with kâ[1,2,...,V-1] and k-->0
        // explore the set of all vertices other than 0.
        for (int i = 1; i < V; i++) {
            explore[i] = 1;
        }
        int cost = mincosttsp(0, V, graph, explore);
        System.out.println("Min cost for TSP = " + cost);
    }// end main
}