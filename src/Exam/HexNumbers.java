import java.util.Scanner;

public class HexNumbers {

	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		int n = in.nextInt();
		int[] numbers = new int[n];
		String[] hexNumbers = new String[n];
		String concat = "";
		
		for (int i = 0; i<n; i++) {
			numbers[i] = in.nextInt();
			hexNumbers[i] = Integer.toHexString(numbers[i]);
			concat = concat + hexNumbers[i];
		}
		in.close();
//concat = "11ADD";
		int tempLen = 1;
		int maxLen = -1;
		int timesFound = 0;
		char[] concatNums = concat.toCharArray();
		char previous = 0;

//			System.out.println(concat);

		
		
		for(int i = 0; i<concatNums.length; i++) {

			if(concatNums[i]==previous) {
				tempLen++;
				
			} else {
				tempLen=1;
		
				}
			if (tempLen == maxLen && tempLen>0) {
				timesFound++;
			}
			if (tempLen > maxLen) {
				maxLen = tempLen;
				timesFound = 1;
			}
			
			previous = concatNums[i];
		}
		System.out.println(maxLen + " " + timesFound);
	}

}
