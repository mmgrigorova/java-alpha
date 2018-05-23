package com.mmgrigorova.sets;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Odd Number
 * Via HashMap
 * http://judge.telerikacademy.com/problem/02oddnumber
 */

public class OddNumber {
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

        Map<Long, Integer> oddNumbers = new HashMap<>();

        for (int i = 0; i < numbersCount; i++) {
            long currentNumber = in.nextLong();

            if (!oddNumbers.containsKey(currentNumber)) {
                oddNumbers.put(currentNumber, 1);
            } else {
                int counter = oddNumbers.get(currentNumber);
                ++counter;
                oddNumbers.put(currentNumber, counter);
            }
        }

        for (Long key : oddNumbers.keySet()) {
            int value = oddNumbers.get(key);
            if (value % 2 != 0) {
                System.out.println(key);
            }
        }
    }
}
