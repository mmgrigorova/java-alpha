package com.mmgrigorova.Arrays;

/**
 * UNRESOLVED
 * Subset of Sum S
 * We are given an array of integers and a number S. Write a program to find if there exists a subset of the elements
 * of the array that has a sum S.
 */

import java.util.Scanner;

	public class SubsetofSumS {

	public static void subsetS() {
//		Scanner in = new Scanner(System.in);
//		int s = in.nextInt();
//		in.nextLine();
//		String input = in.nextLine();
//		in.close();
		String isSum = "no";

		int s = 216;
		String input = "12 20 21 14 2 31 5 27 28 11 24 26 11 4 14 27 14";

		String[] dataArray = input.split(" ");
		int[] arrayInt = new int[dataArray.length];
		
		for(int i = 0; i<arrayInt.length; i++) {
			arrayInt[i] = Integer.parseInt(dataArray[i]);
		}
		
		int sum = 0;
		
		
		for(int i = 0; i<arrayInt.length-1; i++) {
			sum = arrayInt[i];		
			
			for(int j = i+1; j<arrayInt.length; j++) {
				sum = sum+arrayInt[j];
				if(sum==s) {
					isSum = "yes";
				} else if(sum>s) {
					sum=sum-arrayInt[j];
				}
			}
		}
		System.out.println(isSum);
		}
	}

