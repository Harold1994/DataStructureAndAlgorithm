package DataStructor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BroadFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public BroadFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        this.s = s;
        BFS(G, s);
    }

    public void BFS(Graph G, int s) {
        Deque<Integer> deque = new ArrayDeque<>();
        marked[s] = true;
        deque.addFirst(s);
        while (!deque.isEmpty()) {
            s = deque.removeLast();
            for (int temp : G.adj(s)){
                if (!marked[temp]) {
                    deque.push(temp);
                    marked[temp] = true;
                    edgeTo[temp] = s;
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public List<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        v = edgeTo[v];
        while (v != s) {
            list.add(v);
            v = edgeTo[v];
        }
        return list;
    }
}
