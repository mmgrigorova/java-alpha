package Conditionals;
import java.util.Scanner;

/**
 * Exchange if greater
 * Write a program that reads two double values from the console A and B, stores them in variables and exchanges
 * their values if the first one is greater than the second one. Use an if-statement. As a result print the values of the variables A and B, separated by a space
 */

public class ExchangeIfGreater {

	public static void main(String[] args) {
		//Exchange if greater
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();
        int a1 = 0;
        int b1 = 0;
		in.close();

        if (-100 <= a && a <= 100 && -100 <= b && b <= 100) {
            if (a > b) {
                double c = a;
                a = b;
                b = c;
            }

            if (a % 1 == 0 && a != 0) {
                a1 = (int) a;
                System.out.print(a1 + " ");
            } else {
                System.out.print(a + " ");
            }
            if (b % 1 == 0 && b != 0) {
                b1 = (int) b;
                System.out.println(b1);
            } else {
                System.out.println(b);
            }
        } else {
            System.out.println("Invalid input");
        }
	}

}
