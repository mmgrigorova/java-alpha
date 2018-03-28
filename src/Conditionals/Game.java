package Conditionals;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		//GAME problem
		  Scanner in = new Scanner(System.in);
		        int n = in.nextInt();
		        String temp = Integer.toString(n);
		        int[] arr = new int[temp.length()];
				in.close();

		        if(n>=100 && n<=999){
		            for(int i=0; i<arr.length;i++) {
		                arr[i] = temp.charAt(i) - '0';
		            }
		            int allSum = arr[0]+arr[1]+arr[2];
		            int allMulty =  arr[0]*arr[1]*arr[2];
		            int sumMulty = arr[0]+arr[1]*arr[2];
		            int multySum =  arr[0]*arr[1]+arr[2];

		            int max = allSum;
		            if(allMulty > max){
		                max = allMulty;
		            }
		            if(sumMulty > max){
		                max = sumMulty;
		            }
		            if(multySum > max){
		                max = multySum;
		            }

		            System.out.println(max);
		        }

	}

}
