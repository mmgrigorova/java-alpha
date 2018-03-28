package Conditionals;
import java.util.Scanner;

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
