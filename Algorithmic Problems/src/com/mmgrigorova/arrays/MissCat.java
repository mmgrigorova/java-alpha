package com.mmgrigorova.arrays;

import java.util.Scanner;

/**
 * Miss Cat
 * http://judge.telerikacademy.com/problem/32misscat
 */

public class MissCat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[11];

        for (int i = 1; i < n+1; i++) {
            int vote = in.nextInt();
            arr[vote] += 1;
        }

        in.close();

        int max = 0;
        int winner = 0;
        for (int i = 0; i < 11; i++) {
            if (arr[i] > max){
                max = arr[i];
                winner = i;
            }
        }

        System.out.println(winner);
    }
}
