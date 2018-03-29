package Arrays;
/**
 * Most Frequent
 * Write a program that finds the most frequent number in an array of N elements.
 */

import java.util.Scanner;

public class MostFrequent {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		 int[] array = new int[n];
		
		for(int i = 0; i<n; i++) {
			array[i] = in.nextInt();
		}
		in.close();
		
		int occuring = array[0];
		int tempOccurenece =1;
		int occurCompare = 0;
		
		for(int i = 0; i < n-1; i++) {
			tempOccurenece = 1;			
			for(int j = i+1; j < n; j++) {
				if (array[i] == array[j]){
					tempOccurenece++;
				} 
				if (tempOccurenece > occurCompare) {
					occuring = array[i];
					occurCompare = tempOccurenece;
				}				
			}
		
	}
		System.out.println(occuring + " (" +  occurCompare + " times)");
	}
}
