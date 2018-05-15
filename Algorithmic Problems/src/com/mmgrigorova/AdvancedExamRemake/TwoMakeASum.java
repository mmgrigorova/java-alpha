package com.mmgrigorova.AdvancedExamRemake;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class TwoMakeASum {
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

    static void fakeInput() {
        String test = "1 2 4 4\n" +
                "4 5 8";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] sequenceString = reader.readLine().split(" ");
        String[] sumsString = reader.readLine().split(" ");

        int[] sequence = new int[sequenceString.length];
        int[] sums = new int[sumsString.length];

        for (int i = 0; i < sequenceString.length; i++) {
            sequence[i] = convert(sequenceString[i]);
        }

        int result = 0;

        for (int i = 0; i < sumsString.length; i++) {
            sums[i] = convert(sumsString[i]);
            int sum = sums[i];
            result += isSum(sum, sequence);
        }

        System.out.println(result);


    }

    private static int isSum(int sum, int[] sequence) {
        HashSet<Integer> remains = new HashSet<>();

        for (int i = 0; i < sequence.length; i++) {
            if(remains.contains(sequence[i])){
                return 1;
            } else {
                remains.add(sum-sequence[i]);
            }
        }
        return 0;
    }

}
