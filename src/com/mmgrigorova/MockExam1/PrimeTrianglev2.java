package com.mmgrigorova.MockExam1;

import java.util.Scanner;

/**
 * Prime Triangle
 * We know that you love math, so we have prepared a very interesting task, that involves both geometry and prime numbers.
 * By a given N number, from which you need to generate a sequence of 1 to N inclusive. For every prime number in
 * that sequence, you need to print out all the other numbers before it (and the number itself), whether they are prime or not
 */

public class PrimeTrianglev2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] nums = new int[n];
		int[] primes = new int[n];
		
		//populates primes
		for(int i=0; i<n; i++) {
			nums[i] = i+1;
			primes[i] = 1;
			for(int j=i-1; j>0; j-- ) {
					if(nums[i]%nums[j] == 0) {
						primes[i] = 0;
				}
			}
			
			if(primes[i] == 1) {
				for(int j=0; j<=i; j++) {
					if(j<i) {
						System.out.print(primes[j]);
					}else {
						System.out.println(primes[j]);
					}
				}
			} 
		}
		in.close();
	}
}
