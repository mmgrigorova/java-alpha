package com.mmgrigorova.LambdasAndStreams;

import java.util.Arrays;
import java.util.Scanner;

public class AppearanceCount {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] array = in.nextLine().split(" ");
        int x = in.nextInt();

        System.out.println(Arrays.stream(array)
                .mapToInt(Integer::parseInt)
                .filter(elem -> x == elem)
                .count());
    }
}
