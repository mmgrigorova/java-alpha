package com.mmgrigorova;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FakeMain {
    /**
     * The fakeInput() function is mimicking user input through the console. Useful for testing the problems.
     */
    static void fakeInput() {
        String test = "3\n" +
                "aabc\n" +
                "2";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    /**
     * Converts line read from Buffer into a number
     * @param s - string read from line
     * @return - integer
     */
    private static int convert(String s) {
        int value = 0;
        int flag = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                flag = -1;
            } else {
                value = value * 10 + (s.charAt(i) - '0');
            }
        }
        if (flag == -1) {
            return -value;
        }
        return value;
    }

    public static void main(String[] args) throws IOException {
        /**
         * Print an ArrayList
         */
        ArrayList<String> result = new ArrayList<>();
        result.forEach(System.out::println);

        /**
         * Sort an ArrayList
         */
        result.sort(String::compareTo);

        /**
         * Scanner replacement - StringBuilder
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" "); // readLine() requires adding exception.
        int n = convert(input[0]); // convert(String s) added above
        int k = convert(input[1]);

        /**
         * Initialize ArrayList with values through Stream. Much slower approach than using loops.
         */
        List<Boolean> isPrime = Stream.generate(() -> true).limit(n+1).collect(Collectors.toList());

        /**
         * Navigate through a Matrix
         * Define a coefficient to add to the Rows and Cols. To iterate - add it to row/col depending on the direction.
         * If direction needs to be changed, multiply the coefficient by -1 so that it starts decreasing/increasing
         * the rows/cols
         */


    }
}