import java.util.Scanner;

/**
 * Biggest Prime Number
 * Write a program that finds and prints the biggest prime number which is <= N.
 */

public class BiggestPrimeNumber {

	public static void main(String[] args) {
		//Biggest Prime Number
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean isPrime = true;
        int prime = 1;
		in.close();

        if(n>=2 && n<= 10000000){
                for(int i = n; i > 1; i--){
                    isPrime = true;
                    for(int j=2; j<=i-1; j++){
                      if(i%j==0){
                          isPrime = false;
                          break;
                      }
                  }
                    if(isPrime){
                        prime=i;
                        break;
                    }
                }
        }else{
            System.out.println("invalid input");
        }
        System.out.println(prime);
	}

}
