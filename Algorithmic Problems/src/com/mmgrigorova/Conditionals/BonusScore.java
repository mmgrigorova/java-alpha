package com.mmgrigorova.Conditionals;
import java.util.Scanner;

/**
 * Bonus Score
 * Write a program that applies bonus score to given score in the range [1&hellip;9] by the following rules:
 *
 * If the score is between 1 and 3, the program multiplies it by 10.
 * If the score is between 4 and 6, the program multiplies it by 100.
 * If the score is between 7 and 9, the program multiplies it by 1000.
 * If the score is less than 0 or more than 9, the program prints "invalid score".
 */

public class BonusScore {

	public static void main(String[] args) {
		 //Bonus Score
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if(n<1 || n>9){
            System.out.println("invalid score");
        } else if(n<4){
            System.out.println(n*10);
        } else if(n<7){
            System.out.println(n*100);
        } else {
            System.out.println(n*1000);
        }
        in.close();
	}
	
}
