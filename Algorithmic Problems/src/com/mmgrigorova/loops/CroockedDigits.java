package com.mmgrigorova.loops;

import java.util.Scanner;

/**
 * Crooked Digits
 * The crooked digit of a given number N is calculated using the number's digits in a very weird and bendy algorithm. The algorithm takes the following steps:
 *
 * Sums the digits of the number N and stores the result back in N.
 * If the obtained result is bigger than 9, step 1. is repeated, otherwise the algorithm finishes.
 * The last obtained value of N is the result, calculated by the algorithm.
 */

public class CroockedDigits {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		int sum = 0;
		int len = input.length();
		
		if (len==1) {
			System.out.println(input);
		}else {
			while (len>1){
				char[] array = input.toCharArray();
				sum = 0;
				for(int i=0; i<len ;i++) {
					if(array[i] != '.' && array[i] != '-') {
						sum = sum + (array[i]-'0');
						
					}
				}
				len = String.valueOf(sum).length();
				input = Integer.toString(sum);
				
			}
		System.out.println(sum);
		}
		in.close();
		
	}

}
