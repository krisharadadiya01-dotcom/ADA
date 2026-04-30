import java.util.Arrays;

public class KruskalMST {

    // Edge class
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        // Sort edges by weight
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    // Subset class for Union-Find
    static class Subset {
        int parent, rank;
    }

    int V, E;
    Edge edges[];

    // Constructor
    KruskalMST(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];

        for (int i = 0; i < e; i++) {
            edges[i] = new Edge();
        }
    }

    // Find parent
    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    // Union of two sets
    void union(Subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    // Kruskal Algorithm
    void kruskalMST() {

        Edge result[] = new Edge[V - 1];

        for (int i = 0; i < V - 1; i++) {
            result[i] = new Edge();
        }

        // Sort edges
        Arrays.sort(edges);

        // Create subsets
        Subset subsets[] = new Subset[V];

        for (int i = 0; i < V; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        int e = 0; // Result edges count
        int i = 0; // Sorted edges index

        while (e < V - 1) {

            Edge nextEdge = edges[i++];

            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            // Include edge if no cycle
            if (x != y) {
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }

        // Print MST
        System.out.println("Edge \tWeight");

        for (i = 0; i < e; i++) {
            System.out.println(
                result[i].src + " - " +
                result[i].dest + "\t" +
                result[i].weight
            );
        }
    }

    public static void main(String[] args) {

        int V = 4; // Vertices
        int E = 5; // Edges

        KruskalMST graph = new KruskalMST(V, E);

        // Edge 0
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 10;

        // Edge 1
        graph.edges[1].src = 0;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 6;

        // Edge 2
        graph.edges[2].src = 0;
        graph.edges[2].dest = 3;
        graph.edges[2].weight = 5;

        // Edge 3
        graph.edges[3].src = 1;
        graph.edges[3].dest = 3;
        graph.edges[3].weight = 15;

        // Edge 4
        graph.edges[4].src = 2;
        graph.edges[4].dest = 3;
        graph.edges[4].weight = 4;

        // Run Kruskal
        graph.kruskalMST();
    }
}
