package com.mmgrigorova.arrays;

/**
 * OLD VERSION
 * Subset of Sum S
 * We are given an array of integers and a number S. Write a program to find if there exists a subset of the elements
 * of the array that has a sum S.
 */

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class SubsetofSumSV1 {

    static void fakeInput() {
//        String test = "216\n" +
//                "12 20 21 14 2 31 5 27 28 11 24 26 11 4 14 27 14";
        String test = "10\n" +
                "1 1 1 1 1 1 1 1 1 11";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void subsetS() {
        fakeInput();
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        in.nextLine();
        String input = in.nextLine();
        in.close();
        String isSum = "no";

        String[] dataArray = input.split(" ");
        int[] arrayInt = new int[dataArray.length];

        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = Integer.parseInt(dataArray[i]);
        }

        int sum = 0;


        for (int i = 0; i < arrayInt.length - 1; i++) {
            sum = arrayInt[i];

            for (int j = i + 1; j < arrayInt.length; j++) {
                sum = sum + arrayInt[j];
                if (sum == s) {
                    isSum = "yes";
                } else if (sum > s) {
                    sum = sum - arrayInt[j];
                }
            }
        }
        System.out.println(isSum);
    }
}

