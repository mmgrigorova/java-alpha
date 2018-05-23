package com.mmgrigorova.arrays;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Bit Shift Matrix - TO DEBUG
 * http://judge.telerikacademy.com/problem/31bitshiftmatrix
 *
 * This is a solution that sums only visited cells and does not generate the initial matrix.
 */

public class BitShiftMatrixWithBooleanMatrix {
    static void fakeInput() {
//        String test = "5\n" +
//                "4\n" +
//                "4\n" +
//                "2 22 16 10";
        String test = "5 \n" +
                "6\n" +
                "4\n" +
                "14 27 1 5";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        in.nextLine();
        in.nextLine();
        int[] moves = Arrays.stream(in.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean[][] visited = new boolean[rows][cols];

        int row = rows - 1;
        int col = 0;

        for (int move : moves) {
            int coef = Math.max(rows,cols);
            int nextRow = move/coef;
            int nextCol = move%coef;

            int colDir = col < nextCol
                    ? +1
                    : -1;

            while (col != nextCol){
                visited[row][col] = true;
                col += colDir;
            }

            int rowDir = row < nextRow
                    ? +1
                    : -1;

            while (row != nextRow){
                visited[row][col] = true;
                row += rowDir;
            }
            visited[row][col] = true;
        }

        BigInteger result = BigInteger.ZERO;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(visited[r][c]){
                    BigInteger cellValue = getValue(r,c, rows);
                    result = result.add(cellValue);
                }
            }
        }
        System.out.println(result);
    }

    public static BigInteger getValue(int r,int c, int rows){
       int power = rows-1-r+c;
       BigInteger result = new BigInteger("2");
//TODO


       return result.pow(power);
    }


}
