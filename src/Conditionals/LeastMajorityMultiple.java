package Conditionals;
import java.util.Scanner;

public class LeastMajorityMultiple {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		int e = in.nextInt();
		in.close();

		if(1 <= a && a <= 100 && 1 <= b && b <= 100 && 1 <= c && c <= 100 
		  && 1 <= d && d <= 100 && 1 <= e && e <= 100 
		  && a != b && a != c && a != d && a != e 
		  && b != c && b != d && b != e
		  && c != d && c != e
		  && d != e) {
			for (int i = 4; i <= 1000000000; i++) {
				int counter = 0;
				
				if(i%a == 0) { counter++;}
				if(i%b == 0) { counter++;}
				if(i%c == 0) { counter++;}
				if(i%d == 0) { counter++;}
				if(i%e == 0) { counter++;}
				
				if(counter >= 3) {
					System.out.print(i);
					break;
				}
			}
		} 
	}
}
