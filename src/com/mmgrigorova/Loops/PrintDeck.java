package Loops;

import java.util.Scanner;

/**
 * Print Deck
 *
 * Write a program that reads a card sign(as a string) from the console and generates and prints all possible cards from a standard deck of 52 cards up to the card with the given sign(without the jokers). The cards should be printed using the classical notation (like 5 of spades, A of hearts, 9 of clubs; and K of diamonds).
 * The card faces should start from 2 to A(10 is 10).
 * Print each card face in its four possible suits: clubs, diamonds, hearts and spades.
 */

public class PrintDeck {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String card = in.nextLine();
		String[] deckFace = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		String[] deckSuite = {"spades", "clubs","hearts", "diamonds"};
		int position = 0;
		in.close();
		for(int i=0; i < deckFace.length; i++) {	
			if(card.equals(deckFace[i])) {
				position = i+1;
				break;
			} 
		}
		
		for(int i=0;i<position;i++) {
			for(int j = 0; j < deckSuite.length; j++) {
				if(j==deckSuite.length-1) {
					System.out.print(deckFace[i] + " of " + deckSuite[j]);
				} else {
					System.out.print(deckFace[i] + " of " + deckSuite[j] + ", ");
				}
			}
			System.out.println();
		}
		
		
	}

}
