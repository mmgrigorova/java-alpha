package com.mmgrigorova.advancedexam;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class GreedyDwarf {
    static void fakeInput() {
            String test = "4 3\n" +
                    "3 2 4\n" +
                    "2 0 3\n" +
                    "1 1 5\n" +
                    "2 2 5";
            System.setIn(new ByteArrayInputStream(test.getBytes()));
        }

        public static void main(String[] args) {
            // fakeInput();
            Scanner in = new Scanner(System.in);
            int rows = in.nextInt();
            int cols = in.nextInt();

            int row = 0;
            int col = 0;

        int[] rowLRUD = {0, 0, -1, +1};
        int[] colLRUD = {-1, +1, 0, 0};


        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = in.nextInt();
                if (matrix[i][j] == 0) {
                    row = i;
                    col = j;
                }
            }
        }

        int collectedCoins = 0;

        boolean hasNextMove = true;
        while (hasNextMove) {

            int maxCoins = 0;
            int nextRow = -20;
            int nextCol = -20;

            for (int i = 0; i < 4; i++) {
                int neighbourRow = row + rowLRUD[i];
                int neighbourCol = col + colLRUD[i];

                if (neighbourRow >= 0 && neighbourRow < rows
                        && neighbourCol >= 0 && neighbourCol < cols
                        && matrix[neighbourRow][neighbourCol] > maxCoins
                        && matrix[neighbourRow][neighbourCol] > 0) {
                    maxCoins = matrix[neighbourRow][neighbourCol];
                    nextRow = neighbourRow;
                    nextCol = neighbourCol;
                }
            }

            if (nextRow == -20 && nextCol == -20) {
                hasNextMove = false;
                break;
            }


            row = nextRow;
            col = nextCol;

//            for (int i = 0; i < rows; i++) {
//                for (int j = 0; j < cols; j++) {
//                    System.out.printf("%d ", matrix[i][j]);
//                }
//                System.out.println();
//            }
//            System.out.println();

            matrix[row][col] -= 1;
            collectedCoins += 1;


        }

        System.out.println(collectedCoins);
    }
}
