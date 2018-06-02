package algorithms.tasks;

import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * Portals
 * http://judge.telerikacademy.com/problem/06portals
 */

public class Portals {
    static int cols = 0;
    static int rows = 0;
    static int[][] matrix;

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
//              matrixVerify[i][j] = i*cols + j;
//                System.out.printf("%4d ", matrixVerify[i][j] );
//            }
//            System.out.println();
//        }
//
//
//        System.out.printf("Top Left: %d \n", codeCell(0, 0));
//        System.out.printf("Top Right: %d \n", codeCell(0, cols - 1));
//        System.out.printf("Left Bottom: %d \n", codeCell(rows - 1, 0));
//        System.out.printf("Right Bottom: %d \n", codeCell(rows - 1, cols - 1));

        int maxPath = runLabyrinth(matrix, sr, sc);
        System.out.println(maxPath);
    }

    private static int runLabyrinth(int[][] matrix, int sr, int sc) {
        int maxSum = 0;
        int cols = matrix[0].length;
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        int currentCell = codeCell(sr, sc);
        stack.push(currentCell);
        int sum = 0;
        visited.add(currentCell);
        int power = 0;
        //top , right, bottom, left
        int[] dRows = {-1, 0, +1, 0};
        int[] dCols = {0, +1, 0, -1};

        while (!stack.empty()) {
            boolean hasNext = false;
            currentCell = stack.peek();
            visited.add(currentCell);
            int p = getPower(currentCell);
            System.out.printf("power of current %d : %d, sum: %d\n",currentCell, p, sum);

            for (int i = 0; i < 4; i++) {
                int next = getNext(currentCell, p, dRows[i], dCols[i]);
                if (!visited.contains(next) && next >= 0 && next < rows * cols && getPower(next) > -1) {
                    stack.push(next);
                    hasNext = true;
                    sum += power;
                    power = getPower(currentCell);
                }
            }

            if (!hasNext) {
                sum -= power;
                System.out.printf("\nend of iteration: %d ,\n", sum);
                maxSum = Math.max(maxSum, sum);
                System.out.printf("max %d \n", maxSum);
                stack.pop();
            }

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
