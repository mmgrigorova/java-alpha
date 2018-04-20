package com.mmgrigorova.Arrays;

import java.util.Scanner;
/**
 * Longest Sequence of Equal
 * Write a program that reads two integer numbers N and K and an array of N elements from the console. 
 * Find the maximal sum of K elements in the array.
 */
public class LongestSequenceofEqual {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int n = in.nextInt();
		int[] array = new int[n];
		int maxSequence = 0;
		
		for(int i = 0; i<n; i++) {
			array[i] = in.nextInt();
		}
		in.close();
		
		int counter = 1;
		for(int i = 1; i < n; i++) {
			if(array[i-1]==array[i]) {
				counter++;
				maxSequence = Math.max(counter, maxSequence);
			}else {
				counter=1;
			}
		}
		System.out.println(maxSequence);
	}
}