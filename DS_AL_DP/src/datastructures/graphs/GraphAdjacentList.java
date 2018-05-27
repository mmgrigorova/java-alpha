package datastructures.graphs;

import java.util.*;

@SuppressWarnings("unchecked")

public class GraphAdjacentList <T>{
    private List[] adjVertices;
    private Map<T, Integer> indexMap;


    public  GraphAdjacentList(int vertices) {
        adjVertices = new List[vertices];
        for (int i = 0; i < vertices; i++) {
            adjVertices[i] = new ArrayList<T>();
        }
        indexMap = new HashMap<>();
    }

    public void addEdge(int vertexIdx, T value) {
        adjVertices[vertexIdx].add(value);
        T node = (T) adjVertices[vertexIdx].get(0);
        if(!indexMap.keySet().contains(node)) {
            indexMap.put(value, vertexIdx);
        }
    }


    public void bfs(int currentVertexIdx) {
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new ArrayDeque<>();

        T vertex = (T) adjVertices[currentVertexIdx].get(0);
        visited.add(vertex);
        queue.add(vertex);

        while (!queue.isEmpty()) {
            T node = queue.remove();
            // Find the adjacency list index of the current node:
            currentVertexIdx = getVertexIndex(node);

            String printer = node.toString();
            System.out.printf("%s ", printer);

            for (Object t : adjVertices[currentVertexIdx]) {
                if(!visited.contains(t)) {
                    queue.add((T) t);
                    visited.add((T) t);
                }
            }
        }
        System.out.println();
    }

    private int getVertexIndex(T visitedElem) {
        return indexMap.get(visitedElem);
    }

    public void dfs(int vertexIndex){
        boolean hasNext;
    }
}
