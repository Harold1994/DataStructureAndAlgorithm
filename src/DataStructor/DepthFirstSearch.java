package DataStructor;

import java.util.Stack;

public class DepthFirstSearch {
    private boolean[] isMarked;
    private int begin;
    private int count;
    private Integer [] edgeTo;

    public DepthFirstSearch(Graph g, int begin) {
        isMarked = new boolean[g.V()];
        edgeTo = new Integer[g.V()];
        count = 0;
        this.begin = begin;
        dfs2(g,begin);
    }

    //递归算法
    private void dfs(Graph g, int begin) {
        isMarked[begin] = true;
        for (int i : g.adj(begin)) {
            if (!isMarked[i]) {
                edgeTo[i] = begin;
                count++;
                dfs(g,i);
            }
        }
    }

    //非递归
    private void dfs2 (Graph g, int begin) {
        isMarked[begin] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(begin);
        while (!stack.isEmpty()) {
            boolean is_push = false;
            int v = stack.peek();
            for (int i : g.adj(v)) {
                if (!isMarked[i]) {
                    isMarked[i] = true;
                    stack.push(i);
                    edgeTo[i] = v;
                    is_push = true;
                    break;
                }
            }
            if (!is_push){
                stack.pop();
            }
        }
    }

    public boolean hasPath(int s) {
        return isMarked[s];
    }

    public int count() {
        return count;
    }

    public String pathTo(int v) {
        if (!hasPath(v))
            return "";
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        for (int i = v; i!=begin; i=edgeTo[i])
            stack.push(edgeTo[i]);
    return stack.toString();
    }
}
