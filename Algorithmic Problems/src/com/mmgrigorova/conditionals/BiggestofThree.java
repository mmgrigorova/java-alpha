package com.mmgrigorova.conditionals;

import java.util.Scanner;

/**
 * Biggest of Three
 * Write a program that finds the biggest of three numbers that are read from the console.
 */

public class BiggestofThree {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        float n1 = in.nextFloat();
        float n2 = in.nextFloat();
        float n3 = in.nextFloat();

        if (n1 >=-200 && n1 <= 200 && n2 >=-200 && n2 <= 200 && n3 >=-200 && n3 <= 200){
            float result = n1;
            result = Math.max(result, n1);
            result = Math.max(result, n2);
            result = Math.max(result, n3);
            
            if(result == (int)result){
                System.out.println((int) result);
            } else {
                 System.out.println(result);
            }
            
        }
        in.close();
    }
}
