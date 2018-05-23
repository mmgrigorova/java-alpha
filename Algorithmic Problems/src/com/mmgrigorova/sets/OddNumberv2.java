package com.mmgrigorova.sets;


import java.io.ByteArrayInputStream;
import java.util.*;

/**
 * Odd Number
 * Via HashMap
 * http://judge.telerikacademy.com/problem/02oddnumber
 */

public class OddNumberv2 {
    static void fakeInput() {
        String test = "3\n" +
                "2\n" +
                "-1\n" +
                "2\n";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);

        int numbersCount = in.nextInt();

        Set<Long> oddNumber = new HashSet<>();

        for (int i = 0; i < numbersCount; i++) {
            long number = in.nextLong();
            if(oddNumber.contains(number)){
                oddNumber.remove(number);
            } else {
                oddNumber.add(number);
            }
        }
        for (Long aLong : oddNumber) {
            System.out.println(aLong);
        }
    }
}
