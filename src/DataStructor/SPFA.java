package DataStructor;

import java.util.ArrayList;

public class SPFA {
    final static private int MAXN = 0x3f3f3f3f;
    private int dis[];
    static int V;
    private boolean [] used;
    private int [] times;
    ArrayList<Integer> list;

    public void initializeSource(Weightedgraph.Graph g, int s) {
        for (int v = 0; v < g.getVertices(); v++) {
            dis[v] = MAXN;
        }
        dis[s] = 0;
        used[s] = true;
        list.add(s);
        times[s] += 1;
    }

    public boolean relax(int source, int target, int w) {
        if (dis[target] > dis[source] + w) {
            dis[target] = dis[source] + w;
            if (!used[target]) {
                list.add(target);
                times[target] += 1;
                if (times[target]>V)
                    return false;
                used[target] = true;
            }
        }
        return true;
    }

    public void spfa(Weightedgraph.Graph graph, int src) {
        V = graph.getVertices();
        dis = new int [V];
        used = new boolean [V];
        times = new int [V];
        list = new ArrayList<Integer>();
        initializeSource(graph, src);
        while (!list.isEmpty()) {
            int a = list.get(0);
            list.remove(0);
            for (Weightedgraph.Edge edge : graph.adj[a]) {
                boolean res = relax(edge.source, edge.target, edge.weight);
                if (!res) {
                    System.out.println("存在权值为负的环路");
                    return;
                }
                used[a] = false;
            }
        }
        printArr(dis, V);
    }
    void printArr(int dist[], int V) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }
}
