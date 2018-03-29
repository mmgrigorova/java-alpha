package MockExam2;

import java.util.Scanner;

/**
 * Game
 *
 * Three friends came up with a game for having fun in the break between the classes. One of them says a three-digit number and the others use it to form a mathematical expressions by using operators for sum and multiplication between the digits of that number.
 *  The winner is the first one who founds the biggest number that is a result of the above mentioned rules.
 *  Write a program 'game', which prints out that biggest number.
 */

public class GameExam {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int a = n/100;
		int b = (n-a*100)/10;
		int c = n-a*100-b*10;
		
		int max = -1;
		max = Math.max(max,a + b + c);
		max = Math.max(max,a * b + c);
		max = Math.max(max,a + b * c);
		max = Math.max(max,a * b * c);
		
		System.out.println(max);
	}

}
