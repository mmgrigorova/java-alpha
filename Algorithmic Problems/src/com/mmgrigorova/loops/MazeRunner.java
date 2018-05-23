package com.mmgrigorova.loops;

import java.util.Scanner;

/**
 * Maze Runner
 * You are chosen to represent Hogwards in the Triwizard tournament, despite being a mere muggle. You will face three challenges, the first of which being the maze. Unfortunately you can't cast any spells or use any magical items that might assist you in such scenario. Therefore, you decide to use your legendary C# skills to write a program, that would calculate the path for you. (Is Hogwards an IT academy now?!)
 * You are given an N amount of 4 digit integers. To decode these numbers, you need to do the following:
 *
 * If the sum of the even digits is greater than the sum of the odd ones, turn left.
 * If the sum of the odd digits is greater than the sum of the even ones, turn right.
 * If the two sums are even, continue straight.
 */

public class MazeRunner {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int sumEven = 0;
		int sumOdd = 0;
		int[] path = new int[n];
		
		for(int i = 0; i<n; i++) {
			path[i] = in.nextInt();
		}

		for(int i = 0; i<n; i++) {
			sumEven = 0;
			sumOdd = 0;
			
			while(path[i]>0) {
				int digit = path[i]%10;				
				if (digit % 2 == 0){
					sumEven = sumEven + digit;
				} else {
					sumOdd = sumOdd + digit;
				}
				path[i] = path[i]/10;
			}
			if (sumEven > sumOdd) {
				System.out.println("left");
			} else if (sumEven < sumOdd) {
				System.out.println("right");
			} else {
				System.out.println("straight");
			}
			
		}
	}

}
