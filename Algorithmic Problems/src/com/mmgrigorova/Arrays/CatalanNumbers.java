package com.mmgrigorova.Arrays;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Catalan Numbers
 * http://judge.telerikacademy.com/problem/08catalan
 * This is a calculation of the Nth Catalan Number using loops. Much faster than recursive solution.
 * Formula from https://brilliant.org/wiki/catalan-numbers/
 */

public class CatalanNumbers {
    public static BigInteger catalan(int n) {
        BigInteger product = new BigInteger("1");
        if (n <= 1) {
            product = BigInteger.valueOf(1);
            return product;
        }

        BigInteger top = new BigInteger("1");
        BigInteger bottom = new BigInteger("1");

        for (int k = 2; k <= n; k++) {
            top = top.multiply(BigInteger.valueOf(n+k));
            bottom = bottom.multiply(BigInteger.valueOf(k));
        }

        product = top.divide(bottom);
        return product;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger result = catalan(n);
        System.out.println(result);
    }
}
