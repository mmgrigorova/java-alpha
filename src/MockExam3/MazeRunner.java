package MockExam3;

import java.util.Scanner;

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
