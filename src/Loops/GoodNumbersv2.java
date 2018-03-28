package Loops;

import java.util.Scanner;

public class GoodNumbersv2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String[] digs = input.split(" ");
		int a = Integer.parseInt(digs[0]);
		int b = Integer.parseInt(digs[1]);
		
		String[] numbersToCheck = new String[b-a+1];
		
		
		int goodCounter=0;
		
		//fill numbers to check array with strings
		for(int i=0; i<numbersToCheck.length; i++) {
			numbersToCheck[i] = Integer.toString(a);
			a++;
		}
		
		for(int i=0; i<numbersToCheck.length; i++) {
			//get the number to be verified
			int digit = Integer.parseInt(numbersToCheck[i]);
			
			// create an array with the digits
			int[] nums = new int[numbersToCheck[i].length()];
			boolean isGood = true;
			
			for(int j = 0; j<numbersToCheck[i].length(); j++) {
				
				nums[j] = numbersToCheck[i].charAt(j)-'0';
				if(nums[j]>0) {
					if(digit % nums[j] != 0) {
						isGood = false;
					}
				}
				
			}
			if (isGood) {
				goodCounter++;
			}
		}
		System.out.println(goodCounter);
	}

}
