package com.mmgrigorova.arrays;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Horse Matrix
 * <p>
 * http://judge.telerikacademy.com/problem/05horsematrix
 */

public class HorseMatrix {
    static void fakeInput() {
        String test = "4\n" +
                "- s e - \n" +
                "x - x - \n" +
                "x x - -\n" +
                "- x - x";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%s ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        fakeInput();
//        InputReader in = new InputReader();
//        int n = in.readInt();
//
//        char[][] matrix = new char[n][n];
//
//        for (int i = 0; i < n; i++) {
//            String input = in.readLine();
//            char[] line = input.toCharArray();
//            for (int j = 0; j < n; j++) {
//                matrix[i][j] = line[j];
//            }
//        }

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        String[][] matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            String input = in.nextLine();
            String[] inputs = input.split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = inputs[j];
            }
        }

        int row = 0;
        int col = 0;
        boolean hasFoundStart = false;
        //find start position
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("s")) {
                    row = i;
                    col = j;
                    hasFoundStart = true;
                    break;
                }
            }
            if (hasFoundStart) {
                break;
            }
        }
        int pathLenght = 0;
        pathLenght = findHorsePath(matrix, row, col, pathLenght);
        if (pathLenght < Integer.MAX_VALUE){
        System.out.println(pathLenght);
        } else {
            System.out.println("No");
        }
    }

    private static int findHorsePath(String[][] matrix, int startRow, int startCol, int counter) {
        int dRows[] = {-2, -1, -2, -1, +1, +2, +2, +1};
        int dCols[] = {-1, -2, +1, +2, +2, +1, -1, -2};
        int row = startRow;
        int col = startCol;

        if (matrix[row][col].equals("e")) {
            return counter;
        }

        matrix[row][col] = "x";

        counter++;
        int min = Integer.MAX_VALUE;

        int nextRow = 0;
        int nextCol = 0;
        for (int deltaIterator = 0; deltaIterator < dRows.length; deltaIterator++) {
            nextRow = row + dRows[deltaIterator];
            nextCol = col + dCols[deltaIterator];
            if (nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix.length) {
                continue;
            }
            if (!matrix[nextRow][nextCol].equals("x")) {
                min = Math.min(findHorsePath(matrix, nextRow, nextCol, counter), min);
            }
        }
        matrix[row][col] = "-";
        return min;
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
