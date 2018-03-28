package Conditionals;

import java.util.Scanner;

public class IntDoubleString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		in.close();

		switch(input) {
		case "integer":
			int varInt = in.nextInt();
			if (varInt >= -1000 && varInt<= 1000) {
				System.out.println(varInt + 1);
			}
			break;
		case "real":
			double varDoub = in.nextDouble();
			if (varDoub >= -1000 && varDoub <= 1000) {
				System.out.printf("%.2f",varDoub+1);
			}
			break;
		case "text":
			String varString = in.nextLine();
			System.out.println(varString + "*");
		}
	}

}
