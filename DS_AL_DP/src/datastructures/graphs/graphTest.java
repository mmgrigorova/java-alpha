package datastructures.graphs;

import java.util.HashSet;
import java.util.List;

public class graphTest {
    public static void main(String[] args) {
        List<int[]> graphK = Kruskal.kruskal();

        Kruskal.printList(graphK);

        int[][] graphD = Dijkstra.graph;


        System.out.println("Graph used in algorithm: ");
        for (int i = 0; i < graphD.length; i++) {
            for (int j = 0; j < graphD.length; j++) {
                String toPrint = String.valueOf(graphD[i][j]);
                if (toPrint.equals("-1")) {
                    toPrint = " ";
                }
                System.out.printf("[%d][%d]%4s ",i, j, toPrint);
            }
            System.out.println();
        }

        int[][] matrix = Dijkstra.dijkstraV2(0);
        System.out.println("Dijkstra test start: ");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int elem =matrix[i][j];
                System.out.printf("%d:%d ", j, elem);
            }
            System.out.println();
        }
        System.out.println("Dijkstra test end. ");

        GraphAdjacentList<Integer> graphAdj = new GraphAdjacentList<>(5);

        graphAdj.addEdge(0, 1);
        graphAdj.addEdge(0, 2);
        graphAdj.addEdge(0, 4);
        graphAdj.addEdge(0, 5);
        graphAdj.addEdge(1, 2);
        graphAdj.addEdge(1, 1);
        graphAdj.addEdge(1, 3);
        graphAdj.addEdge(2, 3);
        graphAdj.addEdge(2, 2);
        graphAdj.addEdge(2, 4);
        graphAdj.addEdge(3, 4);
        graphAdj.addEdge(3, 1);
        graphAdj.addEdge(3, 3);
        graphAdj.addEdge(4, 5);
        graphAdj.addEdge(4, 1);


        graphAdj.bfs(0);
        graphAdj.dfs(0, new HashSet<>());

        GraphAdjacentList<Double> graphDoubleAdj = new GraphAdjacentList<>(5);

        graphDoubleAdj.addEdge(0, 1.4d);
        graphDoubleAdj.addEdge(0, 2d);
        graphDoubleAdj.addEdge(0, 4d);
        graphDoubleAdj.addEdge(0, 5d);
        graphDoubleAdj.addEdge(1, 2d);
        graphDoubleAdj.addEdge(1, 1.4d);
        graphDoubleAdj.addEdge(1, 3d);
        graphDoubleAdj.addEdge(2, 3d);
        graphDoubleAdj.addEdge(2, 2d);
        graphDoubleAdj.addEdge(2, 4d);
        graphDoubleAdj.addEdge(3, 4d);
        graphDoubleAdj.addEdge(3, 1.4d);
        graphDoubleAdj.addEdge(3, 3d);
        graphDoubleAdj.addEdge(4, 5d);
        graphDoubleAdj.addEdge(4, 1.4d);


        graphDoubleAdj.bfs(0);


        GraphAdjacentList<Character> graphChar = new GraphAdjacentList<>(5);

        graphChar.addEdge(0, 'a');
        graphChar.addEdge(0, 'b');
        graphChar.addEdge(0, 'd');
        graphChar.addEdge(0, 'e');
        graphChar.addEdge(1, 'b');
        graphChar.addEdge(1, 'a');
        graphChar.addEdge(1, 'c');
        graphChar.addEdge(2, 'c');
        graphChar.addEdge(2, 'b');
        graphChar.addEdge(2, 'd');
        graphChar.addEdge(3, 'd');
        graphChar.addEdge(3, 'a');
        graphChar.addEdge(3, 'c');
        graphChar.addEdge(4, 'e');
        graphChar.addEdge(4, 'a');


        graphChar.bfs(0);
    }


}
