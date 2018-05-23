package com.mmgrigorova.arrays;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Bounce
 * http://judge.telerikacademy.com/problem/05bounce
 */

public class Bounce {
    static void fakeInput() {
        String test = "1 2";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    private static int convert(String s) {
        int value = 0;
        int flag = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                flag = -1;
            } else {
                value = value * 10 + (s.charAt(i) - '0');
            }
        }
        if (flag == -1) {
            return -value;
        }
        return value;
    }

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int rows = convert(input[0]);
        int cols = convert(input[1]);

        int row = 1;
        int col = 1;

        int dRow = +1;
        int dCol = +1;
        int nextRow = 0;
        int nextCol = 0;

        long result = getValue(0, 0);
        if (rows == 1 || cols == 1) {
            System.out.println(getValue(0,0));
            return;
        }

        while (!isCorner(row, col, rows, cols)) {
            result += getValue(row, col);

            nextRow = nextRow + dRow;
            nextCol = nextCol + dCol;

            if (nextRow >= rows - 1 || nextRow <= 0) {
                dRow *= -1;
            }
            if (nextCol >= cols - 1 || nextCol <= 0) {
                dCol *= -1;
            }

            row += dRow;
            col += dCol;
        }
        result += getValue(row, col);
        System.out.println(result);
    }

    private static long getValue(int rows, int cols) {
        int power = rows + cols;
        return (long) Math.pow(2, power);
    }

    private static boolean isCorner(int row, int col, int rows, int cols) {
        return ((row <= 0 || row >= rows-1) &&
                ((col <= 0 || col >= cols-1)));
    }


}
