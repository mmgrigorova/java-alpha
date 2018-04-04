package com.mmgrigorova.Arrays;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class BitShiftMatrixMethod {

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

    static BigInteger getTempSum(char type, int position, int start, int end, boolean[][] visited, BigInteger[][]
            matrix) {
        BigInteger sum = BigInteger.valueOf(0);
        if (start <= end) {
            while (start < end) {
                if (type == 'h') {
                    sum = matrix[position][start].add(sum);
                    matrix[position][start] = BigInteger.valueOf(0);
                    System.out.print(position + ", " + start + ": " + sum);
                    start++;
                } else if (type == 'v') {
                    sum = matrix[start][position].add(sum);
                    matrix[position][start] = BigInteger.valueOf(0);
                    System.out.print(start + ", " + position + ": " + sum);
                    start++;
                }
                System.out.println();
            }
        } else { // if start >= end, ie moving backwards
            return getTempSum(type, position, end, start, visited, matrix);
        }
        return sum;
    }

//    static BigInteger getTempSumofRow(int row,  int start, int end, boolean[][] visited, BigInteger[][] matrix){
//        return getTempSum(row,start, end ,visited,matrix);
//    }
//
//    static BigInteger getTempSumofCol(int col,  int start, int end, boolean[][] visited, BigInteger[][] matrix){
//        return getTempSum(col,start, end,visited,matrix);
//    }

    public static void bitMatrixSum() {
        fakeInput();

        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        int n = in.nextInt();
        in.nextLine();
        String[] movesString = in.nextLine().split(" ");
        ArrayList<Integer> moves = new ArrayList<>();

        for (String moveElem : movesString) {
            moves.add(Integer.parseInt(moveElem));
        }

        BigInteger[][] matrix = new BigInteger[r][c];
        boolean[][] visited = new boolean[r][c];
        for (int rows = 0; rows < r; rows++) {
            for (int cols = 0; cols < c; cols++) {
                matrix[rows][cols] = BigInteger.valueOf(1).shiftLeft(r - rows - 1 + cols);
                //cols+countRows-2
                visited[rows][cols] = false;
                System.out.printf("%4d", matrix[rows][cols]);
            }
            System.out.println();
        }


        int currentRow = r - 1;
        int currentCol = 0;
        int coef = Math.max(r, c);
        BigInteger totalSum = new BigInteger(String.valueOf(0));

        for (int move = 0; move < moves.size(); move++) {
            int targetRow = moves.get(move) / coef;
            int targetCol = moves.get(move) % coef;

            System.out.println(targetRow +", " +targetCol);
            BigInteger nextMove = getTempSum('h', currentRow, currentCol, targetCol, visited, matrix);
            totalSum = totalSum.add(nextMove);
            currentCol = targetCol;
            System.out.println("total sum of move: " + totalSum);

            nextMove = getTempSum('v', currentCol, currentRow, targetRow, visited, matrix);
            totalSum = totalSum.add(nextMove);
            currentRow = targetRow;

            System.out.println("total sum of move: " + totalSum);
        }
        System.out.println(totalSum);
    }

    public static void main(String[] args) {


        bitMatrixSum();
    }
}


