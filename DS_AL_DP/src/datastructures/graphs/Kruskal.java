package datastructures.graphs;

// Kruskal's minimal spanning tree algorithm

import java.util.*;

public class Kruskal {
    static final int SIZE = 5;
    static Map<Integer, Character> vertices;
    static List<int[]> edges;

    static {
        vertices = new HashMap<>();
        vertices.put(0, 'A');
        vertices.put(1, 'B');
        vertices.put(2, 'C');
        vertices.put(3, 'D');
        vertices.put(4, 'E');

        edges = new ArrayList<>();
        //{v, v, weight}
        edges.add(new int[]{0, 3, 1});
        edges.add(new int[]{0, 1, 6});
        edges.add(new int[]{1, 3, 2});
        edges.add(new int[]{3, 4, 1});
        edges.add(new int[]{1, 4, 2});
        edges.add(new int[]{1, 2, 5});
        edges.add(new int[]{4, 2, 5});


    }

    public static List<int[]> kruskal() {
        List<int[]> resultTree = new LinkedList<>();

        edges.sort(Comparator.comparingInt(x -> x[2]));

        Set<Integer> connectedNodes = new HashSet<>();


        //Finish case where nodes are connected but do not form a loop
        while(connectedNodes.size() < SIZE){
            int edgeA = edges.get(0)[0];
            int edgeB = edges.get(0)[1];

            if(!connectedNodes.contains(edgeA) && !connectedNodes.contains(edgeB)){
                resultTree.add(edges.get(0));
                connectedNodes.add(edgeA);
                connectedNodes.add(edgeB);
            } else if(connectedNodes.contains(edgeA) && connectedNodes.contains(edgeB)) {
                if(findJoint(edgeA)!= findJoint(edgeB)){
                    resultTree.add(edges.get(0));
                    connectedNodes.add(edgeA);
                    connectedNodes.add(edgeB);
                }
            }

            edges.remove(0);
        }

        return resultTree;
    }

    private static int findJoint(int edgeA) {
       return 0;
    }

    public static void printList(List<int[]> toPrint){
        for (int[] ints : toPrint) {
            for (int i = 0; i < ints.length; i++) {
                if(i < 2) {
                    System.out.printf(" %d", ints[i]);
                } else {
                    System.out.printf(" - %d", ints[i]);
                }
            }
            System.out.println();
        }
    }
}
