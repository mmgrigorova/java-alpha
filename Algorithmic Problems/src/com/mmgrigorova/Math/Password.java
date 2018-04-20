package com.mmgrigorova.Math;

import java.util.Scanner;
/*
 * Разменят се първата и шестата, втората и петата, третата и четвъртата цифри на N;
Пресмятат се частното и остатъка при деление на новополученото число на цялото положително число K;
Събират се получените частно и остатък.
 */
public class Password {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		String num = String.valueOf(n);
		int password = 0;
		
		if ( 99999 < n && n < 1000000 && 0 < k && k < 1000) {
			
			char[] number = num.toCharArray();
			char temp = 0;
			temp = number[0];
			number[0] = number[5];
			number[5] = temp;
			
			temp = number[1];
			number[1] = number[4];
			number[4] = temp;
			
			temp = number[2];
			number[2] = number[3];
			number[3] = temp;
			
			n = Integer.parseInt(new String(number));
			password = (n/k) + (n%k);
			
			System.out.println(password);
//			for(int i = 0; i<number.length; i++) {
//				System.out.print(number[i] + " ");
//			}
		}
	}

}
