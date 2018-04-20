package com.mmgrigorova.Arrays;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Catalan Numbers
 * http://judge.telerikacademy.com/problem/08catalan
 * This is a calculation of the Nth Catalan Number using Memoization and Recursion. Extremely slow approach for big N.
 * Formula from https://brilliant.org/wiki/catalan-numbers/
 */

public class CatalanMem {
    public static BigInteger catalan(int n, HashMap<Integer, BigInteger> cache) {
        BigInteger result = new BigInteger("0");

        if (cache.containsKey(n)){
            result = cache.get(n);
            return result;
        }
        if (n <= 1) {
            result = BigInteger.valueOf(1);
            cache.put(n,result);
            return result;
        }

        for (int k = n-1; k >=0; k--) {

           result = result.add(catalan(k,cache)
                    .multiply(catalan(n-k-1,cache)));

        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer, BigInteger> cache = new HashMap<>();

        BigInteger result = catalan(n,cache);
        System.out.println(result);
    }
}
