package com.mmgrigorova.Loops;

import java.util.Scanner;

/**
 * Numbers Triangle - solved with methods
 * http://judge.telerikacademy.com/problem/25numberstriangle
 * You are given the number N. Based on it, print triangles as follows:
 * Example: N = 3
 1
 1 2
 1 2 3
 1 2
 3
 */

public class NumbersTriangleMethods {
    public static void numbersTrianglesIncreasing(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf(j + " ");
            }
            System.out.println();
        }
    }


    public static void numbersTrianglesDecrasing(int n){
        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.printf(j + " ");
            }
            System.out.println();
        }
    }

    public static void numbersTriangle (int n){
        numbersTrianglesIncreasing(n);
        numbersTrianglesDecrasing(n-1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        numbersTriangle(n);
    }
}
