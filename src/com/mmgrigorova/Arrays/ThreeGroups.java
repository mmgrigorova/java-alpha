package com.mmgrigorova.Arrays;

import java.util.Scanner;

/**
 * Three Groups
 * You are given an array of numbers. You task is to group the numbers by remainder of 3.
 */

public class ThreeGroups {
    public static void threeGroups() {
        Scanner in = new Scanner(System.in);
        String array = in.nextLine();
        String[] arraySplit = array.split(" ");

        int[] numbers = new int[array.length()];
        int n = arraySplit.length;


        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(arraySplit[i]);
        }

        // Print group which divides by 3
        for (int i = 0; i < n; i++) {
            if (numbers[i] % 3 == 0) {
                System.out.print(numbers[i] + " ");
            }
        }
        System.out.println();

        // Print group with remainder 1
        for (int i = 0; i < n; i++) {
            if (numbers[i] % 3 == 1) {
                System.out.print(numbers[i] + " ");
            }
        }
        System.out.println();

        // Print group with remainder 2
        for (int i = 0; i < n; i++) {
            if (numbers[i] % 3 == 2) {
                System.out.print(numbers[i] + " ");
            }
        }
    }
}
