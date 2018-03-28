package MockExam3;

import java.util.Scanner;

public class Papercutter {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] sheets = {"A10", "A9", "A8", "A7", "A6", "A5", "A4", "A3", "A2", "A1", "A0"};
		String isUsed = "used";
		
		if(n%2 != 0) {
			sheets[0] = isUsed;
			n=(n-1);
		} 
	

		for(int i = sheets.length-1;i>=0; i--) {
			if(n >= Math.pow(2,i)) {
				sheets[i] = isUsed;
				if(n-Math.pow(2, i)>0) {
					n = (int)(n-Math.pow(2, i));
				} else {break;};		
			}
		}
		
	for(int i = sheets.length-1; i>=0; i--) {
			if(sheets[i] != isUsed) {
				System.out.println(sheets[i]);
			} else {
				continue;
			}
		}
	}

}
