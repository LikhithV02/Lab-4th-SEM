import java.util.*;
import java.io.*;

class ALGO {
    //Find the vertex with minimum distance value,from the set of vertices not yet included in shortest path

    static int n;
    static int min_Distance(int dist[], Boolean V_included[],int V)
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (V_included[v]==false && dist[v]<= min) {
                min = dist[v];
                min_index = v;

        //insert code here
    }
    //insert code here
    return min_index;
}

    // Prints the distance array
    static void print_distance(int dist[], int n)
    {
        System.out.println("Vertex number   Distance from Source");
        for (int i = 0; i < n; i++)
            System.out.println(i + " ------->" +dist[i]);
    }

    // Dijkstra's algorithm
    static void Dijkstra(int cost[][], int src, int V) {
        // Output array of distances
        int dist[] = new int[V];

        // V_included[i] is set to true if vertex i is included in shortest path

        Boolean V_included[] = new Boolean[V];

        // Initialize all distances as Max_VALUE and V_included[] as false
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            V_included[i] = false;
            //insert code here
        }
        dist[src] = 0;
        // Distance of source vertex from itself is 0
        //insert code here

        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Select the minimum distance vertex from the set of vertices not yet considered.
            int u = min_Distance(dist, V_included, V);
            V_included[u] = true;
            //insert code here


            // Mark the selected vertex as include
            //insert code here


            // Update dist value of the adjacent vertices of the selected vertex.
            for (int v = 0; v < V; v++) {

                if (!V_included[v] && cost[u][v] != 0 && dist[u] !=Integer.MAX_VALUE && dist[u] + cost[u][v] < dist[v]) {
                    dist[v] = dist[u] + cost[u][v];
                }
                //insert code here

            }
            // Print the distance array
            //insert code here



        }
        print_distance(dist, V);
    }

    public static void main (String[] args) throws FileNotFoundException {

        int i, j, n, src;
        Scanner read = new Scanner(System.in);
        String filename = args[0];
        File inFile = new File(filename);
        Scanner in = new Scanner(inFile);
        n = in.nextInt();
        int cost[][] = new int[n][n];
        int dist[] = new int[n];
        //Read cost[i][j] from file
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {

                cost[i][j] = in.nextInt();
            }
        }

                System.out.println("Enter the source vertex:");
                src = read.nextInt();
                //Call Dijkstra's Algorithm
                //insert code here
                Dijkstra(cost, src, n);

            }
        }




