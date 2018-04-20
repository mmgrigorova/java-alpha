package com.mmgrigorova.Loops;

import java.util.Scanner;

/**
 * Calculate!
 * Write a program that, for a given two numbers N and x, calculates the sum 
 * S = 1 + 1!/x + 2!/x2 + … + N!/xN.
 * Use only one loop. Print the result with 5 digits after the decimal point.
 */
public class Calculate {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		double x = in.nextDouble();
		in.close();
		double result = 0d;
		long nFact = 1;
				
		if(x>=0.5 && x<=100) {
			for(int i = 1; i<=n; i++) {
				nFact = nFact*i;
				result =result + nFact/Math.pow(x,i);
			}
		}else {
			System.exit(0);
		}
	System.out.printf("%.5f",(double)(result+1d));

	}
}
