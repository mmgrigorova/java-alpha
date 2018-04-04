package com.mmgrigorova.Arrays;

import java.io.ByteArrayInputStream;
import java.util.*;

/**
 * IN PROGRESS...
 * Subset of Sum S
 * http://judge.telerikacademy.com/problem/16subsetsums
 * We are given an array of integers and a number S. Write a program to find if there exists a subset of the elements
 * of the array that has a sum S.
 */

public class SubsetofSumSArrayList {
    static void fakeInput() {
        String test = "2 1 2 4 3 5 2 6\n" +
        "14";
//        String test = "10\n" +
//                "1 1 1 1 1 1 1 1 1 11";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void subsetSinArray() {
       fakeInput();

        Scanner in = new Scanner(System.in);
        String[] arrayStrings = in.nextLine().split(" ");
        int s = in.nextInt();

        ArrayList<Integer> array = new ArrayList<>();
        int[] subset = new int[array.size()];

        for (String num : arrayStrings) {
            int value = Integer.parseInt(num);
            array.add(value);
        }

        Collections.sort(array);
        int sum = 0;

        for (int subsetStart = 0; subsetStart < array.size(); subsetStart++) {
            for (int currentNumber = 0; currentNumber < array.size(); currentNumber++) {
                if (sum +  array.get(currentNumber)<= s) {
                    sum = sum + array.get(currentNumber);
                    if (sum == s){
                        System.out.println("yes");
                        break;
                    }
                } else {
                    continue;
                }
            }
        }

        if (sum==0){
            System.out.println("no");
        }

    }

    public static void main(String[] args) {

        subsetSinArray();
    }
}
