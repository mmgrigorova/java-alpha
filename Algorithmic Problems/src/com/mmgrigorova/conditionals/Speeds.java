package com.mmgrigorova.conditionals;

import java.util.Scanner;

/**
 * Speeds
 * > Not fully implemented
 * You are given a sequence of the speeds of cars in a single-lane street. A car can catch up to the car B, only if B is in front of A and the speed of A is greater than the speed of B, and then the speed of A is lowered to the speed of B. Each gathering of cars is called a group. Your task is to find the sum of the initial speeds of the longest group of cars (the group with most cars in it). If more than one group with equal length exists, then find the biggest sum of the initial speeds of these groups.
 *
 * Additional notes
 * Cars cannot outrun each other
 * They can only catch up
 * The street is very very long and no matter the speed
 * No car with any speed can get out of it until the end of the exam
 * Cars with equal speeds do not catch up to each other
 * They do not form a group
 */

public class Speeds {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int c = in.nextInt();
		int[] cars = new int[c];
//		int[] cars = {3,3,9,100};
//		int[] cars = {500,4,3,9,100,9,8,9,10,11,12,13};//12
//		int[] cars = {1500, 4, 6, 5, 3, 3, 9, 100, 2, 3, 1}; //11
//		int[] cars = {1,1,1,1};
//		int[] cars = {1,2,3,4,5};
		for(int i = 0; i<c; i++) {
			cars[i] = in.nextInt();
		}
		in.close();
		int longestGroup = 1;
		int longestGroupSpeed = cars[0];
		int currentGroup = 1;
		int currentGroupSpeed = cars[0];
		int firstInGroup = cars[0];
		
		for(int i = 1; i < c;) {
			while(i<=c && firstInGroup < cars[i] ) {
				currentGroup++;
				currentGroupSpeed = currentGroupSpeed + cars[i];
				if(i+1<c) {i++;} else break;
			}
			if(currentGroup > longestGroup) {
				longestGroup = currentGroup;
				longestGroupSpeed = currentGroupSpeed;
				currentGroupSpeed = 0;
				currentGroup = 1;
				firstInGroup = cars[i];
			} else if(currentGroup == longestGroup) {
				longestGroupSpeed = Math.max(longestGroupSpeed, currentGroupSpeed);
				currentGroup = 1;
				currentGroupSpeed = cars[i];
				firstInGroup = cars[i];
				i++;
			} else if(currentGroup < longestGroup){
				firstInGroup = cars[i];
				currentGroupSpeed = cars[i];
				i++;
			}
		
		}
		
		System.out.println(longestGroupSpeed);
	}

}
