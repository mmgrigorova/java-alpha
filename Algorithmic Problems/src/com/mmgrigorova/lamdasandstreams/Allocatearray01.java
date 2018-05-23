package com.mmgrigorova.lamdasandstreams;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Allocatearray01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        IntStream.range(0, n)
                .map(x -> x*5)
                .forEach(System.out::println);
    }
}
