package com.mmgrigorova.loops;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Ранкове
 * Иванчо много обича да подрежда числа. Днес той иска да отбележи ранка на всяко число от дадена редица.
 * Най-голямото число замества с 1, второто по големина с 2 и така нататък, докато замести всички.
 * Напишете програма, която да намира и извежда ранковете на дадена редица от числа.
 */

public class Ranks {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] nums = new int[n];
		int[] ranks = new int[n];
		int[] sorted = new int[n];
		
		for(int i = 0; i<n; i++) {
			nums[i] = in.nextInt();
		}		
		
		sorted = Arrays.copyOf(nums, n);
		Arrays.sort(sorted);


		for(int i = 0 ; i<n; i++) {			
			for (int j = 0; j<n;  j++) {
				if(nums[i] == sorted[j]) {
					ranks[i] = nums.length-j;	
					break;
				}
			}
		}

		for(int i = 0; i<n; i++) {
			System.out.print(ranks[i] + " ");
		}


	}

}
