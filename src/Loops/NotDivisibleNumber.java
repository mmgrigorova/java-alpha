package Loops;

import java.util.Scanner;

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


