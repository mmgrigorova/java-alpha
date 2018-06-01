package algorithms.tasks;

import java.io.ByteArrayInputStream;
import java.util.*;

/**
 * Max Path
 * TODO: FIX
 * Find path with max sum of the nodes in a tree
 * http://judge.telerikacademy.com/problem/04maxpath
 */


public class MaxPath {
    public static Map<Integer, Integer> parentsIndex = new HashMap<>(); //node, index
    public static Map<Integer, Integer> nodesIndex = new HashMap<>(); //node, index
    public static Set<Integer> visited = new HashSet<>();
    public static int maxSum = 0;
    public static int bestNode = 0;

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);

        List<List<Integer>> tree = readTree(in);

        dfs(visited, tree, 1, 0, true);
        System.out.println(bestNode);
        System.out.println(maxSum);
//        print(tree);
        visited.clear();
//        maxSum = 0;
//        dfs(visited, tree, bestNode, maxSum, true);

//        System.out.println(bestNode);
//        System.out.println(maxSum);
    }

    public static int dfs(Set<Integer> visited, List<List<Integer>> tree,
                           int node, int tempSum, boolean isParent){

        int nodeIdx = nodesIndex.get(node);
        List<Integer> neighbours = tree.get(nodeIdx);


        for (Integer neighbour : neighbours) {
            isParent = parentsIndex.containsKey(node);
            if(!visited.contains(neighbour)) {
                visited.add(neighbour);
                System.out.println("neighbour: " + neighbour + " temp: " + tempSum);
                tempSum = neighbour + dfs(visited, tree, neighbour, tempSum, isParent );
            }

        }

        if(!isParent){
            System.out.println("base: " + node  + " temp: " + tempSum);
            if (maxSum < tempSum){
                maxSum = tempSum;
                bestNode = node;
            }
            return tempSum;
        }
return 0;
    }

    private static List<List<Integer>> readTree(Scanner in) {
        int n = in.nextInt();
        in.nextLine();
        int indexCounter = 0;

        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {

            String[] edgesStrings = in.nextLine()
                    .replaceAll("\\(", "")
                    .replaceAll("\\)", "")
                    .split(" <- ");
            int parent = Integer.parseInt(edgesStrings[0]);
            int child =  Integer.parseInt(edgesStrings[1]);

            if(parentsIndex.containsKey(parent)){
                int parentIndex = parentsIndex.get(parent);
                nodesIndex.put(child,parentIndex);
                tree.get(parentIndex).add(child);
            } else {
                tree.add(new ArrayList<>());
                parentsIndex.put(parent, indexCounter);
                nodesIndex.put(parent, indexCounter);
                nodesIndex.put(child, indexCounter);
                tree.get(indexCounter).add(parent);
                tree.get(indexCounter).add(child);
                indexCounter += 1;
            }
        }
        return tree;
    }

    public static void print(List<List<Integer>> list){
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

    static void fakeInput() {
        String test = "10\n" +
                "(5 <- 11)\n" +
                "(1 <- 8)\n" +
                "(11 <- 3)\n" +
                "(8 <- 7)\n" +
                "(1 <- 5)\n" +
                "(11 <- 2)\n" +
                "(8 <- 6)\n" +
                "(2 <- 15)\n" +
                "(8 <- 4)";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }
}
