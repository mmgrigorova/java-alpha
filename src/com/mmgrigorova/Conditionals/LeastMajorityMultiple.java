package Conditionals;
import java.util.Scanner;

/**
 * Least Majority Multiple
 *
 * Given five positive integers, their least majority multiple is the smallest positive integer that is divisible by at least three of them.
 * Your task is to write a program that for given distinct integers a, b, c, d and e, returns their least majority multiple.
 * For example if we have 1, 2, 3, 4 and 5 the majority multiple of the given five numbers is 4 because it is divisible by 1, 2, and 4.
 *  Another example: if we have 30, 42, 70, 35 and 90 the answer will be 210, because it is divisible by 30, 42, 70, and 35 - four out of five numbers, which is a majority.
 */

public class LeastMajorityMultiple {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		int e = in.nextInt();
		in.close();

		if(1 <= a && a <= 100 && 1 <= b && b <= 100 && 1 <= c && c <= 100 
		  && 1 <= d && d <= 100 && 1 <= e && e <= 100 
		  && a != b && a != c && a != d && a != e 
		  && b != c && b != d && b != e
		  && c != d && c != e
		  && d != e) {
			for (int i = 4; i <= 1000000000; i++) {
				int counter = 0;
				
				if(i%a == 0) { counter++;}
				if(i%b == 0) { counter++;}
				if(i%c == 0) { counter++;}
				if(i%d == 0) { counter++;}
				if(i%e == 0) { counter++;}
				
				if(counter >= 3) {
					System.out.print(i);
					break;
				}
			}
		} 
	}
}
