package DataStructor;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Graph {
    private int V;//结点数目
    private int E;//边数
    private List<Integer>[] adj ;//邻接表
    private int [][] a;//邻接矩阵

    public Graph(int V) {
        this.V = V;
        E = 0;
        a = new int[V][V];
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    public int V(){return V;}//返回节点数
    public int E(){return E;};//返回边数

    public void addEdge(int v,int w) {
        a[v][w] = 1;
        a[w][v] = 1;
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    //返回结点v的所有邻接结点
    public Iterable<Integer> adj(int v) {
//        return adj[v];
        List<Integer> t= new ArrayList<Integer>();
        for (int i = 0; i<V; i++) {
            if (a[v][i]>0)
              t.add(i);
        }
        return t;
    }

    public String toString() {
        String s = V + "个顶点，" + E + "条边";
        for (int i = 0; i<V; i ++) {
            s += i + ": ";
            for (Integer node : adj[i])
                s += node + " ";
        }
        s += "\n";
        return s;
    }

    public static void main(String[] args) {
        Graph a = new Graph(4);
        a.addEdge(0,3);
        a.addEdge(2,3);
        a.addEdge(1,0);

        DepthFirstSearch dfs = new DepthFirstSearch(a,1);
        System.out.println(dfs.pathTo(3));
    }
}
