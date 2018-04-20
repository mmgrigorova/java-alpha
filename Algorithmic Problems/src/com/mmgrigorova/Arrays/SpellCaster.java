package com.mmgrigorova.Arrays;

import java.util.Arrays;
import java.util.Scanner;

//Incomplete

public class SpellCaster {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String[] words = input.split(" ");
		String wordsInWord = Arrays.toString(words);
		char[] wordsChars = wordsInWord.toCharArray();
		

		
		String spell = "";
		int len = wordsChars.length;
		
		for (int j = 0; j<len; j++) {
			for(int i = 0; i<words.length;i++) {
				int leny = words[i].length();
				if (leny >0 ) {
					spell = spell + words[i].charAt(leny-1);
				} else {
					spell = spell + "";
				}
				if(leny-2>0) {
					words[i] = words[i].substring(0, leny-1);
				} else if (leny-2==0){
					words[i] = "" + words[i].charAt(0);
				} else {
					words[i] = "";
				}
			}
		}
		//System.out.println(spell);
		
		for(int m=0;m<spell.length();m++) {
			char letter = spell.charAt(m);
			int pos = 0;
			
			for (int i = 65; i<122;i++) {
				if ((int)letter == i) {
					pos = i;
				}
				if(pos>=65 && pos <= 90) {
					pos = pos-64;
				} else if (pos>=97 && pos<=122) {
					pos = pos - 96;
				}
			}
			
				if(pos>=spell.length()) {
					pos = (m+pos) % spell.length();
				}
			
			if(pos>m) {
				String start = spell.substring(0, m);
				String middle = spell.substring(m+1, pos+1);
				String end = spell.substring(pos+1);
				spell = start + middle + letter + end;
			} else if(pos<m){
				String start = spell.substring(0, pos+1);
				String middle = spell.substring(pos+1, m);
				String end = spell.substring(m+1);
				spell = start + middle + letter + end;
			} 
			

		}
		System.out.println(spell);
	}
	int findPos(char a) {return 0;}
}

