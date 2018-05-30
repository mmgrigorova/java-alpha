package datastructures.graphs;

public class Dijkstra {
    private static final int GRAPH_SIZE = 8;
    private static int[][] graph;

    /**
     * @param x - start index
     * @return int[] - Returns array which holds the distances from this node to
     * // all others.
     */


    //bug
    public static int[] dijkstra(int x) {
        initGraph();
        int[] result = new int[GRAPH_SIZE];
        boolean[] used = new boolean[GRAPH_SIZE];

        //initialize all best distances
        for (int i : result) {
            i = Integer.MAX_VALUE;
        }
        result[x] = 0;

        for (int n = 0; n < GRAPH_SIZE; n++) {
            int shortestPath = Integer.MAX_VALUE;
            int shortestPathNodeIndex = -1;

            for (int i = 0; i < GRAPH_SIZE; i++) {
                if (!used[i] && result[i] < shortestPath) {
                    shortestPath = result[i];
                    shortestPathNodeIndex = i;
                }
            }

            used[shortestPathNodeIndex] = true;
            for (int i = 0; i < GRAPH_SIZE; i++) {
                if (!used[i] && graph[shortestPathNodeIndex][i] > -1) {
                    int newDIstance = shortestPath + graph[shortestPathNodeIndex][i];
                    if (result[i] > newDIstance) {
                        result[i] = newDIstance;
                    }
                }
            }
        }
        return result;
    }

    private static void initGraph() {
        graph = new int[GRAPH_SIZE][GRAPH_SIZE];
        for (int i = 0; i < GRAPH_SIZE; i++) {
            for (int j = 0; j < GRAPH_SIZE; j++) {
                graph[i][j] = -1;
            }
        }

        graph[0][1] = 4;
        graph[0][2] = 4;

        graph[1][0] = 4;
        graph[1][2] = 2;
        graph[1][3] = 6;
        graph[1][6] = 5;

        graph[2][0] = 4;
        graph[2][1] = 2;
        graph[2][6] = 3;

        graph[3][1] = 6;
        graph[3][5] = 1;
        graph[3][7] = 9;

        graph[4][7] = 4;

        graph[5][3] = 1;
        graph[5][6] = 6;
        graph[5][7] = 5;

        graph[6][1] = 5;
        graph[6][2] = 3;
        graph[6][5] = 6;

        graph[7][3] = 9;
        graph[7][4] = 4;
        graph[7][5] = 5;

    }

}
