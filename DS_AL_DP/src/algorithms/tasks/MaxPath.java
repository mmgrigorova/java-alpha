package algorithms.tasks;

import java.io.ByteArrayInputStream;
import java.util.*;

/**
 * Max Path
 * <p>
 * Find path with max sum of the nodes in a tree
 * http://judge.telerikacademy.com/problem/04maxpath
 */


public class MaxPath {
    public static Set<Integer> visited = new HashSet<>();
    public static long maxSum = 0;
    public static int bestNode = 0;

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);

        Map<Integer, Set<Integer>> tree = readTree(in);

//        print(tree);

        int start = 1;
        dfs(start, 0, 0, tree);
        System.out.println(bestNode);
        System.out.println(maxSum);

        maxSum = 0;
//        dfs(bestNode, 0, 0, tree);

        System.out.println(bestNode);
        System.out.println(maxSum);
    }

    public static void dfs(int node, int prev, long tempSum, Map<Integer, Set<Integer>> tree) {


        boolean hasNext = false;

        for (Integer child : tree.get(node)) {
            if (child != prev) {
                long nodeSum = tempSum + child;
                hasNext = true;
                dfs(child, node, nodeSum, tree);
            }
        }

        if (!hasNext) {
            if (tempSum > maxSum) {
                maxSum = tempSum;
                bestNode = node;
            }
        }

    }

    private static Map<Integer, Set<Integer>> readTree(Scanner in) {
        int n = in.nextInt();
        in.nextLine();
        int indexCounter = 0;

        Map<Integer, Set<Integer>> tree = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {

            String[] edgesStrings = in.nextLine()
                    .replaceAll("\\(", "")
                    .replaceAll("\\)", "")
                    .split(" <- ");
            int parent = Integer.parseInt(edgesStrings[0]);
            int child = Integer.parseInt(edgesStrings[1]);

            insertNodes(parent, child, tree, indexCounter);
            insertNodes(child, parent, tree, indexCounter);
            indexCounter += 1;
        }
        return tree;
    }

    private static void insertNodes(int parent, int child, Map<Integer, Set<Integer>> tree, int indexCounter) {
        if (!tree.containsKey(parent)) {
            tree.put(parent, new HashSet<>());
        }
        tree.get(parent).add(child);
    }

    public static void print(Map<Integer, Set<Integer>> tree) {
        for (Map.Entry<Integer, Set<Integer>> integerSetEntry : tree.entrySet()) {
            System.out.println(integerSetEntry);
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