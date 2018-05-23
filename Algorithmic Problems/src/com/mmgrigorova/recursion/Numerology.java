package com.mmgrigorova.recursion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Numerology
 * http://judge.telerikacademy.com/problem/01numerology
 */

public class Numerology {
    public static void numerology(String digits, int[] counts){
        if(digits.length() == 1){
            int result = digits.charAt(0)-'0';
            counts[result] ++;
            return;
        }

        for (int i = 0; i < digits.length()-1; i++) {
            int a = digits.charAt(i)-'0';
            int b = digits.charAt(i+1)-'0';
            int c = (a + b) * (a ^ b) % 10;

            String nextNumber = digits.substring(0,i) + c + digits.substring(i+2);
            numerology(nextNumber,counts);
        }
    return;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String digits = in.nextLine();
        int[] counts = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        numerology(digits,counts);
        Arrays.stream(counts).forEach(count -> System.out.print(count + " "));
    }
}

//0 1006 0 286 0 1473 0 205 0 2070