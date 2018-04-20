package com.mmgrigorova.Conditionals;
import java.util.Scanner;

/**
 * Sort Three Numbers
 * Write a program that enters 3 real numbers and prints them sorted in descending order.
 * Use nested if statements._
 * Don’t use arrays and the built-in sorting functionality._
 */

public class SortedThreeNumbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n1 = input.nextInt();
		int n2 = input.nextInt();
		int n3 = input.nextInt();
		input.close();

		if(n1 >=-1000 && n1 <= 1000 && n2 >=-1000 && n2 <= 1000 && n3 >=-1000 && n3 <= 1000) {
			if (n1 >= n2 && n1 >= n3) {
				if(n2 >= n3) {
					System.out.println(n1 + " " + n2 + " " + n3);
				} else {
					System.out.println(n1 + " " + n3 + " " + n2);
				}			
			} else if (n2 >= n1 && n2 >= n3){
				if (n1 >= n3) {
					System.out.println(n2 + " " + n1 + " " + n3);
				} else {
					System.out.println(n2 + " " + n3 + " " + n1);
				}		
			}else {
				if(n1 >= n2) {
					System.out.println(n3 + " " + n1 + " " + n2);
				} else {
					System.out.println(n3 + " " + n2 + " " + n1);
				}
			}
	
		}
	}

}
