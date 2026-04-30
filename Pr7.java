public class PrimsMST {

    // Number of vertices
    static final int V = 5;

    // Find vertex with minimum key value
    int minKey(int key[], boolean mstSet[]) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Print MST
    void printMST(int parent[], int graph[][]) {
        System.out.println("Edge \tWeight");

        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    // Prim's Algorithm
    void primMST(int graph[][]) {

        int parent[] = new int[V];     // Stores MST
        int key[] = new int[V];        // Minimum weights
        boolean mstSet[] = new boolean[V]; // Included vertices

        // Initialize keys
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Start from first vertex
        key[0] = 0;
        parent[0] = -1;

        // MST will have V-1 edges
        for (int count = 0; count < V - 1; count++) {

            // Pick minimum key vertex
            int u = minKey(key, mstSet);

            mstSet[u] = true;

            // Update adjacent vertices
            for (int v = 0; v < V; v++) {

                if (graph[u][v] != 0 &&
                    !mstSet[v] &&
                    graph[u][v] < key[v]) {

                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Print result
        printMST(parent, graph);
    }

    public static void main(String[] args) {

        // Weighted graph using adjacency matrix
        int graph[][] = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        PrimsMST obj = new PrimsMST();
        obj.primMST(graph);
    }
}
