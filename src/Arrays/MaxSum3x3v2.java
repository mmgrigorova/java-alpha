package Arrays;

import java.util.Scanner;

public class MaxSum3x3v2 {

	public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			String input = in.nextLine();
			String[] digs = input.split(" ");
			int n = Integer.parseInt(digs[0]);
			int m = Integer.parseInt(digs[1]);

			int[][] matrix = new int[n][m];

			
			for(int i = 0; i < n; i++) {
				for(int j=0; j < m; j++) {
					matrix[i][j] = in.nextInt();
				}
			}
			in.close();
			int lastColSum = 0;
			int maxColSum = Integer.MIN_VALUE;
			int colLeft = Integer.MIN_VALUE;
			int colMiddle = Integer.MIN_VALUE;
			int colRight = Integer.MIN_VALUE;

			
			for(int i = 0; i < n-2; i++) {
				for(int j=0; j < m-2; j++) {				  
					colLeft = matrix[i][j] + matrix[i+1][j] + matrix[i+2][j];
					colMiddle =  matrix[i][j+1] + matrix[i+1][j+1] + matrix[i+2][j+1];
					colRight = matrix[i][j+2] + matrix[i+1][j+2] + matrix[i+2][j+2];
					lastColSum = colLeft + colMiddle + colRight;
					if(maxColSum<lastColSum) {
						maxColSum = lastColSum;
					}
				}

			}
			System.out.println(maxColSum);
	}

}
