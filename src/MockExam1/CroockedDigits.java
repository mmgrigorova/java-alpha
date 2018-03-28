package MockExam1;

import java.util.Scanner;

public class CroockedDigits {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		int sum = 0;
		int len = input.length();
		
		if (len==1) {
			System.out.println(input);
		}else {
			while (len>1){
				char[] array = input.toCharArray();
				sum = 0;
				for(int i=0; i<len ;i++) {
					if(array[i] != '.' && array[i] != '-') {
						sum = sum + (array[i]-'0');
						
					}
				}
				len = String.valueOf(sum).length();
				input = Integer.toString(sum);
				
			}
		System.out.println(sum);
		}
		in.close();
		
	}

}
