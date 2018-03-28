import java.util.Scanner;

public class Energy {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String n = in.nextLine();
		int sumEven = 0;
		int sumOdd = 0;
		char[] digits = n.toCharArray();

		for(int i = digits.length-1; i>=0; i--) {
				int digit = (int)(digits[i]-'0');				
				if (digit % 2 == 0){
					sumEven = sumEven + digit;
				} else {
					sumOdd = sumOdd + digit;
				}			
		}

		if (sumEven > sumOdd) {
			System.out.println(sumEven + " energy drinks");
		} else if (sumEven < sumOdd) {
			System.out.println(sumOdd + " cups of coffee");
		} else {
			System.out.println(sumEven + " of both");
		}

	}

}
