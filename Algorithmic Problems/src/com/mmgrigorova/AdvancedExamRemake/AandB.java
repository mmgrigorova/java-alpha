package com.mmgrigorova.AdvancedExamRemake;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class AandB {
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
        String test = "4\n" +
                "7 5";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputN = reader.readLine().split(" ");
        int n = convert(inputN[0]);
        String[] input = reader.readLine().split(" ");
        int a = convert(input[0]);
        int b = convert(input[1]);

        int[] ab = new int[2];

        if (a <= b) {
            ab[0] = a;
            ab[1] = b;
        } else {
            ab[0] = b;
            ab[1] = a;
        }


        variate(0, n, ab, new int[n]);
    }

    private static void variate(int index, int n, int[] ab, int[] variation) {
        if (index == n) {
            for (int i = 0; i < variation.length; i++) {
                System.out.print(variation[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < ab.length; i++) {
            variation[index] = ab[i];
            variate(index + 1, n, ab, variation);
        }
    }
}
