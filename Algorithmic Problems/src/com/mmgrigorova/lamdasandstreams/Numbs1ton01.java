package com.mmgrigorova.lamdasandstreams;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Numbs1ton01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        IntStream.range(1,in.nextInt()+1)
                .forEach(x -> System.out.printf("%d ", x));
    }
}
