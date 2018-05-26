package datastructures.graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int vertexNumber;
    private LinkedList[] adjacents;

    public Graph(int vertices) {
        vertexNumber = vertices;
        adjacents = new LinkedList[vertices+1];
        for (int i = 1; i < vertices; i++) {
            adjacents[i] = new LinkedList();
        }
    }

    public void addEdge(int vertexIdx, int value) {
        adjacents[vertexIdx].add(value);
    }


    public void bfs(int vertexIdx) {
        boolean visited[] = new boolean[vertexNumber];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[vertexIdx] = true;
        queue.add(vertexIdx);

        while (!queue.isEmpty()) {
            int visitedElem = queue.poll();
            System.out.println(visitedElem);

            Iterator<Integer> iterator = adjacents[vertexIdx].listIterator();
            while (iterator.hasNext()) {
                int elem = iterator.next();
                if (!visited[elem]) {
                    queue.add(elem);
                    visited[elem] = true;
                }
            }

        }
    }
}
