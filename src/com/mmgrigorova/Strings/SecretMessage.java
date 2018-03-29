package Strings;

import java.util.Scanner;

/**
 * Тайно съобщение
 * Гошо много иска да се научи да разчита тайни съобщения. Съобщението се съдържда в буквите, но трябва да бъдат прочетени отзад напред.
 *
 * Напишете програма, която да помага на Гошо с четенето на тайни съобщения.
 */

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
