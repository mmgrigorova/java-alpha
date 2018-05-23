package com.mmgrigorova.loops;

import java.util.Scanner;

/**
 * Not Divisible Number
 * Write a program that reads from the console a positive integer N and prints all the numbers from 1 to N not divisible by 3 or 7, on a single line, separated by a space.
 */

public class NotDivisibleNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		if(n>1 && n < 1500) {
			for (int i = 1; i <= n; i++) {
				if(i%3 != 0 && i%7 != 0) {
					if(i==n) {
						System.out.print(i);
					}else {
						System.out.print(i + " ");
					}
				}else {
					continue;
				}
			}
			
		}
	}
}


