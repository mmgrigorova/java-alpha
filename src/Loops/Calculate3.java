package Loops;

import java.math.BigInteger;
import java.util.Scanner;
//k<n  N! / (K! * (N - K)!)
public class Calculate3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger n = in.nextBigInteger();
		BigInteger k = in.nextBigInteger();
		BigInteger sub = n.subtract(k);
		in.close();
		BigInteger nFact = BigInteger.valueOf(1);
		BigInteger kFact = BigInteger.valueOf(1);
		BigInteger subFact = BigInteger.valueOf(1);
		BigInteger result = BigInteger.valueOf(1);
		
		if((k.compareTo(BigInteger.valueOf(1)) == 1 || k.compareTo(BigInteger.valueOf(1)) == 0) && k.compareTo(n)==-1 
				&& n.compareTo(BigInteger.valueOf(100))==-1) {
			for(long i=1; i <=n.intValue();i++) {
				nFact = nFact.multiply(BigInteger.valueOf(i));
				//System.out.println(nFact);
				if(i<=k.intValue()) {
					kFact = kFact.multiply(BigInteger.valueOf(i));
					//System.out.println(kFact);
				}
				if(i<=sub.intValue()) {
					subFact = subFact.multiply(BigInteger.valueOf(i));
					//System.out.println(subFact);
				}
			} 
			result = nFact.divide(kFact.multiply(subFact));
			System.out.println(result.toString());
		}
	}
}
