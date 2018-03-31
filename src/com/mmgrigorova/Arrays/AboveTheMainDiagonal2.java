package com.mmgrigorova.Arrays;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Above main diagonal 2
 * http://judge.telerikacademy.com/problem/17abovemaindiag2
 * You are given a square matrix of numbers, formed by powers of 2. You task is to find the sum above the main diagonal.
 */

public class AboveTheMainDiagonal2 {
    public static void aboveDiagonal2() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        BigInteger sum = BigInteger.valueOf(0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i <= j) {
                    BigInteger toAdd = BigInteger.valueOf((long) Math.pow(2, i + j));
                    sum = sum.add(toAdd);
                }
            }
        }
        System.out.println(sum);
    }

}
