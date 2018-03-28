package MockExam2;

import java.util.Scanner;

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
