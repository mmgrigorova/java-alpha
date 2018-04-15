package com.mmgrigorova.Combinatorics;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Next Permutation
 * http://judge.telerikacademy.com/problem/02nextpermutation
 */

public class NextPermutation {
    static void fakeInput() {
//        String test = "5\n" + "4 2 5 3 1";
//        String test = "3\n" + "1 2 3";
//        String test = "3\n" + "2 3 1";
//        String test = "31\n" + "8 12 7 29 4 1 11 17 21 24 18 3 14 27 22 23 25 16 5 20 13 9 10 26 15 28 31 19 2 30 6";
        String test = "63\n" + "44 52 9 56 19 30 33 22 32 4 61 21 53 14 51 6 36 60 48 37 24 39 16 45 42 31 28 1 26 11 55 59 43 62 18 47 54 7 15 13 5 12 35 2 40 38 3 27 49 63 20 58 46 29 8 41 23 34 25 17 57 50 10";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String perm = in.nextLine();
        String[] permutationString = perm.split(" ");
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(permutationString[i]);
        }

        if (isFinalPermutation(p)) {
            return;
        }

        int digit1;

        //From right to left search for a number that is greater that the one on the left. I.e. digits should be in
        // ascending order.
        for (digit1 = n - 2; digit1 >= 0; digit1--) {
            if (p[digit1] < p[digit1+1]) {
                break;
            }
        }

        int digit2;


        // 3 5 4 2 1
        //2 3 1
        for (digit2 = n - 1; digit2 > digit1; digit2--) {
            if (p[digit2] > p[digit1]) {
                break;
            }
        }

        if(digit1==n-1){
            digit2 = n-2;
        }

        int temp = p[digit1];
        p[digit1] = p[digit2];
        p[digit2] = temp;

        if (digit1 < digit2) {
            Arrays.sort(p, digit1+1, p.length);
        } else {
            Arrays.sort(p, digit2+1, p.length+1);
        }


        for (int j = 0; j < p.length; j++) {
            System.out.print(p[j] + " ");
        }
    }

    private static boolean isFinalPermutation(int[] permutation) {
        boolean isFinal = true;
        int bigger = permutation[0];
        for (int i = 1; i < permutation.length; i++) {
            if (bigger > permutation[i]) {
                bigger = permutation[i];
            } else {
                isFinal = false;
                return isFinal;
            }

        }
        return isFinal;
    }
}
