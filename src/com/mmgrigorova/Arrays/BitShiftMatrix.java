//package com.mmgrigorova.Arrays;
//
//import java.io.ByteArrayInputStream;
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.StringJoiner;
//
//public class BitShiftMatrix {
//    public static int sum = 0;
//
//    public ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
//
//
//    static void fakeInput() {
//        String test = "5 \n" +
//                "6\n" +
//                "4\n" +
//                "14 27 1 5";
//        System.setIn(new ByteArrayInputStream(test.getBytes()));
//    }
//
//    private static int findSum(ArrayList<ArrayList<Integer>> matrix, int rows, int cols) {
//        int value = matrix.get(rows).get(cols);
//        sum = sum + value;
//        matrix.get(rows).set(cols, 0);
//        System.out.println(rows + " " + cols + " " + value + " " + sum);
//        return sum;
//    }
//
//
//    public static void bitMatrix() {
//        fakeInput();
//
//        Scanner in = new Scanner(System.in);
//        int r = in.nextInt();
//        int c = in.nextInt();
//        int n = in.nextInt();
//        in.nextLine();
//        String[] movesString = in.nextLine().split(" ");
//        ArrayList<Integer> moves = new ArrayList<>();
//
//        for (String moveElem : movesString) {
//            moves.add(Integer.parseInt(moveElem));
//        }
//
//
//        public static void generateMatrix() {
//            int countRows = r;
//            for (int rs = 0; rs < r; rs++) {
//                for (int cs = 0; cs < c; cs++) {
//                    matrix.add(new ArrayList<Integer>());
//                    int cellValue = (int) Math.pow(2, cs + countRows - 1);
//                    matrix.get(rs).add(cellValue);
//                    System.out.printf("%4d", matrix.get(rs).get(cs));
//                }
//                countRows--;
//                System.out.println();
//            }
//        }
//
//
//        //HasMap<String, Boolean> visited = new Has
//        int coef = Math.max(r, c);
//
//        int rows = r - 1;
//        int cols = 0;
//
//
//        for (int codeIterator = 0; codeIterator < moves.size(); codeIterator++) {
//            int nextRow = moves.get(codeIterator) / coef;
//            int nextCols = moves.get(codeIterator) / coef;
//
//            // int cellValue = (int) Math.pow(2, cols + rows - 1);
//            // sum = sum + cellValue;
//
//
//            for (int i = 0; i <= nextCols; i++) {
//                if (cols + i >= c) {
//                    break;
//                } else {
//                    findSum(matrix, rows, cols + i);
//                }
//            }
//            for (int i = 0; i <= nextRow; i++) {
//                if (rows + i >= r) {
//                    break;
//                } else {
//                    findSum(matrix, rows + i, cols);
//                }
//            }
//
//
//        }
//
//    }
//
//    public static void main(String[] args) {
//        fakeInput();
//
//
//        bitMatrix();
//    }
//
//
//}
