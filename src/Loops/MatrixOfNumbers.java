package Loops;

import java.util.Scanner;

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
