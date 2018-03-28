package MockExam2;

import java.util.Scanner;

public class Speeds {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int c = in.nextInt();
		int[] cars = new int[c];
//		int[] cars = {3,3,9,100};
//		int[] cars = {500,4,3,9,100,9,8,9,10,11,12,13};//12
//		int[] cars = {1500, 4, 6, 5, 3, 3, 9, 100, 2, 3, 1}; //11
//		int[] cars = {1,1,1,1};
//		int[] cars = {1,2,3,4,5};
		for(int i = 0; i<c; i++) {
			cars[i] = in.nextInt();
		}
		in.close();
		int longestGroup = 1;
		int longestGroupSpeed = cars[0];
		int currentGroup = 1;
		int currentGroupSpeed = cars[0];
		int firstInGroup = cars[0];
		
		for(int i = 1; i < c;) {
			while(i<=c && firstInGroup < cars[i] ) {
				currentGroup++;
				currentGroupSpeed = currentGroupSpeed + cars[i];
				if(i+1<c) {i++;} else break;
			}
			if(currentGroup > longestGroup) {
				longestGroup = currentGroup;
				longestGroupSpeed = currentGroupSpeed;
				currentGroupSpeed = 0;
				currentGroup = 1;
				firstInGroup = cars[i];
			} else if(currentGroup == longestGroup) {
				longestGroupSpeed = Math.max(longestGroupSpeed, currentGroupSpeed);
				currentGroup = 1;
				currentGroupSpeed = cars[i];
				firstInGroup = cars[i];
				i++;
			} else if(currentGroup < longestGroup){
				firstInGroup = cars[i];
				currentGroupSpeed = cars[i];
				i++;
			}
		
		}
		
		System.out.println(longestGroupSpeed);
	}

}
