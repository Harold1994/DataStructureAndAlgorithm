package DataStructor;

import java.util.LinkedList;

public class Weightedgraph {
    static class Edge{
        int source;
        int target;
        int weight;

        public Edge(int source, int target, int weight) {
            this.source = source;
            this.target = target;
            this.weight = weight;
        }
    }

    static class Graph {
        private int vertices;
        private int edges;
        LinkedList<Edge> []  adj;

        public Graph(int vertices) {
            this.edges = 0;
            this.vertices = vertices;
            adj = new LinkedList[vertices];
            for (int i = 0; i<vertices; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int target, int weight) {
            Edge edge = new Edge(source,target, weight);
            adj[source].add(edge);
            edges++;
        }

        public void printGraph() {
            for (int i = 0; i < vertices; i++) {
                LinkedList<Edge> list = adj[i];
                for (int j = 0; j< list.size(); j++) {
                    System.out.println("vertex-" + i + " is connected to" +
                            list.get(j).target + " with weight " + list.get(j).weight);
                }
            }
        }

        public int getVertices() {
            return this.vertices;
        }

        public int getEdges() {
            return edges;
        }
    }
    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 0, 4);
        graph.addEdge(4, 1, 4);
        graph.addEdge(4, 5, 6);
        graph.printGraph();
    }
}
