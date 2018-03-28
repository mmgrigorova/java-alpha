package Loops;

import java.util.Scanner;

public class Numbersfrom1toN {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		for (int i = 1; i <= n; i++) {
			if(i==n) {
				System.out.print(i);
			}else {
				System.out.print(i + " ");
			}
		}
		
	}

}
