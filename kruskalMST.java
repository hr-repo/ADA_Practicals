import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

public class kruskalMST {
    static int V, E;

    static int find(int parent[], int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    static void union(int parent[], int x, int y) {
        int xroot = find(parent, x);
        int yroot = find(parent, y);
        parent[xroot] = yroot;
    }

    static void kruskalMST(Edge edges[]) {
        Edge result[] = new Edge[V];
        int parent[] = new int[V];

        for (int i = 0; i < V; i++)
            parent[i] = i;

        Arrays.sort(edges);

        int e = 0, i = 0;

        while (e < V - 1 && i < E) {
            Edge next = edges[i++];

            int x = find(parent, next.src);
            int y = find(parent, next.dest);

            if (x != y) {
                result[e++] = next;
                union(parent, x, y);
            }
        }

        System.out.println("Edge \tWeight");
        for (i = 0; i < e; i++) {
            System.out.println(result[i].src + " - " + result[i].dest + "\t" + result[i].weight);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number of Vertices:");
        V = sc.nextInt();

        System.out.println("Enter Number of Edges:");
        E = sc.nextInt();

        Edge edges[] = new Edge[E];

        for (int i = 0; i < E; i++) {
            edges[i] = new Edge();
            edges[i].src = sc.nextInt();
            edges[i].dest = sc.nextInt();
            edges[i].weight = sc.nextInt();
        }

        kruskalMST(edges);
        sc.close();
    }
}