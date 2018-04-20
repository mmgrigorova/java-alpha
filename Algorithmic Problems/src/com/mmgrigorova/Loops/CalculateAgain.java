package com.mmgrigorova.Loops;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Calculate Again
 * Write a program that calculates N! / K! for given N and K.
 * k<n
 */
public class CalculateAgain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger n = in.nextBigInteger();
		BigInteger k = in.nextBigInteger();
		in.close();
		BigInteger nFact = BigInteger.valueOf(1);
		BigInteger kFact = BigInteger.valueOf(1);
		BigInteger result = BigInteger.valueOf(1);
		
		if(k.compareTo(BigInteger.valueOf(1)) == 1 && k.compareTo(n)==-1 
				&& n.compareTo(BigInteger.valueOf(100))==-1) {
			for(int i=1; i <=n.intValue();i++) {
				nFact = nFact.multiply(BigInteger.valueOf(i));
				//System.out.println(nFact);
				if(i<=k.intValue()) {
					kFact = kFact.multiply(BigInteger.valueOf(i));
					//System.out.println(kFact);
				}
			} 
			result = nFact.divide(kFact);
			System.out.println(result);
		}
	}
}
