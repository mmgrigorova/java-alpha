package com.mmgrigorova.Arrays;

public class NFactorial {
    public static long nFactorial(int n){
        long result;
        if (n==1||n==0){
            result = 1;
        } else if (n==2){
            result = 2;
        }
        else {
            result = n*nFactorial(n-1);
        }
        return result;
    }
}
