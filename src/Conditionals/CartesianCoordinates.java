package Conditionals;
import java.util.Scanner;

public class CartesianCoordinates {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		float x = input.nextFloat();
		float y = input.nextFloat();
		//float f = x; 
		
		if(x >= -2000000000001337F && x <= 2000000000001337F 
			&& y >= -2000000000001337F && y <= 2000000000001337F) {
			if(x==0) {
				if(y==0) {
					System.out.println(0);
				} else {
					System.out.println(5);
				}
			} else if (x > 0) {
				if (y > 0) {
					System.out.println(1);
				} else if (y < 0) {
					System.out.println(4);
				} else {
					System.out.println(6);
				}
			} else /*x < 0*/{
				if (y > 0) {
					System.out.println(2);
				} else if (y < 0) {
					System.out.println(3);
				} else {
					System.out.println(6);
				}
			}
		
		}
		input.close();
	}
}
