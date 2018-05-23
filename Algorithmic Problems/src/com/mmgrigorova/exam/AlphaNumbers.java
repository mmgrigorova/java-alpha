import java.util.Scanner;

public class AlphaNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] numbers = new int[7];

		
		for (int i = 0; i<7; i++) {
			numbers[i] = in.nextInt();
		}
		in.close();
		for (int i = 0; i<7; i++) {
			int maxDiff = 0;
			int number = numbers[i];
			int a = number%10;
			number = number/10;
			
			int b = number%10;
			number = number/10;
			
			int c = number%10;
			int sumDigit = a + b + c;
			int lastDigitSum =0;
//			if(sumDigit >0 && sumDigit < 11) {
//				 lastDigitSum = sumDigit;
//			} else if(sumDigit >=11) {
				 lastDigitSum = sumDigit%10;
//			}
			
			maxDiff = Math.max(maxDiff, a-b);
			maxDiff = Math.max(maxDiff, a-c);
			maxDiff = Math.max(maxDiff, b-a);
			maxDiff = Math.max(maxDiff, b-c);
			maxDiff = Math.max(maxDiff, c-a);
			maxDiff = Math.max(maxDiff, c-b);

			
			if(maxDiff>lastDigitSum) {
				System.out.println(numbers[i]);
			}
		}

		
	}

}
