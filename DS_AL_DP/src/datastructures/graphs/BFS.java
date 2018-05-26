package datastructures.graphs;

public class BFS {
    public static void main(String[] args) {
        Graph graph = new Graph(6);

        graph.addEdge(1,1);
        graph.addEdge(1,6);
        graph.addEdge(2, 6);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(2, 8);
        graph.addEdge(2, 2);
        graph.addEdge(3, 3);
        graph.addEdge(3, 6);
        graph.addEdge(4, 8);
        graph.addEdge(4, 6);
        graph.addEdge(4, 2);
        graph.addEdge(5, 2);
        graph.addEdge(5, 6);
        graph.addEdge(5, 8);
        graph.addEdge(5, 4);
        graph.addEdge(6, 4);
        graph.addEdge(6, 2);

        graph.bfs(0);
    }


}
