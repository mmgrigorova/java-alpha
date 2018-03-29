package Loops;

import java.util.Scanner;

/**
 * Min Max Sum Average
 *
 * Write a program that reads from the console a sequence of N real numbers and returns the minimal, the maximal number, the sum and the average of all numbers (displayed with 2 digits after the decimal point).
 *
 * The input starts by the number N (alone in a line) followed by N lines, each holding an real number.
 * The output is like in the examples below.
 */

public class MinMaxSumAverage {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if (n>=1 && n<=1000) {
			double[] arr = new double[n];
			double min = 0;
			double max = 0;
			double sum = 0;
			double avg = 0;
		
		
			for (int i = 0; i<n; i++) {
				arr[i] = in.nextDouble();
				if(arr[i]<-10000 || arr[i]>10000) {
					System.exit(0);
				}
				min = arr[i];
				max = arr[i];
				sum = sum + arr[i];
			}
			in.close();
			
			avg = sum/n;
			for (int i=0; i<n; i++) {
				min = Math.min(min, arr[i]);
				max = Math.max(max, arr[i]);		
			}
			
			System.out.printf("min="+"%.2f",min);
			System.out.println();
			System.out.printf("max="+"%.2f",max);
			System.out.println();
			System.out.printf("sum="+"%.2f",sum);
			System.out.println();
			System.out.printf("avg="+"%.2f",avg);
			
			}
	}

}
