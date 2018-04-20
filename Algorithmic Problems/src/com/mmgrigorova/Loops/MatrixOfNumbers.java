package com.mmgrigorova.Loops;

import java.util.Scanner;

/**
 * Matrix of Numbers
 * Write a program that reads from the console a positive integer number N and prints a matrix like in the examples below. Use two nested loops.
 */

public class MatrixOfNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] matrix = new int[n][n];
		
		for (int i = 0; i< n; i++) {
			int value = i+1;
			for (int j = 0 ; j<n ; j++) {
				matrix[i][j] = value++;
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
