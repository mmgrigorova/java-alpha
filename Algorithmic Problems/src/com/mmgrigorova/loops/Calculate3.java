package com.mmgrigorova.loops;

import java.math.BigInteger;
import java.util.Scanner;
//k<n  N! / (K! * (N - K)!)

/**
 * Calculate3
 * In combinatorics, the number of ways to choose N different members out of a group of N different elements (also known as the number of combinations) is calculated by the following formula: formula For example, there are 2598960 ways to withdraw 5 cards out of a standard deck of 52 cards. Your task is to write a program that calculates N! / (K! * (N - K)!) for given N and K.
 *  _Try to use only two loops._
 */
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
