package com.mmgrigorova.combinatorics;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Combinations
 * http://judge.telerikacademy.com/problem/01combinations
 *
 * Solved in class using recursion. Here the N elements are elements of an array.
 */

public class Combinations {
    static void fakeInput() {
        String test = "4 3";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    private static void getCombinations(int current, int index, int max, int k,
                                        Integer[] nArray,
                                        Integer[] combination,
                                        ArrayList<List<Integer>> allCombinations) {
        if (index == k) {
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(combination));
            allCombinations.add(list);
            return;
        }

        for (int next = current; next < max; next++) {
            combination[index] = nArray[next];
            getCombinations(next + 1, index + 1, max, k,nArray, combination, allCombinations);
        }
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Integer[] nArray = new Integer[n];
        for (int i = 0; i < n; i++) {
            nArray[i] = i+1;
        }

        ArrayList<List<Integer>> allCombinations = new ArrayList<>();

        getCombinations(0,0,n,k,nArray,new Integer[k],allCombinations);

        for (List<Integer> combo : allCombinations){
            for (int elems : combo){
                System.out.print(elems + " ");
            }
            System.out.println();
        }

    }
}
