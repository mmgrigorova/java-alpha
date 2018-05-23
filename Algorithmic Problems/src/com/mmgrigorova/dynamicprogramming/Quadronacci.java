package com.mmgrigorova.dynamicprogramming;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Quadronacci
 * http://judge.telerikacademy.com/problem/04quadronacci
 */

public class Quadronacci {
    static void fakeInput() {
        String test = "1\n" +
                "1\n" +
                "0\n" +
                "5\n" +
                "10\n" +
                "4";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) throws IOException {
        fakeInput();

        Scanner in = new Scanner(System.in);
        long qn1 = in.nextInt();
        long qn2 = in.nextInt();
        long qn3 = in.nextInt();
        long qn4 = in.nextInt();
        int rows = in.nextInt();
        int cols = in.nextInt();

        long[][] matrix = new long[rows][cols];

        matrix[0][0] = qn1;
        matrix[0][1] = qn2;
        matrix[0][2] = qn3;
        matrix[0][3] = qn4;

        ArrayList<Long> sums = new ArrayList<>();
        sums.add(qn1);
        sums.add(qn2);
        sums.add(qn3);
        sums.add(qn4);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j < 4) {
                    System.out.printf("%d ", matrix[i][j]);
                } else {
                    matrix[i][j] = quadroSum(sums);
                    long newSum = matrix[i][j];
                    sums.add(newSum);
                    System.out.printf("%d ", matrix[i][j]);
                }

            }
            System.out.println();
        }

    }

    private static long quadroSum(ArrayList<Long> sums) {
        long sum = 0;
        for (int i = 0; i < 4; i++) {
            int index = sums.size() - 1 - i;
            sum += sums.get(index);
        }
        return sum;
    }
}
