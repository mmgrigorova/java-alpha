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
            visited.add(currentCell);
            for (int i = 0; i < 4; i++) {
                int next = getNext(currentCell, power, dRows[i], dCols[i]);
                if (next > -1 && getPower(next) > -1) {
                    hasNext = true;
                    runLabRecursive(next, sum, visited);
                }
            }
            visited.remove(currentCell);
        }

        if (!hasNext) {
            maxSum = Math.max(tempSum, maxSum);
        }
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
        String test = "0 0\n" +
                "5 6\n" +
                "1 # 5 4 6 4\n" +
                "3 2 # 2 6 2\n" +
                "9 1 7 6 3 1 \n" +
                "8 2 7 3 8 6\n" +
                "3 6 1 3 1 2";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

}
