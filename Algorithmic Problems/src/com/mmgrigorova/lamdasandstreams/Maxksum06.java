package com.mmgrigorova.lamdasandstreams;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Maxksum06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int maxSumOfK = IntStream.generate(in::nextInt)
                .limit(n)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(k)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(maxSumOfK);
    }
}
