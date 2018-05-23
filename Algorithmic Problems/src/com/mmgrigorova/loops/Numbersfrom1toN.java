package com.mmgrigorova.loops;

import java.util.Scanner;


/**
 * Numbers from 1 to N
 * Write a program that enters from the console a positive integer n and prints all the numbers from 1 to N inclusive, on a single line, separated by a whitespace.
 */

public class Numbersfrom1toN {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		for (int i = 1; i <= n; i++) {
			if(i==n) {
				System.out.print(i);
			}else {
				System.out.print(i + " ");
			}
		}
		
	}

}
