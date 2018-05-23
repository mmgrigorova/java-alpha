package com.mmgrigorova.conditionals;
import java.util.Scanner;

/**
 * Каспичан Numbers
 * > Not fully implemented
 * We write the numbers as sequences of digits. The last digit of the number (the most right one) has a value as shown in the above table. The next digit on the left has a value 256 times bigger than the shown in the above table, the next digit on the left has 256*256 times bigger value than the shown in the table and so on. Your task is to write a program to convert a decimal number into its corresponding representation in Kaspichan.
 */

public class KaspichanNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Long n = Long.parseUnsignedLong(in.next());
		Long temp = n;
		long divided = 0;
		int remainder = 0;
		String kaspNumber = "";
		String[] map = new String[256];
		in.close();

		
		if(n>=0) {
		for (int i = 0; i <= 25; i++) {			
				map[i] = Character.toString((char)(i+'A'));
			}
	
		int m = 26;
		for(char i = 'a'; i<= 'i'; i++) { 
			for (char j='A'; j <= 'Z'; j++) {
				map[m] = Character.toString(i)+Character.toString(j);
				m++;
				if (m>255) {
					break;
				}
			}
		}		

		for(int i = 0; true; i++) {
			divided = (long)(temp/256);
			remainder = (int)(temp%256);
			temp = divided;
			kaspNumber = map[remainder] + kaspNumber;
			
			if (divided == 0) {
				break;
			}
		}
		
		System.out.println(kaspNumber);
	}
}
}
