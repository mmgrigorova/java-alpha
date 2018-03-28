package Strings;

import java.util.Scanner;

public class SecretMessage {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String message = "";
		char[] charInput = input.toCharArray();
		in.close();
		
		for(int i=charInput.length-1; i>=0; i--) {
			if(!Character.isDigit(charInput[i])) {
				message = message+charInput[i];
			}
		}
		System.out.println(message);
	}

}
