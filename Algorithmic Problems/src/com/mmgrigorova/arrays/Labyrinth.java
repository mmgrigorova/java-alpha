package com.mmgrigorova.arrays;

public class Labyrinth {
    public static boolean inRange(int value, int range) {
        if (value >= 0 && value < range) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean pathExists(int row, int col, char[][] lab) {
        boolean hasPath;
        //TODO: checks
        // next moves: top, right, down, left
        int[] deltaRows = {-1, 0, 1, 0};
        int[] deltaCols = {0, 1, 0, -1};
        int rows = lab.length;
        int cols = lab[0].length;

        lab[row][col] = 'x';
        for (int direction = 0; direction < deltaRows.length; direction++) {
            int nextRow = row + deltaRows[direction];
            int nextCol = col + deltaCols[direction];

            //is in range
            if(!inRange(nextRow, rows) || !inRange(nextCol, cols)){
                continue;
            }

            //is visited
            if(lab[nextRow][nextCol] == 'x'){
                continue;
            }
            //is exit
            if(lab[nextRow][nextCol]=='e'){
                return true;
            }

            lab[nextRow][nextCol] = 'x';
            hasPath = pathExists(nextRow,nextCol,lab);
            lab[row][col] = ' ';

            if (hasPath){
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

        boolean hasPaths = pathExists(1,0,lab);
        System.out.println(hasPaths);
    }
}
