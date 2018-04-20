package com.mmgrigorova.Conditionals;
import java.util.Scanner;

/**
 * Check for Play Card
 * Classical play cards use the following signs to designate the card face: 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K and A.
 * Write a program that enters a string and prints "yes CONTENT_OF_STRING" if it is a valid card sign or "no
 * CONTENT_OF_STRING" otherwise.
 */


public class CheckforPlayCard {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.next();
		in.close();
		if(1 <= input.length() && input.length()<=5)
		switch(input) {
		case "2": 
			System.out.println("yes " + input);
			break;
		case "3": 
			System.out.println("yes " + input);
			break;
		case "4": 
			System.out.println("yes " + input);
			break;
		case "5": 
			System.out.println("yes " + input);
			break;
		case "6": 
			System.out.println("yes " + input);
			break;
		case "7": 
			System.out.println("yes " + input);
			break;
		case "8": 
			System.out.println("yes " + input);
			break;
		case "9": 
			System.out.println("yes " + input);
			break;
		case "10": 
			System.out.println("yes " + input);
			break;
		case "J": 
			System.out.println("yes " + input);
			break;
		case "Q": 
			System.out.println("yes " + input);
			break;
		case "K": 
			System.out.println("yes " + input);
			break;
		case "A": 
			System.out.println("yes " + input);
			break;
		default: System.out.println("no " + input);
		} 
	}

}
