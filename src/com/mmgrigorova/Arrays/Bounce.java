package com.mmgrigorova.Arrays;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 * Bounce
 * http://judge.telerikacademy.com/problem/05bounce
 *
 * TODO
 */

public class Bounce {
    static void fakeInput() {

        String test = "3 4";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }
    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();



    }
}
