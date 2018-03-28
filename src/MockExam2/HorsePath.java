package MockExam2;

import java.util.Scanner;

public class HorsePath {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] matrix = new int[n][n];
		int kociMove = 1;
		matrix[0][0] = kociMove;
		int i=0;
		int j=0;
	
		while(kociMove < n*n) {
					if(i-2>=0 && j-1 >=0 && matrix[i-2][j-1]==0) { //v top left --
						kociMove++;
						matrix[i-2][j-1]=kociMove;	
						i = i-2;
						j = j-1;
					} else if(i-2 >= 0 && j+1 < n && matrix[i-2][j+1]==0) { //v top right --
						kociMove++;
						matrix[i-2][j+1]=kociMove;
						i = i-2;
						j = j+1;
					} else if (i-1 >= 0 && j-2 >=0 && matrix[i-1][j-2]==0) { // h top left --
						kociMove++;
						matrix[i-1][j-2] = kociMove;
						i = i-1;
						j = j-2;
					}  else if(i-1 >= 0 && j+2 < n &&matrix[i-1][j+2]==0) { //h top right --
						kociMove++;
						matrix[i-1][j+2] = kociMove;
						i = i-1;
						j = j+2;
					} else if(i+1 < n && j-2 >=0 && matrix[i+1][j-2]==0) { // h bottom left --
						kociMove++;
						matrix[i+1][j-2]=kociMove;
						i = i+1;
						j = j-2;
					}  else if(i+1 < n && j+2 < n &&matrix[i+1][j+2]==0) { // h bottom right
						kociMove++;
						matrix[i+1][j+2] = kociMove;
						i = i+1;
						j = j+2;
					}  else if(i+2 < n && j-1 >= 0 && matrix[i+2][j-1]==0) { //v bottom left --
						kociMove++;
						matrix[i+2][j-1] = kociMove;
						i = i+2;
						j = j-1;
					}   else if(i+2 < n && j+1 < n &&matrix[i+2][j+1]==0) { // v bottom right
						kociMove++;
						matrix[i+2][j+1] = kociMove;
						i = i+2;
						j = j+1;
					} else {
						outerloop:
						for(int a=0; a<n; a++) {
								for(int b=0; b<n; b++ ) {
												
									if(matrix[a][b]==0) {
										kociMove++;
										matrix[a][b] = kociMove;
										i=a;
										j=b;					
										break outerloop;
									}
								}
							}
						}
		}
		
		for(int p = 0; p<n; p++) {
			for(int q=0; q<n; q++) {
				System.out.print(matrix[p][q]+ " ");
			}
			System.out.println();
		}
	}

}
