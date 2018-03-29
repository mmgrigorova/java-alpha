package com.mmgrigorova.Arrays;

/**
 * Primes to N
 * Print all the prime numbers between 1 and N
 */

import java.util.Scanner;

public class PrimesofN {

    public static void primesN (){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arrayN = new int[n];

        for (int i = 0; i<n; i++){
            arrayN[i] = i+1;
        }

        for (int i = 0; i<n; i++){
            for(int j = i-1; j>0; j--){
                if (arrayN[i] % arrayN[j]==0) {
                   arrayN[i] = 10000;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if(arrayN[i] != 10000){
                System.out.print(arrayN[i] + " ");
            }
        }

        return;
    }
}
