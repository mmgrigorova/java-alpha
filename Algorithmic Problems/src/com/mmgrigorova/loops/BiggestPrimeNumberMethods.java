package com.mmgrigorova.loops;

import java.util.Scanner;

public class BiggestPrimeNumberMethods {

    static boolean isPrime(long number) {
        boolean isPrime = true;
        // We are checking up to the square of number. After that the dividers are the same
        long maxDivider = (long) Math.sqrt(number);

        for (int divider = 2; divider <= maxDivider; divider++) {
            if (number % divider == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    static long biggestPrime(long n) {
        long biggestPrime = 0;
        for (long number = n; number > 1; number--) {
            if (isPrime(number)) {
                biggestPrime = number;
                break;
            } else {
                continue;
            }
        }
        return biggestPrime;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(biggestPrime(n));

    }
}
