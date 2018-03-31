package com.mmgrigorova.Arrays;

import java.math.BigInteger;
import java.util.Scanner;

public class AboveTheMainDiagonal {
    public static void aboveDiagonal() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        BigInteger sum = BigInteger.valueOf(0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    BigInteger toAdd = BigInteger.valueOf((long) Math.pow(2, i + j));
                    sum = sum.add(toAdd);
                }
            }
        }
        System.out.println(sum);
    }

}
