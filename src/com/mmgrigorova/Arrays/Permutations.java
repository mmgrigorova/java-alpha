package com.mmgrigorova.Arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Permutations
 * http://judge.telerikacademy.com/problem/01permutations
 */
public class Permutations {

    public static void getPermutation(int index, int n,
                                      List<Integer> currentPermutation,
                                      HashSet<Integer> used) {

        if (index == n) {
            for (Integer value : currentPermutation) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }

        for (int value = 1; value < n + 1; value++) {
            //   System.out.println("index: " + index + " value: " + value);
            if (used.contains(value)) {
                continue;
            }
            used.add(value);
            currentPermutation.set(index, value);
            getPermutation(index + 1, n, currentPermutation, used);
            used.remove(value);
            //allPermutations.add(currentPermutation);
        }
        // System.out.println("current permutation: " + currentPermutation);
        return;
    }

    public static void printAllPermutations(int n) {
        List<Integer> currentPermutation = Stream.generate(() -> 0)
                .limit(n)
                .collect(Collectors.toList());
        HashSet<Integer> used = new HashSet<>();

        getPermutation(0, n, currentPermutation, used);
        return;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printAllPermutations(n);

    }
}
