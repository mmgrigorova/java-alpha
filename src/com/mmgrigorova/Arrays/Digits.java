package com.mmgrigorova.Arrays;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Digits
 * http://judge.telerikacademy.com/problem/02digits
 *
 * Find the sum of the digit's patterns in a NxN matrix
 */

public class Digits {

    public static void main(String[] args) {
       // fakeInput();
        InputReader in = new InputReader();
        int n = in.readInt();

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.readInt();
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                if (matrix[i][j] == 1 && i >= 2 && i + 2 < n && j + 2 < n && isDigitOne(matrix, i, j)) {
                    result += 1;
                } else if (matrix[i][j] == 2 && i >= 1 && i + 3 < n && j + 2 < n && isDigitTwo(matrix, i, j)) {
                    result += 2;
                } else if (i + 4 < n && j + 2 < n) {
                    if (matrix[i][j] == 3 && isDigitThree(matrix, i, j)) {
                        result += 3;
                    } else if (matrix[i][j] == 4 && isDigitFour(matrix, i, j)) {
                        result += 4;
                    } else if (matrix[i][j] == 5 && isDigitFive(matrix, i, j)) {
                        result += 5;
                    } else if (matrix[i][j] == 6 && isDigitSix(matrix, i, j)) {
                        result += 6;
                    } else if (matrix[i][j] == 7 && isDigitSeven(matrix, i, j)) {
                        result += 7;
                    } else if (matrix[i][j] == 8 && isDigitEight(matrix, i, j)) {
                        result += 8;
                    } else if (matrix[i][j] == 9 && isDigitNine(matrix, i, j)) {
                        result += 9;
                    }
                }
            }

        }
        System.out.println(result);
    }

    private static boolean isDigitTwo(int[][] matrix, int i, int j) {
        return (matrix[i - 1][j + 1] == 2
                && matrix[i + 3][j + 2] == 2
                && matrix[i][j + 2] == 2
                && matrix[i + 1][j + 2] == 2
                && matrix[i + 2][j + 1] == 2
                && matrix[i + 3][j] == 2
                && matrix[i + 3][j + 1] == 2);
    }

    private static boolean isDigitOne(int[][] matrix, int i, int j) {
        return (matrix[i - 1][j + 1] == 1
                && matrix[i + 2][j + 2] == 1
                && matrix[i - 2][j + 2] == 1
                && matrix[i - 1][j + 2] == 1
                && matrix[i][j + 2] == 1
                && matrix[i + 1][j + 2] == 1);

    }

    private static boolean isDigitNine(int[][] matrix, int i, int j) {
        return (matrix[i][j + 1] == 9
                && matrix[i + 2][j + 1] == 9
                && matrix[i + 1][j] == 9
                && matrix[i + 4][j + 2] == 9
                && matrix[i][j + 2] == 9
                && matrix[i + 2][j + 2] == 9
                && matrix[i + 4][j] == 9
                && matrix[i + 4][j + 1] == 9

                && matrix[i + 1][j + 2] == 9
                && matrix[i + 3][j + 2] == 9);

    }

    private static boolean isDigitEight(int[][] matrix, int i, int j) {
        return (matrix[i + 4][j + 2] == 8
                && matrix[i + 4][j] == 8
                && matrix[i + 1][j] == 8
                && matrix[i][j + 1] == 8
                && matrix[i + 2][j + 1] == 8
                && matrix[i + 3][j + 2] == 8
                && matrix[i + 3][j] == 8
                && matrix[i + 4][j + 1] == 8
                && matrix[i][j + 2] == 8
                && matrix[i + 1][j + 2] == 8
        );
    }

    private static boolean isDigitSeven(int[][] matrix, int i, int j) {
        return (matrix[i + 4][j + 1] == 7
                && matrix[i + 1][j + 2] == 7
                && matrix[i][j + 2] == 7
                && matrix[i][j + 1] == 7
                && matrix[i + 2][j + 1] == 7
                && matrix[i + 3][j + 1] == 7
        );
    }

    private static boolean isDigitSix(int[][] matrix, int i, int j) {
        return (matrix[i][j + 1] == 6
                && matrix[i][j + 2] == 6
                && matrix[i + 4][j + 2] == 6
                && matrix[i + 4][j] == 6
                && matrix[i + 1][j] == 6
                && matrix[i + 2][j] == 6
                && matrix[i + 3][j] == 6
                && matrix[i + 4][j + 1] == 6
                && matrix[i + 2][j + 2] == 6
                && matrix[i + 3][j + 2] == 6
        );
    }

    private static boolean isDigitFive(int[][] matrix, int i, int j) {
        return (matrix[i][j + 1] == 5
                && matrix[i + 4][j + 2] == 5
                && matrix[i + 4][j] == 5
                && matrix[i + 1][j] == 5
                && matrix[i + 2][j] == 5
                && matrix[i + 4][j + 1] == 5
                && matrix[i][j + 2] == 5
                && matrix[i + 2][j + 2] == 5
                && matrix[i + 3][j + 2] == 5
        );

    }

    private static boolean isDigitFour(int[][] matrix, int i, int j) {
        return (matrix[i + 1][j] == 4
                && matrix[i + 4][j + 2] == 4
                && matrix[i + 2][j] == 4
                && matrix[i + 2][j + 1] == 4
                && matrix[i][j + 2] == 4
                && matrix[i + 1][j + 2] == 4
                && matrix[i + 2][j + 2] == 4
                && matrix[i + 3][j + 2] == 4
        );

    }

    private static boolean isDigitThree(int[][] matrix, int i, int j) {
        return (matrix[i][j + 1] == 3
                && matrix[i + 4][j + 2] == 3
                && matrix[i + 4][j] == 3
                && matrix[i + 4][j + 1] == 3
                && matrix[i][j + 2] == 3
                && matrix[i + 2][j + 1] == 3
                && matrix[i + 1][j + 2] == 3
                && matrix[i + 2][j + 2] == 3
                && matrix[i + 3][j + 2] == 3
        );
    }

    private static boolean isDigitZero(int[][] matrix, int i, int j) {
        return (matrix[i][j + 1] == 0
                && matrix[i + 1][j] == 0
                && matrix[i + 2][j] == 0
                && matrix[i + 3][j] == 0
                && matrix[i + 4][j] == 0
                && matrix[i + 4][j + 1] == 0
                && matrix[i][j + 2] == 0
                && matrix[i + 1][j + 2] == 0
                && matrix[i + 2][j + 2] == 0
                && matrix[i + 3][j + 2] == 0
                && matrix[i + 4][j + 2] == 0);
    }

    static void fakeInput() {
        String test = "7\n" +
                "9 9 9 2 2 2 1\n" +
                "9 9 9 2 2 2 1\n" +
                "9 9 9 2 2 2 1\n" +
                "9 9 9 2 2 2 1\n" +
                "9 9 9 2 2 2 1\n" +
                "9 9 9 2 2 2 1\n" +
                "1 1 1 1 1 1 1";
//        String test2 = "50\n" +
//                "9 5 8 7 5 8 2 6 2 6 0 6 6 5 2 9 0 1 3 7 8 5 7 8 4 1 6 5 8 8 6 1 7 4 3 3 0 2 3 6 9 5 7 7 5 0 7 2 5 5\n" +
//                "3 0 5 3 0 4 8 9 3 4 2 7 7 3 9 8 9 1 2 9 8 8 7 6 7 2 7 9 3 3 3 3 9 3 4 6 6 3 4 8 4 0 9 9 4 2 8 4 8 6\n" +
//                "1 6 9 6 6 5 2 8 6 8 7 8 6 9 0 8 7 4 9 3 2 7 7 7 4 8 8 8 2 5 3 3 1 7 1 7 3 2 6 8 3 7 7 5 0 6 4 9 8 5\n" +
//                "4 3 4 4 3 6 8 5 2 7 7 4 6 1 4 4 6 8 7 2 4 4 7 7 0 5 7 1 3 7 4 8 9 6 0 0 8 6 3 5 9 7 0 8 8 8 0 6 1 6\n" +
//                "9 5 1 6 0 9 6 2 4 8 8 7 3 3 3 8 2 9 0 4 5 0 7 2 3 6 4 8 0 1 4 1 9 6 8 8 7 3 5 0 3 6 2 8 7 8 5 5 5 2\n" +
//                "3 0 5 7 0 9 0 9 2 4 5 7 1 3 3 2 7 2 6 5 1 1 7 0 0 9 8 9 4 1 1 8 3 8 7 3 5 2 5 8 7 7 0 1 8 6 4 8 0 1\n" +
//                "4 8 9 0 1 1 6 5 6 1 1 0 5 3 3 6 3 2 5 0 0 4 7 7 7 3 1 2 4 4 4 9 8 3 2 5 5 5 7 6 7 0 5 8 7 8 2 8 9 8\n" +
//                "2 1 3 0 0 9 8 1 2 7 0 3 0 2 3 2 2 1 4 9 6 0 5 9 3 0 8 5 0 0 0 2 3 2 2 2 5 8 2 6 4 8 0 8 8 8 9 3 8 5\n" +
//                "5 0 3 0 2 2 6 3 7 0 1 2 3 3 3 2 2 2 9 3 6 3 9 8 4 8 9 5 3 9 1 5 7 4 4 2 5 5 4 0 6 2 0 2 5 1 7 8 2 8\n" +
//                "2 4 3 5 9 1 1 5 5 3 2 1 0 7 8 5 5 6 7 7 8 7 0 9 6 4 2 6 2 3 1 1 2 5 2 6 1 5 5 3 8 2 7 0 7 5 1 3 3 9\n" +
//                "5 0 0 5 9 4 3 4 8 5 8 4 3 2 2 1 8 5 9 2 4 3 1 4 8 6 9 0 2 0 2 9 3 2 2 2 5 5 6 2 2 7 2 0 4 4 9 9 9 5\n" +
//                "7 6 3 1 5 1 8 5 6 2 4 3 1 8 2 9 1 1 4 1 0 0 8 7 9 7 0 1 9 4 7 4 3 6 3 5 5 1 7 5 2 5 0 3 7 9 9 4 9 5\n" +
//                "2 7 0 5 4 7 7 6 1 7 0 7 5 2 5 0 9 5 4 6 3 9 4 9 9 5 9 5 9 0 2 6 3 4 1 9 3 7 2 6 8 9 9 9 4 4 9 9 9 7\n" +
//                "9 0 9 0 1 2 3 0 5 9 7 1 7 1 5 4 3 1 0 6 6 2 2 8 8 3 0 4 5 4 5 1 8 1 0 2 6 2 2 9 5 2 2 2 8 6 2 7 9 9\n" +
//                "1 8 8 1 0 7 7 1 2 7 2 8 5 0 3 6 3 5 1 2 8 0 8 0 0 4 9 0 0 1 1 2 0 5 3 7 3 7 1 2 5 5 0 4 7 7 9 9 9 2\n" +
//                "2 7 6 1 1 0 0 7 0 6 7 6 1 0 6 0 7 0 7 6 2 6 3 8 7 3 0 3 3 3 7 8 0 7 8 4 5 9 4 2 6 6 6 5 5 8 4 9 8 6\n" +
//                "9 6 3 2 0 6 3 8 3 7 0 7 3 7 9 8 6 3 6 6 6 7 5 4 9 6 9 8 3 8 9 1 4 7 3 0 4 7 7 2 1 7 6 7 2 9 3 8 5 6\n" +
//                "2 0 7 6 2 1 0 9 3 3 6 4 4 4 7 9 2 5 6 8 3 8 6 9 1 7 1 8 1 0 3 1 3 6 6 9 3 8 5 1 9 5 4 3 6 6 2 1 9 3\n" +
//                "6 7 5 7 2 3 3 7 5 4 0 2 7 2 0 5 1 8 6 6 6 4 0 2 8 8 3 2 3 4 4 0 9 7 3 5 5 5 3 2 5 5 2 0 1 7 7 1 3 0\n" +
//                "5 4 3 0 8 2 6 3 8 4 0 1 4 0 0 0 2 9 6 4 6 5 4 5 3 9 1 0 0 0 0 2 9 2 8 9 6 9 9 1 8 2 6 9 2 4 1 1 9 1\n" +
//                "5 7 2 8 1 9 0 8 6 8 0 6 2 7 3 7 1 1 6 6 6 3 0 7 6 6 8 4 2 9 9 9 9 8 5 2 9 1 1 9 9 8 2 1 0 2 0 9 6 4\n" +
//                "2 9 9 9 7 2 7 4 2 4 0 5 5 7 0 1 6 3 2 0 7 9 9 2 1 5 0 9 7 3 9 9 9 7 6 8 9 1 1 3 5 5 9 7 8 3 2 4 0 9\n" +
//                "5 6 6 5 7 2 9 7 7 2 1 8 7 8 7 1 7 8 1 1 1 5 2 8 5 2 0 2 4 8 2 9 9 7 8 0 2 2 0 3 9 2 3 8 1 6 8 0 9 7\n" +
//                "5 4 3 9 7 0 3 8 0 4 2 7 2 9 0 5 0 9 9 7 8 5 7 8 2 9 1 4 7 8 3 9 9 7 2 8 2 8 9 8 6 4 1 5 1 1 9 4 8 5\n" +
//                "6 9 1 1 8 0 6 4 7 8 8 9 0 2 1 2 4 5 6 1 2 1 9 1 1 3 3 2 7 0 9 9 9 1 1 4 8 0 8 2 2 8 1 1 9 6 4 9 4 8\n" +
//                "7 3 7 6 2 5 9 9 0 4 7 4 7 6 8 0 2 8 0 6 3 3 7 4 9 4 9 7 1 4 9 3 7 8 3 6 0 9 8 5 4 9 0 3 5 7 0 5 2 9\n" +
//                "3 5 8 7 5 3 6 2 6 8 6 2 7 6 5 3 6 9 2 2 0 3 9 5 9 9 9 3 9 9 9 9 4 2 0 4 4 0 3 0 0 6 3 0 9 2 6 6 6 1\n" +
//                "1 0 2 0 9 0 2 3 2 0 9 2 4 5 3 2 7 5 5 0 8 5 6 2 9 3 9 9 5 9 2 9 5 7 9 4 1 4 3 9 9 1 5 2 0 8 6 7 7 7\n" +
//                "5 6 8 7 2 5 4 9 2 5 0 6 8 5 7 0 6 6 1 9 1 2 1 5 1 9 9 3 2 3 9 9 1 8 4 6 0 7 5 4 0 1 4 7 8 3 6 6 6 9\n" +
//                "1 6 2 8 5 5 5 2 6 4 5 0 6 5 4 9 4 1 1 1 0 9 0 1 9 9 9 4 7 8 4 9 9 3 2 4 9 3 2 2 1 7 1 1 8 9 6 9 6 9\n" +
//                "9 3 9 3 8 5 2 2 2 6 4 0 5 8 9 5 1 3 1 0 9 0 6 8 9 9 9 9 2 9 9 9 1 7 9 1 0 5 4 0 8 7 5 6 7 1 6 6 6 3\n" +
//                "8 1 6 2 9 5 5 5 3 5 3 6 9 9 1 6 8 7 1 8 4 5 8 2 1 2 5 0 0 7 1 5 7 8 0 2 1 8 8 0 4 9 2 9 7 1 7 5 4 1\n" +
//                "2 4 3 3 9 3 3 5 0 6 3 5 1 5 4 8 9 1 1 8 4 0 9 8 3 5 2 9 4 0 5 9 6 8 4 6 1 4 9 6 9 6 7 1 6 9 8 6 4 8\n" +
//                "2 6 5 5 7 5 5 5 9 3 0 3 9 0 1 3 9 2 1 8 7 4 1 2 8 7 2 8 2 4 7 6 4 5 7 8 3 0 1 2 1 5 4 5 5 6 6 6 9 2\n" +
//                "9 5 5 6 1 8 4 3 6 9 0 7 3 5 6 4 9 3 3 3 9 8 0 9 6 1 9 6 7 2 0 5 8 9 4 1 0 8 4 9 3 0 3 1 1 3 2 9 8 0\n" +
//                "7 3 3 5 2 0 4 6 9 0 8 8 6 4 9 4 8 3 0 5 4 0 9 4 9 9 5 9 7 2 8 0 7 6 5 7 2 2 6 3 6 3 8 3 0 5 4 9 2 7\n" +
//                "5 8 8 3 6 6 6 8 6 3 5 5 9 6 2 8 0 9 8 1 1 5 7 6 8 0 2 6 4 4 4 5 7 9 7 9 1 4 9 9 4 4 6 2 8 1 4 1 1 2\n" +
//                "4 4 1 0 6 9 1 2 4 6 3 7 4 1 9 0 8 0 9 2 7 6 0 9 4 7 4 4 8 7 5 0 4 1 9 9 4 6 3 8 8 8 9 3 5 7 9 4 3 8\n" +
//                "2 4 2 8 6 6 6 1 2 9 0 6 3 7 0 3 2 2 2 9 5 1 6 0 4 8 4 6 4 0 7 4 4 0 4 1 7 6 7 0 4 2 3 4 8 2 5 2 3 1\n" +
//                "5 7 2 3 6 0 6 1 4 6 2 8 7 2 1 5 4 3 2 8 5 5 5 1 4 4 4 2 2 1 3 4 4 2 4 0 2 8 8 3 4 5 1 0 8 6 5 1 2 2\n" +
//                "7 1 9 4 6 6 6 0 8 9 2 4 9 3 3 7 4 4 7 1 2 6 5 8 4 9 4 4 3 8 7 6 4 4 4 1 5 8 5 6 8 2 9 9 1 9 6 8 6 0\n" +
//                "1 1 4 0 0 0 6 0 9 7 9 9 9 0 2 1 4 9 8 2 2 5 8 1 3 0 4 6 7 5 2 6 8 2 4 5 2 9 9 3 5 4 9 8 1 1 4 9 6 5\n" +
//                "5 7 9 4 8 5 2 3 7 9 9 9 9 4 1 1 8 4 3 6 3 4 9 5 6 8 6 0 9 2 5 7 9 2 4 5 6 3 4 0 3 9 1 0 9 5 1 5 4 2\n" +
//                "2 0 5 0 1 0 7 4 8 0 9 9 9 1 3 1 0 0 4 8 1 5 0 3 2 3 3 9 2 1 6 1 6 6 0 5 2 8 0 9 8 2 5 3 1 1 6 6 6 3\n" +
//                "4 0 0 5 1 6 9 1 8 7 7 7 9 6 3 1 5 6 5 8 3 1 0 4 9 9 0 2 2 2 7 6 3 1 6 6 0 0 5 3 6 0 0 2 2 1 2 8 0 3\n" +
//                "6 0 1 8 9 2 0 6 6 1 9 9 9 7 3 1 4 7 9 7 6 5 0 1 1 3 1 7 1 2 7 1 7 8 4 7 5 5 1 4 5 3 3 4 7 4 0 2 2 2\n" +
//                "6 4 9 2 6 0 9 9 6 6 1 3 5 7 4 3 4 1 3 2 4 9 6 5 1 3 1 5 2 7 3 8 4 9 1 2 2 4 1 3 7 6 9 5 2 2 8 6 0 3\n" +
//                "9 9 9 0 7 7 8 3 0 3 9 4 5 3 3 3 8 5 6 1 1 0 9 9 4 8 9 2 2 2 4 5 5 0 8 3 9 4 1 3 3 9 4 8 4 3 1 0 2 0\n" +
//                "3 3 9 8 1 9 9 0 5 9 7 7 0 1 9 3 8 4 0 9 2 4 4 2 8 2 6 1 4 0 7 9 8 2 5 0 5 6 8 9 4 8 8 1 6 5 8 2 8 0\n" +
//                "5 6 0 3 7 9 8 7 0 9 3 8 5 4 2 8 9 8 6 8 8 1 5 1 4 4 5 2 6 2 4 3 2 3 5 0 8 4 4 5 2 7 6 9 6 5 2 3 9 7\n";
//        String test = "8\n" +
//                "3 2 1 1 2 3 0 1\n" +
//                "2 1 1 9 7 6 4 0\n" +
//                "1 4 1 7 7 7 5 1\n" +
//                "2 4 1 4 2 7 1 1\n" +
//                "3 4 1 4 7 1 3 1\n" +
//                "0 4 4 4 7 4 5 1\n" +
//                "5 8 2 4 7 3 2 1\n" +
//                "1 2 7 4 9 2 1 8";
//        String test = "5\n" +
//                "0 3 3 3 0\n" +
//                "0 0 0 3 0\n" +
//                "0 0 3 3 0\n" +
//                "0 0 0 3 0\n" +
//                "0 3 3 3 0";
//        String test = "5\n" +
//                "0 4 0 4 0\n" +
//                "0 4 0 4 0\n" +
//                "0 4 4 4 0\n" +
//                "0 0 0 4 0\n" +
//                "0 0 0 4 0";
//        String test = "5\n" +
//                "0 0 5 5 5\n" +
//                "0 0 5 0 0\n" +
//                "0 0 5 5 5\n" +
//                "0 0 0 0 5\n" +
//                "0 0 5 5 5";
//        String test = "5\n" +
//                "0 6 6 6 0\n" +
//                "0 6 0 0 0\n" +
//                "0 6 6 6 0\n" +
//                "0 6 0 6 0\n" +
//                "0 6 6 6 0";
//        String test = "5\n" +
//                "0 7 7 7 0\n" +
//                "0 0 0 7 0\n" +
//                "0 0 7 0 0\n" +
//                "0 0 7 0 0\n" +
//                "0 0 7 0 0";
//        String test = "5\n" +
//                "0 8 8 8 0\n" +
//                "0 8 0 8 0\n" +
//                "0 0 8 0 0\n" +
//                "0 8 0 8 0\n" +
//                "0 8 8 8 0";
//        String test = "5\n" +
//                "0 9 9 9 0\n" +
//                "0 9 0 9 0\n" +
//                "0 9 9 9 0\n" +
//                "0 0 0 9 0\n" +
//                "0 9 9 9 0";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        InputReader() {
            this.stream = System.in;
        }

        int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        double readDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.' && c != ',') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.' || c == ',') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        String readLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}