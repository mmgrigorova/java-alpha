package com.mmgrigorova.recursion;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Tribonacci
 * http://judge.telerikacademy.com/problem/18tribonacci
 * This is a solution with recursion and memoization. It is slower for N = 15000
 */

public class Tribonacci {
    static void fakeInput() {
//        String test = "1\n" +
//                "1\n" +
//                "1\n" +
//                "4";
//        String test = "2\n" +
//                "3\n" +
//                "4\n" +
//                "10";
        String test = "78373\n" +
                "23823463\n" +
                "-349573497\n" +
                "20";
        //-6430239334253
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static BigInteger tribonacci(int n, ArrayList<BigInteger> mem) {
        BigInteger result = new BigInteger(String.valueOf(0));

        if (mem.get(n) != null) {
            result = mem.get(n);
        } else {
            result = result.add(tribonacci(n - 1, mem))
                    .add(tribonacci(n - 2, mem))
                    .add(tribonacci(n - 3, mem));
            mem.set(n, result);
        }

        return result;
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int n = in.nextInt();

        ArrayList<BigInteger> mem = new ArrayList<>(Collections.nCopies(n + 1, null));
        mem.add(1, BigInteger.valueOf(n1));
        mem.add(2, BigInteger.valueOf(n2));
        mem.add(3, BigInteger.valueOf(n3));

        System.out.println(tribonacci(n, mem));
    }
}
