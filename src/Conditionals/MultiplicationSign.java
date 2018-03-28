package Conditionals;
import java.util.Scanner;

public class MultiplicationSign {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		float n1 = in.nextFloat();
		float n2 = in.nextFloat();
		float n3 = in.nextFloat();
		in.close();

		if(n1 == 0 || n2 == 0 || n3 == 0) {
			System.out.println(0);
		} else if ((n1 < 0 && n2 < 0 && n3 > 0 ) || (n1 > 0 && n2 > 0 && n3 > 0 ) || (n1 > 0 && n2 < 0 && n3 < 0 ) || (n1 < 0 && n2 > 0 && n3 < 0 )) {
			System.out.println("+");
		} else {
			System.out.println("-");
		}	
	}
}
