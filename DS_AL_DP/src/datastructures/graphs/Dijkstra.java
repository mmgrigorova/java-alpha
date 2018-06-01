package datastructures.graphs;

// Dijkstra's Shortest Path Algorithm

public class Dijkstra {
    private static final int SIZE = 5;
    public static int[][] graph;

    static {
        graph = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                graph[i][j] = -1;
            }
        }
        graph[0][0] = 0;
        graph[0][1] = 6;
        graph[0][3] = 1;

        graph[1][0] = 6;
        graph[1][2] = 5;
        graph[1][3] = 2;
        graph[1][4] = 2;

        graph[2][1] = 5;
        graph[2][4] = 5;

        graph[3][0] = 1;
        graph[3][1] = 2;
        graph[3][4] = 1;

        graph[4][1] = 2;
        graph[4][2] = 5;
        graph[4][3] = 1;
    }

    /**
     * @param sourceI - start node index
     * @return int[][] - Returns array which holds the distances from this node to
     * all others on the first row. Holds the previous node on the second row to help find the exact path.
     */
    public static int[][] dijkstraV2(int sourceI) {
        int[][] result = new int[2][SIZE]; //result[0][i] -> shortest distance, result[1][i] - parent node


        for (int i = 0; i < SIZE; i++) {
            result[0][i] = Integer.MAX_VALUE;
        }
        result[0][0] = 0;

        boolean[] visited = new boolean[SIZE];
        boolean existUnvisited = true;
        int currentVIndex = sourceI;


        while (existUnvisited) {
            int smallestKnownDistance = Integer.MAX_VALUE;

            for (int vToVisit = 0; vToVisit < SIZE; vToVisit++) {
                if (smallestKnownDistance > result[0][vToVisit]) {
                    if (!visited[vToVisit]) {
                        existUnvisited = true;
                        smallestKnownDistance = result[0][vToVisit];
                        currentVIndex = vToVisit;
                    } else {
                        existUnvisited = false;
                    }

                }
            }
            for (int neighbour = 0; neighbour < SIZE; neighbour++) {
                if (graph[currentVIndex][neighbour] > -1) {
                    int distToNeigh = graph[currentVIndex][neighbour];
                    int newDistance = distToNeigh + result[0][currentVIndex];

                    if (newDistance < result[0][neighbour]) {
                        result[0][neighbour] = newDistance;
                        result[1][neighbour] = currentVIndex;
                    }
                }
            }
            visited[currentVIndex] = true;
        }

        return result;
    }
}
