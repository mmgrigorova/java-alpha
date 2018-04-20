package com.mmgrigorova.Combinatorics;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Combinations with Repetitions
 * http://judge.telerikacademy.com/problem/02combinationsrepeat
 *
 * Combinations with repetitions of class K for N elements.
 */
public class CombinationsWithRepetition {
    private static int convert(String s) {
        int value = 0;
        int flag = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                flag = -1;
            } else {
                value = value * 10 + (s.charAt(i) - '0');
            }
        }
        if (flag == -1) {
            return -value;
        }
        return value;
    }

    static void fakeInput() {
        String test = "3 2";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void combine(int n, int k, int start, int index, int[] combination) {
        if (index == k) {
            for (int i = 0; i < combination.length; i++) {
                System.out.printf(combination[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int value = start; value < n + 1; value++) {
            combination[index] = value;
            combine(n, k, value , index + 1, combination);
        }

    }

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int n = convert(input[0]);
        int k = convert(input[1]);
        combine(n, k, 1, 0, new int[k]);
    }
}
