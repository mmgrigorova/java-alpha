package com.mmgrigorova.loops;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Tribonacci
 * http://judge.telerikacademy.com/problem/18tribonacci
 * This is a solution using loops.
 */

public class TribonacciLoops {
    static void fakeInput() {
        String test = "1\n" +
                "1\n" +
                "1\n" +
                "4";
//        String test = "2\n" +
//                "3\n" +
//                "4\n" +
//                "10";
//        String test = "9684\n" +
//                "37463\n" +
//                "238428\n" +
//                "3";
        //238428
//        String test = "78373\n" +
//                "23823463\n" +
//                "-349573497\n" +
//                "20";
        //-6430239334253
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static BigInteger tribonacciL(int n, int n1, int n2, int n3) {
        BigInteger result = new BigInteger(String.valueOf(0));
        BigInteger num1 = BigInteger.valueOf(n1);
        BigInteger num2 = BigInteger.valueOf(n2);
        BigInteger num3 = BigInteger.valueOf(n3);


        if (n == 1) {
            result = num1;
        } else if (n == 2) {
            result = num2;
        } else if (n == 3) {
            result = num3;
        } else {
            for (int i = 4; i < n + 1; i++) {
                result = BigInteger.valueOf(0);

                result = result.add(num1)
                        .add(num2)
                        .add(num3);
                num1 = num2;
                num2 = num3;
                num3 = result;

            }
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

        System.out.println(tribonacciL(n, n1, n2, n3));
    }
}
