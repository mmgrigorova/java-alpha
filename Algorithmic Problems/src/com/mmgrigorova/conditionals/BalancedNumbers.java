package com.mmgrigorova.conditionals;

import java.util.Scanner;

/**
 * Balanced Numbers
 * A balanced number is a 3-digit number whose second digit is equal to the sum of the first and last digit.
 * Write a program which reads and sums balanced numbers. You should stop when an unbalanced number is given.
 */

public class BalancedNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean isBalanced = true;
		int sum = 0;
		
		while(isBalanced) {
			String num = in.nextLine();
			char[] digits = num.toCharArray();
			int m = digits[1]-'0';
			int l = digits[0]-'0';
			int r = digits[2]-'0';
			if(m == l+r) {
				sum = sum + Integer.parseInt(num);
			} else {
				break;
			}
		}
		System.out.println(sum);
		in.close();
	}

}
