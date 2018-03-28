package Loops;

import java.util.Scanner;

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
