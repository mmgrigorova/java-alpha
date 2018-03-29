package Loops;

import java.util.Scanner;

/**
 * Numbers Triangle
 * You are given the number N. Based on it, print triangles as follows:
 * Example: N = 3
     1
     1 2
     1 2 3
     1 2
     3
 */

public class NumbersTriangle {
    public static void printNums(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i<n; i++){
            a[i] = i+1;
        }

        for (int i = 0; i<=n; i++){
            for(int j = 0; j<i; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();
        }
        for (int i = n-1; i>=0; i--){
            for(int j = 0; j<i; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();
        }

    }
}
