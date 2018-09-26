package DataStructor;

import javax.xml.stream.FactoryConfigurationError;
import java.util.Arrays;

public class BelfmanFord {
    final static private int MAXN = 0x3f3f3f3f;
    private int dis[];

    public void initializeSource(Weightedgraph.Graph g, int s) {
        for (int v = 0; v < g.getVertices(); v++) {
            dis[v] = MAXN;
        }
        dis[s] = 0;
    }

    public void relax(int source, int target, int w) {
        if (dis[target] > dis[source] + w) {
            dis[target] = dis[source] + w;
        }
    }

    void bellmanFord(Weightedgraph.Graph graph, int s) {
        int V = graph.getVertices();
        dis = new int[V];
        initializeSource(graph, s);
        for (int i = 1; i < V; i++) {
            for (int j = 0; j < V; j++) {
                for (Weightedgraph.Edge edge : graph.adj[j]) {
                    relax(edge.source, edge.target, edge.weight);
                }
            }
        }
        for (int j = 0; j < V; j++) {
            for (Weightedgraph.Edge edge : graph.adj[j]) {
                if (dis[edge.target] > dis[edge.source] + edge.weight) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }
        }
        printArr(dis, V);
    }

    void printArr(int dist[], int V) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        Weightedgraph.Graph graph = new Weightedgraph.Graph(5);
        graph.addEdge(0, 1, -1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 2);
        graph.addEdge(3, 2, 5);
        graph.addEdge(3, 1, 1);
        graph.addEdge(4, 3, -3);
        graph.printGraph();
        BelfmanFord ford = new BelfmanFord();
        ford.bellmanFord(graph, 0);
    }
}
