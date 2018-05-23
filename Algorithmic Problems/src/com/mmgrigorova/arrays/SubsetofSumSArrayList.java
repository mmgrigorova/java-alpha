package com.mmgrigorova.arrays;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Subset of Sum S
 * http://judge.telerikacademy.com/problem/16subsetsums
 * We are given an array of integers and a number S. Write a program to find if there exists a subset of the elements
 * of the array that has a sum S.
 */

public class SubsetofSumSArrayList {
    static void fakeInput() {
//        String test = "14\n" +
//                "2 1 2 4 3 5 2 6";
//        String test = "10\n" +
//                "1 1 1 1 1 1 1 1 1 11";
//        String test = "27\n" +
//                "18 11";
//        String test = "25\n" +
//                "19 4 21";
        String test = "26\n" +
                "29 12 11 4 18 2 1 13 15";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void subsetSinArray() {
       fakeInput();

        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        in.nextLine();
        String[] arrayStrings = in.nextLine().split(" ");


        ArrayList<Integer> array = new ArrayList<>();

        for (String num : arrayStrings) {
            int value = Integer.parseInt(num);
            array.add(value);
        }

        Collections.sort(array, Collections.reverseOrder());
        Collections.reverse(array);
        boolean isSubset = false;

        for (int subsetStart = 0; subsetStart < array.size() - 1; subsetStart++) {
            int sum = array.get(subsetStart);
            for (int nextNumber = subsetStart+1; nextNumber < array.size(); nextNumber++) {
                if (sum +  array.get(nextNumber)<= s) {
                    sum = sum + array.get(nextNumber);
                    if (sum == s){
                        isSubset = true;
                        break;
                    }
                } else {
                    continue;
                }
            }
        }

        System.out.println(isSubset ? "yes" :"no");

    }

    public static void main(String[] args) {

        subsetSinArray();
    }
}
