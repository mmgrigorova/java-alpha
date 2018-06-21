package algorithms.tasks;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Largest Area in Matrix
 * https://judge.telerikacademy.com/problem/29largestareamatrix
 */

public class LargestArea {
    private static int maxArea = 0;
    private static boolean[][] visited;

    public static void main(String[] args) {
       fakeInput();
//        Scanner in = new Scanner(System.in);
        InputReader in = new InputReader();
        OutputWriter out = new OutputWriter();
        int rows = in.readInt();
        int cols = in.readInt();

        int[][] matrix = new int[rows][cols];
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = in.readInt();
            }
        }

        findMaxArea(matrix);

       out.print(maxArea);
       out.close();

    }

    private static void findMaxArea(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j]) {
                    int tempArea = dfs(matrix, i, j, matrix[i][j]);
                    maxArea = Math.max(tempArea, maxArea);
                }
            }
        }
    }

    private static int dfs(int[][] matrix, int r, int c, int previousValue) {

        if (!isValid(matrix, r, c)
                || visited[r][c]
                || matrix[r][c] != previousValue) {
            return 0;
        }

        previousValue = matrix[r][c];
        visited[r][c] = true;

        return 1 + dfs(matrix, r - 1, c, previousValue)
                + dfs(matrix, r, c + 1, previousValue)
                + dfs(matrix, r + 1, c, previousValue)
                + dfs(matrix, r, c - 1, previousValue);
    }

    private static boolean isValid(int[][] matrix, int nextRow, int nextCol) {
        return nextRow >= 0
                && nextRow < matrix.length
                && nextCol >= 0
                && nextCol < matrix[0].length;
    }


    private static void fakeInput() {

        String test = "5 6\n" +
                "1 3 2 2 2 4\n" +
                "3 3 3 2 4 4\n" +
                "4 3 1 2 3 3\n" +
                "4 3 1 3 3 1\n" +
                "4 3 3 3 1 1";

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
            return c == '\n' || c == '\r' || c == '\t' || c == -1 || c == 32;
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        OutputWriter() {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        void close() {
            writer.close();
        }
    }
}
