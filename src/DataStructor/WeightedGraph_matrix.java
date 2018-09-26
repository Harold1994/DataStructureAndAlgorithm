package DataStructor;

public class WeightedGraph_matrix {

    private int [][] edges;
    private Object [] labels;

    public WeightedGraph_matrix(int n) {
        edges = new int [n][n];
        labels = new Object[n];
    }

    public int size() {
        return labels.length;
    }

    public void setLabel(int vertex, int target) {
        labels[vertex] = target;
    }

    public Object getLabel(int vertex) {
        return labels[vertex];
    }

    public void addEdge(int source, int target, int w) {
        edges[source][target] = w;
    }

    public boolean isEdge(int source, int target){
        return edges[source][target]>0;
    }

    public void removeEdge(int source, int target) {
        edges[source][target] = 0;
    }

    public int getWeight(int source, int target) {
        return edges[target][source];
    }

    public int [] neibours(int vertex) {
        int count = 0;
        for (int i = 0; i<edges[vertex].length; i++) {
            if (edges[vertex][i]>0)
                count++;
        }
        final int [] answer = new int[count];
        count = 0;
        for (int i = 0; i<edges[vertex].length; i++) {
            if (edges[vertex][i] > 0 )
                answer[count++] = i;
        }
        return answer;
    }

    public void print() {
        for (int i = 0; i<edges.length; i++) {
            System.out.println(labels[i] + ": ");
            for (int j : neibours(i)){
                System.out.println(labels[j] + ":" + edges[i][j]);
            }
            System.out.println();
        }
    }
}
