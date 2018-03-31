package com.mmgrigorova.Arrays;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * IN PROGRESS...
 * Subset of Sum S
 * http://judge.telerikacademy.com/problem/16subsetsums
 * We are given an array of integers and a number S. Write a program to find if there exists a subset of the elements
 * of the array that has a sum S.
 */

public class SubsetofSumSArrayList {
    public static void subsetSinArray(){

        Scanner in = new Scanner(System.in);
        String[] arrayStrings = in.nextLine().split(" ");
        int s = in.nextInt();

        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        subset.add(0);

        for(String num : arrayStrings){
            int value = Integer.parseInt(num);
            array.add(value);
        }






    }

    public static void main(String[] args) {
        subsetSinArray();
    }
}
