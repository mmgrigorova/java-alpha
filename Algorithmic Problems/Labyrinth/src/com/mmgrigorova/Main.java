package com.mmgrigorova;

public class Main {
    static boolean inRange(int value, int max) {
        return 0 <= value && value < max;
    }

    static boolean pathsExist(int row, int col, char[][] lab) {
        // checks
        // outside of the lap
        int rows = lab.length;
        int cols = lab[0].length;

        int[] dRows = {0, -1, 0, 1};
        int[] dCols = {-1, 0, 1, 0};

        lab[row][col] = 'x';
        for (int dir = 0; dir < dRows.length; dir++) {
            int nextRow = row + dRows[dir];
            int nextCol = col + dCols[dir];

            if (!inRange(nextRow, rows) ||
                    !inRange(nextCol, cols)) {
                continue;
            }

            // cell already visited or wall
            if (lab[nextRow][nextCol] == 'x') {
                continue;
            }

            // isExit
            if (lab[nextRow][nextCol] == 'e') {
                return true;
            }

            lab[nextRow][nextCol] = 'x';
            boolean hasPath = pathsExist(nextRow, nextCol, lab);
            lab[row][col] = ' ';

            if (hasPath) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] lab = new char[][]{
                {'x', ' ', ' ', ' ', 'x', ' ', 'x', 'x'},
                {'s', ' ', 'x', ' ', ' ', ' ', 'x', ' '},
                {'x', ' ', 'x', ' ', 'x', ' ', ' ', ' '},
                {'x', ' ', 'x', ' ', 'x', 'x', ' ', ' '},
                {'x', ' ', ' ', ' ', 'x', 'x', ' ', ' '},
                {' ', ' ', ' ', ' ', 'x', 'x', 'e', 'x'}
        };

        boolean hasExit = pathsExist(1, 0, lab);
        System.out.println(hasExit);

    }
}
