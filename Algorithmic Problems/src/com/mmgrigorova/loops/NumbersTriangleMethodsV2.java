package com.mmgrigorova.loops;

import java.util.Scanner;

public class NumbersTriangleMethodsV2 {

    static void printLine(int n){
        for (int col = 1; col < n+1; col++) {
            System.out.print((col) + " ");
        }
        System.out.println();
    }

    public static void numbersTriangle(int n){
        for (int rows = 0; rows < n; rows++) {
            printLine(rows+1);
        }
        for (int rows = n-1; rows > 0 ; rows--) {
            printLine(rows);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        numbersTriangle(n);
    }
}
