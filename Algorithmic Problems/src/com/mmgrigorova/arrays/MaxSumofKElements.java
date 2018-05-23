package com.mmgrigorova.arrays;
import java.util.Arrays;
import java.util.Scanner;
/**
 * Max Sum of K elements
 * Write a program that reads two integer numbers N and K and an array of N elements from the console. 
 * Find the maximal sum of K elements in the array.
 */
public class MaxSumofKElements {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] array = new int[n];
		int max = 0;
		
		for(int i = 0; i<n; i++) {
			array[i] = in.nextInt();
		}
		in.close();
		Arrays.sort(array);
	
		for(int i = n-k; i < n; i++) {
			max=max+array[i];
			}
		
		System.out.println(max);		
	}
}
