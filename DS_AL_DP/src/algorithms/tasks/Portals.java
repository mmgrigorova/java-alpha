package algorithms.tasks;

import java.io.ByteArrayInputStream;
import java.util.*;

/**
 * Portals
 * http://judge.telerikacademy.com/problem/06portals
 */

public class Portals {
    static int cols = 0;
    static int rows = 0;
    static int[][] matrix;
    static int maxSum = 0;

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);

        int sr = in.nextInt();
        int sc = in.nextInt();
        rows = in.nextInt();
        cols = in.nextInt();
        in.nextLine();
        matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] oneRow = in.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = oneRow[j].equals("#") ? -1 : Integer.parseInt(oneRow[j]);
            }
        }

//        int matrixVerify[][] = new int[rows][cols];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//              matrixVerify[i][j] = codeCell(i,j);
//                System.out.printf("%4d ", matrixVerify[i][j] );
//            }
//            System.out.println();
//        }
//
//
//        System.out.println();
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                System.out.printf("%4d ", matrix[i][j] );
//            }
//            System.out.println();
//        }

        runWrapper(sr, sc);
        System.out.println(maxSum);
    }

    public static void runWrapper(int sr, int sc) {
        int currentCell = codeCell(sr, sc);
        Set<Integer> visited = new HashSet<>();
        runLabRecursive(currentCell, 0, visited);
    }


    private static void runLabRecursive(int currentCell, int tempSum, Set<Integer> visited) {
        boolean hasNext = false;

        int[] dRows = {-1, 0, +1, 0};
        int[] dCols = {0, +1, 0, -1};
        int power = getPower(currentCell);

        if (!visited.contains(currentCell)) {
            int sum = tempSum + power;
            for (int i = 0; i < 4; i++) {
                int next = getNext(currentCell, power, dRows[i], dCols[i]);
                if (next > -1 && getPower(next) > -1) {
                    hasNext = true;
                    visited.add(currentCell);
                    runLabRecursive(next, sum, visited);
                    visited.remove(currentCell);
                }
            }
        }

        if (!hasNext) {
            maxSum = Math.max(tempSum, maxSum);
        }
    }

    private static int runLabyrinth(int sr, int sc) {
        int maxSum = 0;
//        ArrayList<Integer> visited = new ArrayList<>();
//        Set<Integer> visited = new HashSet<>();
        Stack<Integer> visited = new Stack<>();
        Stack<Integer> stack = new Stack<>();

        int currentCell = codeCell(sr, sc);
        stack.push(currentCell);
        int sum = 0;
        visited.add(currentCell);
        //top , right, bottom, left
        int[] dRows = {-1, 0, +1, 0};
        int[] dCols = {0, +1, 0, -1};

        while (!stack.empty()) {
            boolean hasNext = false;
            currentCell = stack.pop();
            visited.add(currentCell);
            int power = getPower(currentCell);
            sum += power;
            for (int i = 0; i < 4; i++) {
                int next = getNext(currentCell, power, dRows[i], dCols[i]);
                if (!visited.contains(next)
                        && next >= 0 && next < rows * cols && getPower(next) > -1 && next >= 0 && next < rows * cols) {
                    stack.push(next);
                    hasNext = true;
                }
            }

            if (!hasNext) {
                sum -= power;
                maxSum = Math.max(maxSum, sum);
                System.out.printf("\nend of iteration: %d ,\n", sum);
                System.out.printf("max %d \n", maxSum);
            }

            System.out.printf("power of current %d : %d, sum: %d\n", currentCell, power, sum);

        }
        return maxSum;
    }

    private static int codeCell(int r, int c) {
        return r * cols + c;
    }

    private static int decodeRow(int cell) {
        return cell / cols;
    }

    private static int decodeCol(int cell) {
        return cell % cols;
    }

    private static int getNext(int codeCell, int power, int deltaR, int deltaC) {
        int r = decodeRow(codeCell);
        int c = decodeCol(codeCell);

        r += power * deltaR;
        c += power * deltaC;

        int next = r * cols + c;
        return (r < 0 || c < 0 || r >= rows || c >= cols) ? -1 : next;
    }

    private static int getPower(int codeCell) {
        int r = decodeRow(codeCell);
        int c = decodeCol(codeCell);

        return matrix[r][c];
    }

    private static void fakeInput() {
        String test2 = "0 0\n" +
                "5 6\n" +
                "1 # 5 4 6 4\n" +
                "0 2 # 2 6 2\n" +
                "9 1 7 6 3 1 \n" +
                "8 2 7 3 8 6\n" +
                "3 6 1 3 1 2";
        String test = "0 0\n" +
                "5 6\n" +
                "1 # 5 4 6 4\n" +
                "3 2 # 2 6 2\n" +
                "9 1 7 6 3 1 \n" +
                "8 2 7 3 8 6\n" +
                "3 6 1 3 1 2";
        String test1 = "1 3\n" +
                "8 8\n" +
                "6 6 1 3 7 2 6 2\n" +
                "6 3 6 6 7 # # 2\n" +
                "4 1 3 # # 4 1 1\n" +
                "7 2 2 7 # 1 # 6\n" +
                "6 # 5 2 # 7 6 6\n" +
                "1 4 4 2 4 5 6 3\n" +
                "7 4 4 7 4 3 3 2\n" +
                "# 1 4 5 1 7 # #\n";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

}
