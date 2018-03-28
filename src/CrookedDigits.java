import java.util.Scanner;

public class CrookedDigits {

	public static void main(String[] args) {
		// CROOKED DIGIT problem
		 Scanner in = new Scanner(System.in);
		        String number = in.next();
		        int tempSum = 0;
		        char[] input = number.toCharArray();
				in.close();

		         while (number.length() > 1) {
		             for (int i = 0; i < number.length(); i++) {
		                 if (Character.isDigit(input[i])) {
		                     tempSum = tempSum + Integer.parseInt(Character.toString(input[i]));
		                 }
		            }
		             number = Integer.toString(tempSum);
		             input = number.toCharArray();
		             tempSum = 0;
		         }
		        System.out.println(number);

	}

}
