package com.mmgrigorova.Loops;

import java.util.Scanner;

/**
 * Allocate Array
 * Write a program that allocates array of N integers, initializes each element by its index multiplied by 5 and the prints the obtained array on the console.
 */

public class AllocateArray {

	public static void allocateArray() {
		// Allocate Array Problem
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] intArray = new int[n];
		in.close();

        for (int i = 0; i < n; i++){
            intArray[i] = i*5;
            System.out.println(intArray[i]);
        }

	}

}
